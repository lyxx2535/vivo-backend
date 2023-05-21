package com.example.vivo_backend.service.impl;

import com.example.vivo_backend.constant.FileType;
import com.example.vivo_backend.entity.filepath.factory.FilePathFactory;
import com.example.vivo_backend.entity.filepath.strategy.FilePath;
import com.example.vivo_backend.exception.InternalServerError;
import com.example.vivo_backend.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public String upload(MultipartFile file, FileType fileType) {
        FilePath filePath = FilePathFactory.getFilePathInstance(fileType);
        filePath.checkDir();
        String storedFilePath, randomUUID = UUID.randomUUID().toString();
        String fileName = randomUUID + "_" + file.getOriginalFilename();
        fileName = fileName.replaceAll(" ", "");
        storedFilePath = filePath.getStoredFilePath(fileName);
        // 保存文件
        try {
            file.transferTo(new File(storedFilePath));
            fileName = URLEncoder.encode(fileName, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServerError(e.getMessage());
        }

        return filePath.getDownLoadPath(fileName);
    }

    @Override
    public void download(String fileName, FileType fileType, HttpServletResponse response) {
        String storedFilePath;
        // 设置返回的文件类型并得到文件存储的文件夹
        FilePath filePath = FilePathFactory.getFilePathInstance(fileType);
        storedFilePath = filePath.getStoredFilePath(fileName);
        response.setContentType(filePath.getContentType());
        try {
            FileCopyUtils.copy(Files.newInputStream(Paths.get(storedFilePath)), response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
