package com.example.vivo_backend.service.impl;

import com.example.vivo_backend.entity.Card;
import com.example.vivo_backend.mapper.CardMapper;
import com.example.vivo_backend.service.CardService;
import com.example.vivo_backend.vo.card.CardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardMapper cardMapper;


    @Override
    public void addCard(CardVO cardVO) {
        Card card = new Card(cardVO.getCardId(), cardVO.getUserId(),cardVO.getCity(),cardVO.getCreateTime());
        cardMapper.insert(card);
    }

    @Override
    public void deleteCard(int cardId) {
        cardMapper.deleteById(cardId);

    }

    @Override
    public void updateCard(CardVO cardVO) {
        Card card = new Card(cardVO.getCardId(), cardVO.getUserId(),cardVO.getCity(),cardVO.getCreateTime());
        cardMapper.updateById(card);
    }

    @Override
    public CardVO getCard(int cardId) {
        Card card = cardMapper.selectById(cardId);
        return new CardVO(card.getCardId(),card.getUserId(), card.getCity(), card.getCreateTime());
    }
}
