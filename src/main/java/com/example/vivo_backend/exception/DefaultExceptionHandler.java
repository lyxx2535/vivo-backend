package com.example.vivo_backend.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class DefaultExceptionHandler {

    /**
     * 主动throw的异常
     */
    @ExceptionHandler(Exception.class)
    public ErrorMessage handleUnProccessableServiceException(
            Exception e, HttpServletResponse response) throws Exception {

        if(e.getMessage().equals("Request method 'GET' not supported")){
            e.printStackTrace();
            throw e;
        }

        if (e instanceof MyException) {//主动抛出的异常
            MyException re = (MyException) e;
            response.setStatus(HttpStatus.OK.value());
            return new ErrorMessage(re.getHttpStatus().value() + "", re.getMessage());
        }

        e.printStackTrace();
        throw new InternalServerError("服务器错误！");
    }
}