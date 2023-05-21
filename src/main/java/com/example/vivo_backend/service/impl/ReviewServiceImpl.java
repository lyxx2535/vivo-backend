package com.example.vivo_backend.service.impl;

import com.example.vivo_backend.service.ReviewService;
import com.example.vivo_backend.vo.ReviewVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Override
    public void addReview(ReviewVO reviewVO) {

    }

    @Override
    public void deleteReview(int reviewId) {

    }

    @Override
    public void updateReview(ReviewVO reviewVO) {

    }

    @Override
    public ReviewVO getReviewByReviewId(int reviewId) {
        return null;
    }

    @Override
    public List<ReviewVO> getReviewListByUserId(int userId) {
        return null;
    }

    @Override
    public List<ReviewVO> getReviewListByCardId(int cardId) {
        return null;
    }
}
