package com.example.vivo_backend;

import com.example.vivo_backend.controller.ReviewController;
import com.example.vivo_backend.entity.Review;
import com.example.vivo_backend.vo.Review.RealReviewVO;
import com.example.vivo_backend.vo.Review.ReviewVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@SpringBootTest
public class ReviewTests {

    @Autowired
    ReviewController reviewController;

    @Test
    @Rollback()
    @Transactional
    void reviewTest(){
        ReviewVO reviewVO1 = new ReviewVO(0,100,"去大明湖","自然景点",new Date(326732389),"不错");
        ReviewVO reviewVO2 = new ReviewVO(0,100,"去吃饭","美食",new Date(35728933),"很不错");
        ReviewVO reviewVO3 = new ReviewVO(0,0,"去网红餐馆打卡","美食",new Date(368333333),"不好吃");
        ReviewVO reviewVO4 = new ReviewVO(0,0,"去故宫","人文景点",new Date(368222222),"很壮观但是人好多没怎么玩");
        reviewController.addReview(reviewVO1);
        reviewController.addReview(reviewVO2);
        reviewController.addReview(reviewVO3);
        reviewController.addReview(reviewVO4);

        List<RealReviewVO> user0Reviews = reviewController.getReviewListByUserId(0).getData();
        List<RealReviewVO>card100Reviews = reviewController.getReviewListByCardId(100).getData();


        Assertions.assertEquals(user0Reviews.size(),4);
        Assertions.assertEquals(card100Reviews.size(),2);

        reviewController.deleteReview(user0Reviews.get(0).getReviewId());

        List<RealReviewVO>user0NewReviews = reviewController.getReviewListByUserId(0).getData();
        List<RealReviewVO>card100NewReviews = reviewController.getReviewListByCardId(100).getData();
        Assertions.assertEquals(3, user0NewReviews.size());
        Assertions.assertEquals(1, card100NewReviews.size());

        int id = user0NewReviews.get(0).getReviewId();
        Date date = user0NewReviews.get(0).getRealTime();

        RealReviewVO review = reviewController.getReviewByReviewId(id).getData();
        Assertions.assertEquals(date, review.getRealTime());

        reviewVO1.setReviewContent("newContent");
        reviewController.updateReview(reviewVO1);

        RealReviewVO newReview = reviewController.getReviewByReviewId(id).getData();
        Assertions.assertEquals(review.getReviewContent(),newReview.getReviewContent());




    }

}
