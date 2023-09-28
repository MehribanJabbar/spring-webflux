package com.example.msusers.model.dto;

import lombok.Builder;

@Builder
public record UserResponse(Long id, String name, String surname, String username, String birthDate, String birthPlace) {
}
