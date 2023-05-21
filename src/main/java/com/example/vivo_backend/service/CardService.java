package com.example.vivo_backend.service;

import com.example.vivo_backend.vo.card.CardVO;

public interface CardService {
    void addCard(CardVO cardVO);
    void deleteCard(int cardId);
    void updateCard(CardVO cardVO);
    CardVO getCard(int cardId);
}
