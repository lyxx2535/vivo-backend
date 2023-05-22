package com.example.vivo_backend.utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Component
public class OssUtil {
    //阿里云OSS地址，这里看根据你的oss选择
    @Value("${spring.aliyun.oss.file.endpoint}")
    private String endpoint;
    //阿里云OSS账号
    @Value("${spring.aliyun.oss.file.keyid}")
    private String accessKeyId;
    //阿里云OSS密钥
    @Value("${spring.aliyun.oss.file.keysecret}")
    private String accessKeySecret;
    //阿里云OSS上的存储块bucket名字
    @Value("${spring.aliyun.oss.file.bucketname}")
    private String bucketName;
    //阿里云图片文件存储目录
    @Value("${spring.aliyun.oss.file.filedir}")
    private String filedir = "val/";
    //避免每次需要随机数时都建立新常量，创建一个常量
    private static final Random RANDOM = new Random();


    /**
     * 上传图片
     * @param file
     * @return 图片的路径
     */
    public String uploadImg2Oss(MultipartFile file) {
        if (file.getSize() > 1024 * 1024 *20) { //20M
            return "图片太大";
        }

        try {
            //为避免空指针异常，将代码放进try-catch
            String originalFilename = file.getOriginalFilename();
            String substring = Objects.requireNonNull(originalFilename).substring(originalFilename.lastIndexOf(".")).toLowerCase();
            String name = RANDOM.nextInt(10000) + System.currentTimeMillis() + substring;
            InputStream inputStream = file.getInputStream();
            this.uploadFile2OSS(inputStream, name);
            return name;
        } catch (Exception e) {
            return "上传失败";
        }
    }
    /**
     * 上传图片获取fileUrl
     * @param instream
     * @param fileName
     * @return
     */
    private String uploadFile2OSS(InputStream instream, String fileName) {
        String ret = "";
        try {
            //创建上传Object的Metadata
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(instream.available());
            objectMetadata.setCacheControl("no-cache");
            objectMetadata.setHeader("Pragma", "no-cache");
            objectMetadata.setContentType(getcontentType(fileName.substring(fileName.lastIndexOf("."))));
            objectMetadata.setContentDisposition("inline;filename=" + fileName);
            //上传文件

            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            PutObjectResult putResult = ossClient.putObject(bucketName, filedir + fileName, instream, objectMetadata);
            ret = putResult.getETag();
        } catch (IOException e) {
            e.getMessage();
        } finally {
            try {
                instream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    public static String getcontentType(String filenameExtension) {
        if (filenameExtension.equalsIgnoreCase(".bmp")) {
            return "image/bmp";
        }
        if (filenameExtension.equalsIgnoreCase(".gif")) {
            return "image/gif";
        }
        if (filenameExtension.equalsIgnoreCase(".jpeg") ||
                filenameExtension.equalsIgnoreCase(".jpg") ||
                filenameExtension.equalsIgnoreCase(".png")) {
            return "image/jpg";
        }
        if (filenameExtension.equalsIgnoreCase(".html")) {
            return "text/html";
        }
        if (filenameExtension.equalsIgnoreCase(".txt")) {
            return "text/plain";
        }
        if (filenameExtension.equalsIgnoreCase(".vsd")) {
            return "application/vnd.visio";
        }
        if (filenameExtension.equalsIgnoreCase(".pptx") ||
                filenameExtension.equalsIgnoreCase(".ppt")) {
            return "application/vnd.ms-powerpoint";
        }
        if (filenameExtension.equalsIgnoreCase(".docx") ||
                filenameExtension.equalsIgnoreCase(".doc")) {
            return "application/msword";
        }
        if (filenameExtension.equalsIgnoreCase(".xml")) {
            return "text/xml";
        }
        return "image/jpg";
    }

    /**
     * 获取图片路径
     * @param fileUrl 文件路径
     * @return
     */
    public String getImgUrl(String fileUrl) {
        if (!Objects.equals(fileUrl, "")) {
            String[] split = fileUrl.split("/");
            String url =  this.getUrl(this.filedir + split[split.length - 1]);
            String[] spilt1 = url.split("\\?");
            return spilt1[0];
        }
        return null;
    }

    /**
     * 获得url链接
     *
     * @param key
     * @return
     */
    public String getUrl(String key) {
        // 设置URL过期时间为10年  3600l* 1000*24*365*10
        Date expiration = new Date(new Date().getTime() + 3600L * 1000 * 24 * 365 * 10);
        // 生成URL
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
        if (url != null) {
            return url.toString();
        }
        return null;
    }

    /**
     * 多图片上传
     * @param fileList
     * @return
     */
    public String checkList(List<MultipartFile> fileList) {
        String  fileUrl = "";
        String  str = "";
        StringBuilder photoUrl = new StringBuilder();
        for(int i = 0;i< fileList.size();i++){
            fileUrl = uploadImg2Oss(fileList.get(i));
            str = getImgUrl(fileUrl);
            if(i == 0){
                photoUrl = new StringBuilder(str);
            }else {
                photoUrl.append(",").append(str);
            }
        }
        return photoUrl.toString().trim();
    }

    /**
     * 单个图片上传
     * @param file
     * @return
     */
    public String checkImage(MultipartFile file){
        String fileUrl = uploadImg2Oss(file);
        String str = getImgUrl(fileUrl);
        return str.trim();
    }
}
