package com.example.mscards.service;

import com.example.mscards.dao.entity.CardEntity;
import com.example.mscards.dao.repository.CardRepository;
import com.example.mscards.exception.NotFoundException;
import com.example.mscards.mapper.CardMapper;
import com.example.mscards.model.dto.CardResponse;
import com.example.mscards.model.dto.SaveCardRequest;
import com.example.mscards.model.enums.CardStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;

    public CardResponse getCardById(Long id){
        var card = cardRepository.findById(id)
                .orElseThrow(() ->new NotFoundException("CARD_NOT_FOUND"));
        return CardMapper.buildToResponse(card);
    }

    public void saveCard(SaveCardRequest cardRequest){
        CardEntity card = CardMapper.buildToEntity(cardRequest);
        card.setCardStatus(CardStatus.COMPLETED);
        cardRepository.save(card);
    }

    public void changeStatus(Long id, CardStatus newStatus){
        var card = cardRepository.findById(id)
                .orElseThrow(() ->new  NotFoundException("CARD_NOT_FOUND"));
        card.setCardStatus(newStatus);
        cardRepository.save(card);
    }
}
