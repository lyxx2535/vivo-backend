package com.example.vivo_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.vivo_backend.entity.Card;
import com.example.vivo_backend.exception.BadRequestException;
import com.example.vivo_backend.exception.MyException;
import com.example.vivo_backend.mapper.CardMapper;
import com.example.vivo_backend.service.CardService;
import com.example.vivo_backend.vo.card.CardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardMapper cardMapper;


    @Override
    public void addCard(CardVO cardVO) {
        Card card = cardVO.toCard();
        cardMapper.insert(card);
    }

    @Override
    public void deleteCard(int cardId) {
        cardMapper.deleteById(cardId);

    }

    @Override
    public void updateCard(CardVO cardVO) {
        Card card = cardVO.toCard();
        cardMapper.updateById(card);
    }

    @Override
    public CardVO getCard(int cardId) {
        Card card = cardMapper.selectById(cardId);
        if(card == null){
            throw new BadRequestException("没有相应的card");
        }
        return card.toCardVO();
    }
}
