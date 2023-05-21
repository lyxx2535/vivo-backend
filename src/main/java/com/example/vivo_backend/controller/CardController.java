package com.example.vivo_backend.controller;

import com.example.vivo_backend.entity.Card;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
@Api(tags = "卡片")
public class CardController {

//    @Autowired

    @GetMapping("/find")
    public Card getCardById(String id){
        return new Card();
    }

    @PostMapping("/add")
    public void addCard(@RequestBody Card card){

    }
    @GetMapping("/delete")
    public void deleteCard(int id){

    }
    @PostMapping("/update")
    public void updateCard(@RequestBody Card card){

    }
}
