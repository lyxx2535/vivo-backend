package com.example.vivo_backend.vo.guide;

import com.example.vivo_backend.entity.Guide;
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
public class GuideVO {
    @ApiModelProperty(value = "攻略id", example = "1")
    private int guideId;

    @ApiModelProperty(value = "攻略所属用户id", example = "1")
    private int userId;

    @ApiModelProperty(value = "攻略所属卡片id", example = "1")
    private int cardId;

    @ApiModelProperty(value = "攻略类型",example = "美食")
    private String type;

    @ApiModelProperty(value = "预期时间", example = "2012-01-20")
    private Date planTime;

    @ApiModelProperty(value = "攻略内容",example = "吃老门东的南京大牌档")
    private String guideContent;

    public Guide toGuide(){
        return Guide.builder()
                .guideId(guideId)
                .cardId(cardId)
                .userId(userId)
                .type(type)
                .planTime(planTime)
                .guideContent(guideContent)
                .build();
    }
}
