package com.example.vivo_backend.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends MyException {
    public NotFoundException(String msg) {
        super(msg);
        this.httpStatus= HttpStatus.NOT_FOUND;
    }
}
