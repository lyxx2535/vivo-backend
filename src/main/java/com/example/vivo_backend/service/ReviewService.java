package com.example.vivo_backend.service;

import com.example.vivo_backend.vo.ReviewVO;

import java.util.List;

public interface ReviewService {
    void addReview(ReviewVO reviewVO);
    void deleteReview(int reviewId);
    void updateReview(ReviewVO reviewVO);
    ReviewVO getReviewByReviewId(int reviewId);
    List<ReviewVO> getReviewListByUserId(int userId);
    List<ReviewVO> getReviewListByCardId(int cardId);
}
