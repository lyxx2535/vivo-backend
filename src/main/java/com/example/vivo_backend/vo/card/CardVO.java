package com.example.vivo_backend.vo.card;

import com.example.vivo_backend.entity.Card;
import com.example.vivo_backend.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class CardVO {

    @ApiModelProperty(value = "卡片所属用户id", example = "1")
    private int userId;

    @ApiModelProperty(value = "所属城市",example = "南京市")
    private String city;

    @ApiModelProperty(value = "创建时间", example = "2012-01-20")
    private Date createTime;

    public Card toCard(){
        return Card.builder()
                .userId(userId)
                .city(city)
                .createTime(createTime)
                .build();
    }


}
