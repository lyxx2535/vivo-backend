package com.example.vivo_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.vivo_backend.entity.Card;
import com.example.vivo_backend.exception.BadRequestException;
import com.example.vivo_backend.mapper.CardMapper;
import com.example.vivo_backend.service.CardService;
import com.example.vivo_backend.vo.CardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Card getCard(int cardId) {
        Card card = cardMapper.selectById(cardId);
        if(card == null){
            throw new BadRequestException("没有相应的card");
        }
        return card;
    }

    @Override
    public List<Card> getAllCard(int userId) {
        QueryWrapper<Card> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        return cardMapper.selectList(wrapper);
    }
}
