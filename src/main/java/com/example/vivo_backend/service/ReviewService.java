package com.example.vivo_backend.service;

import com.example.vivo_backend.entity.Review;
import com.example.vivo_backend.vo.ReviewVO;

import java.util.List;

public interface ReviewService {
    void addReview(ReviewVO reviewVO);
    void deleteReview(int reviewId);
    void updateReview(ReviewVO reviewVO);
    ReviewVO getReviewByReviewId(int reviewId);
    List<Review> getReviewListByUserId(int userId);
    List<Review> getReviewListByCardId(int cardId);
}
