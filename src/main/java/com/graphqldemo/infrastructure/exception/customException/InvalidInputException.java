package com.graphqldemo.infrastructure.exception.customException;

public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super(message);
    }
}
