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

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;

//    public CardResponse getCardByUserId(Long id, Long userId){
//        var card = cardRepository.findById(id)
//                .orElseThrow(() ->new NotFoundException("CARD_NOT_FOUND"));
//        cardRepository.findByUserId(userId)
//                .orElseThrow(() -> new NotFoundException("User not found with id: " + userId));
//        return CardMapper.buildToResponse(card);
//    }

    public List<CardResponse> getAllCardsByUserId(Long userId){

        List<CardResponse> cards = cardRepository.findByUserId(userId)
                .stream().map(CardMapper::buildToResponse)
                .collect(Collectors.toList());

        if (cardRepository.findByUserId(userId).isEmpty()){
            throw new NotFoundException("User not found for this id : " + userId);
        }

        return  cards;
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
