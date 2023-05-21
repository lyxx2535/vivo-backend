package com.example.vivo_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.vivo_backend.entity.Review;
import com.example.vivo_backend.exception.BadRequestException;
import com.example.vivo_backend.exception.NotFoundException;
import com.example.vivo_backend.mapper.ReviewMapper;
import com.example.vivo_backend.service.ReviewService;
import com.example.vivo_backend.vo.ReviewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewMapper reviewMapper;

    public void setAbsentPicture(String reviewId){

    }
    @Override
    public void addReview(ReviewVO reviewVO) {
        Review review = reviewVO.toReview();
        reviewMapper.insert(review);
        reviewMapper.
        setAbsentPicture();
    }

    @Override
    public void deleteReview(int reviewId) {
        reviewMapper.deleteById(reviewId);
    }

    @Override
    public void updateReview(ReviewVO reviewVO) {
        Review review = reviewVO.toReview();
        reviewMapper.updateById(review);
    }

    @Override
    public ReviewVO getReviewByReviewId(int reviewId) {
        Review review = reviewMapper.selectById(reviewId);
        if(review==null){
            throw new BadRequestException("没有相应的review");
        }
        return review.toReviewVO();
    }

    @Override
    public List<Review> getReviewListByUserId(int userId) {
        try{
            QueryWrapper<Review> wrapper = new QueryWrapper<>();
            wrapper.eq("user_id",userId);
            return reviewMapper.selectList(wrapper);
        }catch (Exception e){
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        }
    }

    @Override
    public List<Review> getReviewListByCardId(int cardId) {
        try{
            QueryWrapper<Review> wrapper = new QueryWrapper<>();
            wrapper.eq("card_id",cardId);
            return reviewMapper.selectList(wrapper);
        }catch (Exception e){
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        }
    }
}
