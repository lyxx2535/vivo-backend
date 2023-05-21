package com.example.vivo_backend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.vivo_backend.vo.guide.GuideVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@TableName("guide")
public class Guide {
    @TableId
    private int guideId;
    private int userId;
    private int cardId;
    private String type;
    private Date planTime;
    private String guideContent;

    public GuideVO toGuideVO(){
        GuideVO guideVO = new GuideVO();
        guideVO.setGuideId(guideId);
        guideVO.setUserId(userId);
        guideVO.setCardId(cardId);
        guideVO.setType(type);
        guideVO.setPlanTime(planTime);
        guideVO.setGuideContent(guideContent);
        return guideVO;
    }
}
