package com.example.vivo_backend;

import com.example.vivo_backend.controller.CardController;
import com.example.vivo_backend.entity.Card;
import com.example.vivo_backend.exception.BadRequestException;
import com.example.vivo_backend.vo.CardVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@SpringBootTest
class CardTests {
    @Autowired
    CardController cardController;

    @Test
    @Transactional
    @Rollback(value = true)
    void addSelectDeleteCardTest(){
        List<Card> oldCards = cardController.getAllCard(1).getData();

        CardVO cardVO = new CardVO(1,"南京市",new Date(281989622));
        cardController.addCard(cardVO);

        List<Card> newCards = cardController.getAllCard(1).getData();
        // 比较newCards和oldCards
        Assertions.assertEquals(oldCards.size(),newCards.size()-1);

        Card lastCard = newCards.get(newCards.size()-1);
        Card lastCardFromSelect = cardController.getCardById(lastCard.getCardId()).getData();
        // 比较lastCard 和 lastCardFromSelect
        Assertions.assertEquals(lastCard.getCreateTime(),lastCardFromSelect.getCreateTime());

        cardController.deleteCard(lastCard.getCardId());
        List<Card> cardsAfterDelete = cardController.getAllCard(1).getData();
        // 比较cardsAfterDelete和oldCards
        Assertions.assertEquals(cardsAfterDelete.size(),oldCards.size());

        try {
            cardController.getCardById(lastCard.getCardId());
            Assertions.assertEquals(0,1);
        }catch (BadRequestException e){

        }


    }


}
