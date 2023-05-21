package com.example.vivo_backend.controller;


import com.example.vivo_backend.mapper.TestMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "测试接口")
public class TestController {
    @Autowired
    TestMapper testMapper;

    @GetMapping("/test")
    @ApiOperation(value="输入id获取姓名", notes = "姓名")
    @ApiImplicitParam(name="id", value="姓名的id",required = true)
    public String getNameById(int id){
        return testMapper.selectById(id).getName();
    }

    @RequestMapping("/test2")
    public String getNameById2(int id){
        return testMapper.selectById(id).getName();
    }
}
