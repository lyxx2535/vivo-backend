package com.example.vivo_backend;

import com.example.vivo_backend.controller.GuideController;
import com.example.vivo_backend.entity.Guide;
import com.example.vivo_backend.exception.BadRequestException;
import com.example.vivo_backend.exception.NotFoundException;
import com.example.vivo_backend.vo.GuideVO;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@SpringBootTest
public class GuideTests {
    @Autowired
    GuideController guideController;

    @Test
    @Rollback
    @Transactional
    void guideTest(){
        GuideVO guideVO1 = new GuideVO(0,100,"自然景点",new Date(368799399),"7：00起床看日出");
        GuideVO guideVO2 = new GuideVO(0,100,"美食",new Date(368811111),"去xx胡同吃a餐馆");
        GuideVO guideVO3 = new GuideVO(0,0,"美食",new Date(368333333),"去yy胡同吃b餐馆");
        GuideVO guideVO4 = new GuideVO(0,0,"人文景点",new Date(368222222),"去c博物馆");
        guideController.addGuide(guideVO1);
        guideController.addGuide(guideVO2);
        guideController.addGuide(guideVO3);
        guideController.addGuide(guideVO4);

        List<Guide>user0Guides = guideController.getGuideListByUserId(0).getData();
        List<Guide>card100Guides = guideController.getGuideListByCardId(100).getData();


        Assertions.assertEquals(user0Guides.size(),4);
        Assertions.assertEquals(card100Guides.size(),2);

        guideController.deleteGuide(user0Guides.get(0).getGuideId());

        List<Guide>user0NewGuides = guideController.getGuideListByUserId(0).getData();
        List<Guide>card100NewGuides = guideController.getGuideListByCardId(100).getData();
        Assertions.assertEquals(user0NewGuides.size(),3);
        Assertions.assertEquals(card100NewGuides.size(),1);

        String[] actualTypes = {"美食", "人文景点", "自然景点", "购物", "商务", "运动", "其他"};
        String []types = guideController.getTypes().getData();
        Assertions.assertEquals(types[3],actualTypes[3]);

        try{
            guideController.getGuideByGuideId(-1);
            Assertions.assertEquals(0,1);
        }catch (BadRequestException e){
            Assertions.assertEquals("没有相应的guide",e.getMessage());
        }

        try{
            guideController.getGuideListByUserId(-1);
            Assertions.assertEquals(0,1);
        }catch (NotFoundException e){
            Assertions.assertEquals("该用户没有攻略",e.getMessage());
        }
        try{
            guideController.getGuideListByCardId(-1);
            Assertions.assertEquals(0,1);
        }catch (NotFoundException e){
            Assertions.assertEquals("该卡片没有攻略",e.getMessage());
        }

        guideVO2.setType("自然景点");
        guideController.updateGuide(guideVO2);
        GuideVO newGuideVO = guideController.getGuideByGuideId(user0Guides.get(1).getGuideId()).getData();
        Assertions.assertEquals("美食", newGuideVO.getType());



    }
}
