package com.example.msusers.model.dto;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UserResponse(Long id, String name, String surname, String username, LocalDate birthdate, String birthPlace) {
}
