package com.example.vivo_backend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

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
}
