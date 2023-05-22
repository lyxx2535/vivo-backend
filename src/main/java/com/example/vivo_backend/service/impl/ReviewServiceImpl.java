package com.example.vivo_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.vivo_backend.entity.Picture;
import com.example.vivo_backend.entity.Review;
import com.example.vivo_backend.exception.BadRequestException;
import com.example.vivo_backend.exception.NotFoundException;
import com.example.vivo_backend.mapper.PictureMapper;
import com.example.vivo_backend.mapper.ReviewMapper;
import com.example.vivo_backend.service.ReviewService;
import com.example.vivo_backend.vo.review.RealReviewVO;
import com.example.vivo_backend.vo.review.ReviewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewMapper reviewMapper;

    @Autowired
    private PictureMapper pictureMapper;

    private static final String COLUMN_REVIEW_ID = "review_id";

    public List<String> getPicUrlsByReviewId(int reviewId){
        QueryWrapper<Picture> wrapper = new QueryWrapper<>();
        wrapper.eq(COLUMN_REVIEW_ID, reviewId);
        List<Picture> pictures = pictureMapper.selectList(wrapper);
        List<String> result = new ArrayList<>();
        for(Picture picture: pictures){
            result.add(picture.getPictureUrl());
        }
        return result;
    }

    public void setAbsentPicture(int reviewId){
        QueryWrapper<Picture> wrapper = new QueryWrapper<>();
        wrapper.eq(COLUMN_REVIEW_ID, -1);
        List<Picture> pictures = pictureMapper.selectList(wrapper);
        for(Picture picture: pictures) {
            picture.setReviewId(reviewId);
            pictureMapper.updateById(picture);
        }
    }
    @Override
    public void addReview(ReviewVO reviewVO) {
        Review review = reviewVO.toReview();
        reviewMapper.insert(review);
        //获得最新加入的review的reviewId
        QueryWrapper<Review> wrapper = new QueryWrapper<>();
        List<Review> reviews = reviewMapper.selectList(wrapper.orderByDesc(COLUMN_REVIEW_ID));
        //补全picture缺失的reviewId
        setAbsentPicture(reviews.get(0).getReviewId());
    }

    @Override
    public void deleteReview(int reviewId) {
        reviewMapper.deleteById(reviewId);
    }


    @Override
    public RealReviewVO getReviewByReviewId(int reviewId) {
        Review review = reviewMapper.selectById(reviewId);
        if(review==null){
            throw new BadRequestException("没有相应的review");
        }
        List<String> urls = getPicUrlsByReviewId(reviewId);
        return new RealReviewVO(review, urls);
    }



    @Override
    public List<RealReviewVO> getReviewListByUserId(int userId) {
        try{
            QueryWrapper<Review> wrapper = new QueryWrapper<>();
            wrapper.eq("user_id", userId);
            List<Review> reviews = reviewMapper.selectList(wrapper);
            List<RealReviewVO> result = new ArrayList<>();
            for(Review review: reviews){
                List<String> picUrls = getPicUrlsByReviewId(review.getReviewId());
                result.add(new RealReviewVO(review, picUrls));
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        }
    }

    @Override
    public List<RealReviewVO> getReviewListByCardId(int cardId) {
        try{
            QueryWrapper<Review> wrapper = new QueryWrapper<>();
            wrapper.eq("card_id",cardId);
            List<Review> reviews = reviewMapper.selectList(wrapper);
            List<RealReviewVO> result = new ArrayList<>();
            for(Review review: reviews){
                List<String> picUrls = getPicUrlsByReviewId(review.getReviewId());
                result.add(new RealReviewVO(review, picUrls));
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        }
    }
}
