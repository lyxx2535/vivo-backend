package com.example.vivo_backend;

import com.example.vivo_backend.controller.GuideController;
import com.example.vivo_backend.controller.ReportController;
import com.example.vivo_backend.controller.ReviewController;
import com.example.vivo_backend.vo.GuideVO;
import com.example.vivo_backend.vo.ReportVO;
import com.example.vivo_backend.vo.Review.ReviewVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@SpringBootTest
public class ReportTests {
    @Autowired
    private ReportController reportController;
    @Autowired
    private GuideController guideController;
    @Autowired
    private ReviewController reviewController;

    @Test
    @Transactional
    @Rollback()
    void reportTest(){
        GuideVO guideVO1 = new GuideVO(0,100,"自然景点",new Date(368799399),"7：00起床看日出");
        GuideVO guideVO2 = new GuideVO(0,100,"美食",new Date(368811111),"去xx胡同吃a餐馆");
        GuideVO guideVO3 = new GuideVO(0,0,"美食",new Date(368333333),"去yy胡同吃b餐馆");
        GuideVO guideVO4 = new GuideVO(0,0,"人文景点",new Date(368222222),"去c博物馆");
        guideController.addGuide(guideVO1);
        guideController.addGuide(guideVO2);
        guideController.addGuide(guideVO3);
        guideController.addGuide(guideVO4);
        ReviewVO reviewVO1 = new ReviewVO(0,100,"去大明湖","自然景点",new Date(326732389),"不错");
        ReviewVO reviewVO2 = new ReviewVO(0,100,"去吃饭","美食",new Date(35728933),"很不错");
        ReviewVO reviewVO3 = new ReviewVO(0,0,"去网红餐馆打卡","美食",new Date(368333333),"不好吃");
        ReviewVO reviewVO4 = new ReviewVO(0,0,"拜访朋友","其他",new Date(368222222),"多年不见");
        reviewController.addReview(reviewVO1);
        reviewController.addReview(reviewVO2);
        reviewController.addReview(reviewVO3);
        reviewController.addReview(reviewVO4);

        ReportVO reportVO = reportController.getGuideReport(0).getData();
        Assertions.assertEquals(reportVO.getTagReport().get(0).getNum(),2);
        Assertions.assertEquals(reportVO.getTagReport().get(1).getNum(),1);
        Assertions.assertEquals(reportVO.getTagReport().get(2).getNum(),1);

        ReportVO reportVO1 = reportController.getReviewReport(0).getData();
        Assertions.assertEquals(reportVO1.getTagReport().get(0).getNum(),2);
        Assertions.assertEquals(reportVO1.getTagReport().get(2).getNum(),1);
        Assertions.assertEquals(reportVO1.getTagReport().get(6).getNum(),1);

    }

}
