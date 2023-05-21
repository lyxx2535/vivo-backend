package com.example.vivo_backend.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class Exception extends RuntimeException {
    protected HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

    public Exception(String msg) {
        super(msg);
    }
}
