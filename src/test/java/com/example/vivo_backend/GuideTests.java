package com.example.vivo_backend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class GuideTests {

    @Test
    @Rollback(value = true)
    @Transactional
    void guideTest(){

    }
}
