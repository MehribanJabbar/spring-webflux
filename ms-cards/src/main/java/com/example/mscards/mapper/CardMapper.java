package com.example.mscards.mapper;

import com.example.mscards.dao.entity.CardEntity;
import com.example.mscards.model.dto.CardResponse;
import com.example.mscards.model.dto.SaveCardRequest;

public class CardMapper {
    public static CardResponse buildToResponse(CardEntity card){
        return CardResponse.builder()
                .id(card.getId())
                .userId(card.getUserId())
                .pan(card.getPan())
                .cvv(card.getCvv())
                .cardHolder(card.getCardHolder())
                .expirationDate(card.getExpirationDate())
                .creditCard(card.getCreditCard())
                .build();
    }

    public static CardEntity buildToEntity(SaveCardRequest request){
        return CardEntity.builder()
                .userId(request.getUserId())
                .cvv(request.getCvv())
                .pan(request.getPan())
                .cardHolder(request.getCardHolder())
                .expirationDate(request.getExpirationDate())
                .creditCard(request.getCreditCard())
                .build();
    }
}
