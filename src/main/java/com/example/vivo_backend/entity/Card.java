package com.example.vivo_backend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.vivo_backend.vo.card.CardVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@TableName("card")
public class Card {
    @TableId
    private int cardId;
    private int userId;
    private String city;
    private Date createTime;

    public CardVO toCardVO(){
        CardVO cardVO = new CardVO();
        cardVO.setUserId(userId);
        cardVO.setCity(city);
        cardVO.setCreateTime(createTime);
        return cardVO;
    }
}
