package com.example.msusers.client;

import com.example.msusers.model.reponse.CardResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class CardWebClient {
//    private static final String url1 = "/v1/cards/{id}/{user-id}";
    private static final String url2 = "/v1/cards/{user-id}";
    private final WebClient webClient;

//    public Mono<CardResponse> getCardById(Long id, Long userId){
//        return webClient.get()
//                .uri(url1, id, userId)
//                .retrieve()
//                .bodyToMono(CardResponse.class)
//                .doOnError(error -> log.error(error.getMessage()));
//    }

    public Mono<CardResponse> getAllCardsByUserId(Long userId){
        return webClient.get()
                .uri(url2, userId)
                .retrieve()
                .bodyToMono(CardResponse.class)
                .doOnError(error -> log.error(error.getMessage()));
    }


}
