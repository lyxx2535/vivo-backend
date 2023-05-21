package com.example.vivo_backend.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends Exception {
    public BadRequestException(String msg) {
        super(msg);
        this.httpStatus= HttpStatus.BAD_REQUEST;
    }
}
