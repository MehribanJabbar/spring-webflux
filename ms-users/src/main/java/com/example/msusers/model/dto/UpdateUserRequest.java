package com.example.msusers.model.dto;

public record UpdateUserRequest(String name, String surname, String username, String birthDate, String birthPlace) {
}
