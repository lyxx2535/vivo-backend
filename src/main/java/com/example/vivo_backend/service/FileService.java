package com.example.vivo_backend.service;

import com.example.vivo_backend.constant.FileType;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface FileService {
    String upload(MultipartFile file, FileType fileType);

    void download(String fileName, FileType fileType, HttpServletResponse response);
}
