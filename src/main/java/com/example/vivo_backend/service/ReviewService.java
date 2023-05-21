package com.example.vivo_backend.service;

import com.example.vivo_backend.vo.Review.RealReviewVO;
import com.example.vivo_backend.vo.Review.ReviewVO;

import java.util.List;

public interface ReviewService {
    void addReview(ReviewVO reviewVO);
    void deleteReview(int reviewId);
    void updateReview(ReviewVO reviewVO);
    RealReviewVO getReviewByReviewId(int reviewId);
    List<RealReviewVO> getReviewListByUserId(int userId);
    List<RealReviewVO> getReviewListByCardId(int cardId);
}
