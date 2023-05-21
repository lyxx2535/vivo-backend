package com.example.vivo_backend.controller;


import com.example.vivo_backend.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    TestMapper testMapper;

    @RequestMapping("/test")
    public String getNameById(int id){
        return testMapper.selectById(id).getName();
    }

    @RequestMapping("/test2")
    public String getNameById2(int id){
        return testMapper.selectById(id).getName();
    }
}
