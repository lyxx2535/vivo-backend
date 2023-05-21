package com.example.vivo_backend.controller;

import com.example.vivo_backend.service.PictureService;
import com.example.vivo_backend.utils.OssUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Api(tags = "")
@CrossOrigin
public class OSSController {

    @Autowired
    private OssUtil ossUtil;

    @Autowired
    private PictureService pictureService;

    //处理文件上传
    @PostMapping("/imageUpload")
    @ResponseBody
    @ApiOperation(value = "上传本地图片到阿里云OSS",notes = "图片" )
    @ApiParam(name = "file", value = "本地图片", required = true)
    public String homeImageUpload(@RequestParam("file") MultipartFile file) {
        try {
            String homeImage = ossUtil.checkImage(file);//此处是调用上传服务接口
            pictureService.addPicture(homeImage);
            return homeImage;
        }catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }
}
