package com.example.vivo_backend.controller;

import com.example.vivo_backend.service.CardService;
import com.example.vivo_backend.vo.ResponseVO;
import com.example.vivo_backend.vo.card.CardVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/card")
@Api(tags = "卡片")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping("/get")
    @ApiOperation(value = "提供卡片id获取完整卡片",notes = "卡片结构(int cardId, int userId, String city, Date createTime)" )
    @ApiParam(name = "cardId", value = "卡片Id", required = true)
    public ResponseVO<CardVO> getCardById(int cardId){
        return new ResponseVO<>(cardService.getCard(cardId));
    }

    @PostMapping("/insert")
    @ApiOperation(value = "添加一个卡片")
    @ApiParam(name = "cardVO", value = "卡片", required = true)
    public void addCard(@RequestBody CardVO cardVO){
        cardService.addCard(cardVO);
    }
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除一个卡片")
    @ApiParam(name = "cardId", value = "卡片Id", required = true)
    public void deleteCard(int cardId){
        cardService.deleteCard(cardId);
    }
    @PostMapping("/update")
    @ApiOperation(value = "更新一个卡片")
    @ApiParam(name = "cardVO", value = "卡片", required = true)
    public void updateCard(@RequestBody CardVO cardVO){
        cardService.updateCard(cardVO);
    }
}
