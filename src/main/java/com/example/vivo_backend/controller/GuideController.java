package com.example.vivo_backend.controller;

import com.example.vivo_backend.entity.Guide;
import com.example.vivo_backend.service.GuideService;
import com.example.vivo_backend.vo.ResponseVO;
import com.example.vivo_backend.vo.GuideVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guide")
@Api(tags = "制定攻略")
@CrossOrigin
public class GuideController {

    @Autowired
    private GuideService guideService;

    @GetMapping("/getByGuideId")
    @ApiOperation(value = "提供攻略id获取当前攻略",notes = "攻略结构(int guideId, int userId, int cardId, String type, Date planTime, String guideContent)" )
    @ApiParam(name = "guideId", value = "攻略Id", required = true)
    public ResponseVO<GuideVO> getGuideByGuideId(int guideId){
        return new ResponseVO<>(guideService.getGuideByGuideId(guideId));
    }

    @GetMapping("/getListByUserId")
    @ApiOperation(value = "提供用户id获取所有攻略列表",notes = "攻略结构(int guideId, int userId, int cardId, String type, Date planTime, String guideContent)" )
    @ApiParam(name = "userId", value = "用户Id", required = true)
    public ResponseVO<List<Guide>> getGuideListByUserId(int userId){
        return new ResponseVO<>(guideService.getGuideListByUserId(userId));
    }

    @GetMapping("/getListByCardId")
    @ApiOperation(value = "提供卡片id获取所有攻略列表",notes = "攻略结构(int guideId, int userId, int cardId, String type, Date planTime, String guideContent)" )
    @ApiParam(name = "cardId", value = "卡片Id", required = true)
    public ResponseVO<List<Guide>> getGuideListByCardId(int cardId){
        return new ResponseVO<>(guideService.getGuideListByCardId(cardId));
    }

    @PostMapping("/insert")
    @ApiOperation(value = "添加一个攻略")
    @ApiParam(name = "guideVO", value = "攻略", required = true)
    public void addGuide(@RequestBody GuideVO guideVO){
        guideService.addGuide(guideVO);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除一个攻略")
    @ApiParam(name = "guideId", value = "攻略Id", required = true)
    public void deleteGuide(int guideId){
        guideService.deleteGuide(guideId);
    }

    @GetMapping("/getTypeList")
    @ApiOperation(value = "获得类型列表")
    public ResponseVO<String[]> getTypes(){
        String[] types = {"美食", "人文景点", "自然景点", "购物", "商务", "运动", "其他"};
        return new ResponseVO<>(types);
    }
}
