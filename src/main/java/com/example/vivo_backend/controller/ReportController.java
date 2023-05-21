package com.example.vivo_backend.controller;

import com.example.vivo_backend.service.ReportService;
import com.example.vivo_backend.vo.ReportVO;
import com.example.vivo_backend.vo.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
@Api(tags = "分析报告")
@CrossOrigin
public class ReportController {

    @Autowired
    private ReportService reportService;


    @GetMapping("/guide")
    @ApiOperation(value = "提供用户id获取攻略中tags数量", notes = "类似[{tag:美食, num:1}]")
    @ApiParam(name="userId",value = "用户ID",required = true)
    public ResponseVO<ReportVO> getGuideReport(int userId){
        return new ResponseVO<>(reportService.getGuideReport(userId));
    }

    @GetMapping("/review")
    @ApiOperation(value = "提供用户id获取游记中tags数量", notes = "类似[{tag:美食, num:1}]")
    @ApiParam(name="userId",value = "用户ID",required = true)
    public ResponseVO<ReportVO> getReviewReport(int userId){
        return new ResponseVO<>(reportService.getReviewReport(userId));
    }



}
