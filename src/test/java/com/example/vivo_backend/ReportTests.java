package com.example.vivo_backend;

import com.example.vivo_backend.controller.ReportController;
import com.example.vivo_backend.service.ReportService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class ReportTests {
    @Autowired
    private ReportController reportController;

    @Test
    @Transactional
    @Rollback(value = true)
    void reportTest(){

    }

}
