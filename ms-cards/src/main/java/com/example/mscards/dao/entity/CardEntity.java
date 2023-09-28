package com.example.mscards.dao.entity;

import com.example.mscards.model.enums.CardStatus;
import com.example.mscards.model.enums.CardType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cards")
public class CardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String pan;
    private String cvv;
    private String cardHolder;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDate expirationDate;

    @Enumerated(EnumType.STRING)
    private CardType creditCard;

    @Enumerated(EnumType.STRING)
    private CardStatus cardStatus;

}
