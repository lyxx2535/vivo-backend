package com.example.vivo_backend;

import com.example.vivo_backend.controller.OSSController;
import com.example.vivo_backend.controller.ReviewController;
import com.example.vivo_backend.vo.review.ReviewVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;

@SpringBootTest
public class PictureTests {
    @Autowired
    OSSController ossController;
    @Autowired
    ReviewController reviewController;

    @Test
    @Transactional
    @Rollback()
    void pictureTest() throws IOException {
        ReviewVO reviewVO = new ReviewVO(0,100,"去大明湖","自然景点",new Date(326732389),"不错");
        File file1 = new File("src/main/resources/static/img/pic1.jpg");
        MockMultipartFile mFile1 = new MockMultipartFile("files", "pic1.jpg",
                String.valueOf(MediaType.IMAGE_JPEG), new FileInputStream(file1));
        String url1 = ossController.homeImageUpload(mFile1);

        File file2 = new File("src/main/resources/static/img/pic2.jpg");
        MockMultipartFile mFile2 = new MockMultipartFile("files", "pic2.jpg",
                String.valueOf(MediaType.IMAGE_JPEG), new FileInputStream(file2));
        String url2 = ossController.homeImageUpload(mFile2);


        reviewController.addReview(reviewVO);
        reviewController.getReviewListByUserId(reviewVO.getUserId());
    }
}
