package com.example.vivo_backend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.vivo_backend.vo.GuideVO;
import com.example.vivo_backend.vo.ReviewVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@TableName("review")
public class Review {
    @TableId
    private int reviewId;
    private int userId;
    private int cardId;
    private String title;
    private String type;
    private Date realTime;
    private String reviewContent;

    public ReviewVO toReviewVO(){
        ReviewVO reviewVO  =new ReviewVO();
        reviewVO.setUserId(userId);
        reviewVO.setCardId(cardId);
        reviewVO.setReviewContent(reviewContent);
        reviewVO.setType(type);
        reviewVO.setRealTime(realTime);
        reviewVO.setTitle(title);
        return reviewVO;
    }
}
