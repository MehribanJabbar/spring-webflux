package com.example.msusers.client;

import com.example.msusers.model.reponse.CardResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class CardWebClient {
    private static final String url = "/v1/cards/{id}";
    private final WebClient webClient;

    public Mono<CardResponse> getCardById(Long id){
        return webClient.get()
                .uri(url, id)
                .retrieve()
                .bodyToMono(CardResponse.class)
                .doOnError(error -> log.error(error.getMessage()));
    }

    public Mono<CardResponse> getAllCards(){
        return webClient.get()
                .uri("/v1/cards")
                .retrieve()
                .bodyToMono(CardResponse.class)
                .doOnError(error -> log.error(error.getMessage()));
    }


}
