package com.example.vivo_backend.controller;

import com.example.vivo_backend.service.CardService;
import com.example.vivo_backend.vo.card.CardVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/card")
@Api(tags = "卡片")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping("/find")
    @ApiOperation(value = "提供卡片id获取完整卡片",notes = "卡片结构(int id, String city, String timestamp, Date )" )
    public CardVO getCardById(int cardId){
        return cardService.getCard(cardId);
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加一个卡片")
    public void addCard(@RequestBody CardVO card){
        cardService.addCard(card);
    }
    @GetMapping("/delete")
    public void deleteCard(int cardId){
        cardService.deleteCard(cardId);
    }
    @PostMapping("/update")
    public void updateCard(@RequestBody CardVO card){
        cardService.updateCard(card);
    }
}
