package com.example.mscards.controller;

import com.example.mscards.model.dto.CardResponse;
import com.example.mscards.model.dto.SaveCardRequest;
import com.example.mscards.model.enums.CardStatus;
import com.example.mscards.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/cards")
public class CardController {
    private final CardService cardService;

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public CardResponse getCardById(@PathVariable Long id){
        return cardService.getCardById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public void saveCard(@RequestBody SaveCardRequest request){
        cardService.saveCard(request);
    }

    @PutMapping("/{id}/status")
    @ResponseStatus(NO_CONTENT)
    public void changeStatus(@PathVariable Long id, @RequestBody CardStatus newStatus){
        cardService.changeStatus(id, newStatus);
    }
}
