package com.example.vivo_backend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
public class ExceptionTests {

    @Test
    @Rollback
    void exceptionTest(){

    }

}
