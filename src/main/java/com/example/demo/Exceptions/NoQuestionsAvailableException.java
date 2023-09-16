package com.example.demo.Exceptions;

public class NoQuestionsAvailableException extends RuntimeException {
    public NoQuestionsAvailableException(String message) {
        super(message);
    }
}
