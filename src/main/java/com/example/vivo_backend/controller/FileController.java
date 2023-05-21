package com.example.vivo_backend.controller;

import com.example.vivo_backend.constant.FileType;
import com.example.vivo_backend.service.FileService;
import com.example.vivo_backend.vo.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/file")
@Api(tags = "文件相关接口")
@CrossOrigin
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    @ApiOperation(value = "上传文件接口", notes = "该方法会返回存储文件的访问url，可以在浏览器输入url直接访问文件")
    @ApiImplicitParam(name = "fileType", value = "上传的文件类型", defaultValue = "REVIEW_PIC", required = true)
    public ResponseVO<String> upload(@RequestBody MultipartFile file, @RequestParam FileType fileType) {
        return new ResponseVO<>(fileService.upload(file, fileType));
    }

//    @GetMapping("/download/{fileType}/{fileName}")
//    @ApiOperation(value = "下载文件接口")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "fileName", value = "文件文件名", required = true),
//            @ApiImplicitParam(name = "fileType", value = "文件类型", defaultValue = "PDF_DOCUMENT", required = true)
//    })
//    public void download(@PathVariable FileType fileType, @PathVariable String fileName, HttpServletResponse response) {
//        fileService.download(fileName, fileType, response);
//    }
}
