package com.example.vivo_backend.exception;

import org.springframework.http.HttpStatus;

public class InternalServerError extends MyException {
    public InternalServerError(String msg) {
        super(msg);
        this.httpStatus= HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
