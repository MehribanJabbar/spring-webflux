package com.example.mscards.model.dto;

import com.example.mscards.model.enums.CardType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SaveCardRequest {
    Long userId;
    String pan;
    String cvv;
    String cardHolder;
    LocalDate expirationDate;
    CardType creditCard;
}
