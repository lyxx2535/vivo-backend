package com.example.vivo_backend.controller;

import com.example.vivo_backend.entity.Review;
import com.example.vivo_backend.service.ReviewService;
import com.example.vivo_backend.vo.Review.RealReviewVO;
import com.example.vivo_backend.vo.Review.ReviewVO;
import com.example.vivo_backend.vo.ResponseVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
@Api(tags = "游记")
@CrossOrigin
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/getByReviewId")
    @ApiOperation(value = "提供游记id获取当前游记",notes = "游记结构(int reviewId, int userId, int cardId, String type, Date planTime, String reviewContent)" )
    @ApiParam(name = "reviewId", value = "游记Id", required = true)
    public ResponseVO<RealReviewVO> getReviewByReviewId(int reviewId){
        return new ResponseVO<>(reviewService.getReviewByReviewId(reviewId));
    }

    @GetMapping("/getListByUserId")
    @ApiOperation(value = "提供用户id获取所有列表",notes = "游记结构(int reviewId, int userId, int cardId, String type, Date planTime, String reviewContent)" )
    @ApiParam(name = "userId", value = "用户Id", required = true)
    public ResponseVO<List<RealReviewVO>> getReviewListByUserId(int userId){
        return new ResponseVO<>(reviewService.getReviewListByUserId(userId));
    }

    @GetMapping("/getListByCardId")
    @ApiOperation(value = "提供卡片id获取所有游记列表",notes = "游记结构(int reviewId, int userId, int cardId, String type, Date realTime, String reviewContent)" )
    @ApiParam(name = "cardId", value = "卡片Id", required = true)
    public ResponseVO<List<RealReviewVO>> getReviewListByCardId(int cardId){
        return new ResponseVO<>(reviewService.getReviewListByCardId(cardId));
    }

    @PostMapping("/insert")
    @ApiOperation(value = "添加一个游记")
    @ApiParam(name = "reviewVO", value = "游记", required = true)
    public void addReview(@RequestBody ReviewVO reviewVO){
        reviewService.addReview(reviewVO);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除一个游记")
    @ApiParam(name = "reviewId", value = "游记Id", required = true)
    public void deleteReview(int reviewId){
        reviewService.deleteReview(reviewId);
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新一个游记")
    @ApiParam(name = "reviewVO", value = "游记", required = true)
    public void updateReview(@RequestBody ReviewVO reviewVO){
        reviewService.updateReview(reviewVO);
    }

}
