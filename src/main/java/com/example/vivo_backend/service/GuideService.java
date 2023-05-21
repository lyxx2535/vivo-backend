package com.example.vivo_backend.service;

import com.example.vivo_backend.vo.guide.GuideVO;

import java.util.List;

public interface GuideService {
    void addGuide(GuideVO guideVO);
    void deleteGuide(int guideId);
    void updateGuide(GuideVO guideVO);
    GuideVO getGuideByGuideId(int guideId);
    List<GuideVO> getGuideListByUserId(int userId);
    List<GuideVO> getGuideListByCardId(int cardId);
}
