package com.example.vivo_backend.vo.review;

import com.example.vivo_backend.entity.Review;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class RealReviewVO {
    @ApiModelProperty(value = "游记id", example = "1")
    private int reviewId;
    @ApiModelProperty(value = "游记VO", example = "1")
    private ReviewVO reviewVO;
    @ApiModelProperty(value = "图片列表")
    private List<String> picUrls;

    public RealReviewVO(Review review, List<String> urls){
        reviewId = review.getReviewId();
        reviewVO.setReviewContent(reviewVO.getReviewContent());
        reviewVO.setRealTime(reviewVO.getRealTime());
        reviewVO.setType(reviewVO.getType());
        reviewVO.setTitle(reviewVO.getTitle());
        reviewVO.setUserId(reviewVO.getUserId());
        reviewVO.setCardId(reviewVO.getCardId());
        picUrls = urls;
    }

}
