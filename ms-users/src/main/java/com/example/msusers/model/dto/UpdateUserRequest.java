package com.example.msusers.model.dto;

import java.time.LocalDate;

public record UpdateUserRequest(String name, String surname, String username, LocalDate birthdate, String birthPlace) {
}
