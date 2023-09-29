package com.example.msusers.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessage {

    UNEXPECTED_ERROR("UNEXPECTED_ERROR", "Unexpected Error"),
    NOT_FOUND_EXCEPTION("NOT_FOUND_EXCEPTION", "Not found exception");

    private final String code;
    private final String message;
}
