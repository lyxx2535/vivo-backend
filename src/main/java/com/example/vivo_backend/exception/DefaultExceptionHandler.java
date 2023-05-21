package com.example.vivo_backend.exception;
import com.example.vivo_backend.utils.ExceptionUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        String subject;
        String text;
        if (e instanceof IOException) {//IO异常
            text = ExceptionUtil.getExceptionDetailInformation(e);
            subject = "vivo_backend出现了IO异常";

        } else {//其他异常
            text = ExceptionUtil.getExceptionDetailInformation(e);
            subject = "vivo_backend出现了未知异常";
        }

        e.printStackTrace();
        throw new Exception("服务器错误！");
    }
}