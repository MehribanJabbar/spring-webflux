package com.example.msusers.model.reponse;

import com.example.msusers.model.enums.CardType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardResponse {
    Long id;
    Long userId;
    String pan;
    String cvv;
    String cardHolder;
    LocalDate expirationDate;
    CardType creditCard;
}
