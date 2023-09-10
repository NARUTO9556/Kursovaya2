package com.example.demo.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class NoQuestionsAvailableException extends HttpStatusCodeException {
    public NoQuestionsAvailableException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
