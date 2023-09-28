package com.example.msusers.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessage {
    UNEXPECTED_ERROR("Unexpected error"),
    USER_NOT_FOUND("User not found");

    private final String message;
}
