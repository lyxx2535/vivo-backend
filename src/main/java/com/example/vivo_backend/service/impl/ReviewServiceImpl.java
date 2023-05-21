package com.example.vivo_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.vivo_backend.entity.Picture;
import com.example.vivo_backend.entity.Review;
import com.example.vivo_backend.exception.BadRequestException;
import com.example.vivo_backend.exception.NotFoundException;
import com.example.vivo_backend.mapper.PictureMapper;
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

    @Autowired
    private PictureMapper pictureMapper;

    public void setAbsentPicture(int reviewId){
        System.out.println(reviewId);
        QueryWrapper<Picture> wrapper = new QueryWrapper<>();
        wrapper.eq("review_id", -1);
        List<Picture> pictures = pictureMapper.selectList(wrapper);
        System.out.println(pictures.size());
        for(Picture picture: pictures) {
            picture.setReviewId(reviewId);
            pictureMapper.updateById(picture);
            System.out.println(picture.getPictureId()+" "+picture.getReviewId());

        }
    }
    @Override
    public void addReview(ReviewVO reviewVO) {
        Review review = reviewVO.toReview();
        reviewMapper.insert(review);
        //获得最新加入的review的reviewId
        QueryWrapper<Review> wrapper = new QueryWrapper<>();
        List<Review> reviews = reviewMapper.selectList(wrapper.orderByDesc("review_id"));
        //补全picture缺失的reviewId
        setAbsentPicture(reviews.get(0).getReviewId());
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
