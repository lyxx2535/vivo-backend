package com.example.vivo_backend.service;


import com.example.vivo_backend.vo.ReportVO;

public interface ReportService {
    ReportVO getReviewReport(int userId);
    ReportVO getGuideReport(int userId);
}
