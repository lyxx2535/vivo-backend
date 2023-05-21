package com.example.vivo_backend.vo.Review;

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
    @ApiModelProperty(value = "游记所属用户id", example = "1")
    private int userId;
    @ApiModelProperty(value = "游记所属卡片id", example = "1")
    private int cardId;
    @ApiModelProperty(value = "游记标题", example = "一次游记")
    private String title;
    @ApiModelProperty(value = "攻略类型",example = "美食")
    private String type;
    @ApiModelProperty(value = "访问时间", example = "2012-01-20")
    private Date realTime;
    @ApiModelProperty(value = "游记内容",example = "老门东的南京大牌档很好吃")
    private String reviewContent;
    @ApiModelProperty(value = "图片列表")
    private List<String> picUrls;

    public RealReviewVO(Review review, List<String> urls){
        reviewId = review.getReviewId();
        userId = review.getUserId();
        cardId = review.getCardId();
        title = review.getTitle();
        type = review.getType();
        realTime = review.getRealTime();
        reviewContent = review.getReviewContent();
        picUrls = urls;
    }

}
