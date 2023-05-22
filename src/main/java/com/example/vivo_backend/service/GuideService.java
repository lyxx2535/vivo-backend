package com.example.vivo_backend.service;

import com.example.vivo_backend.entity.Guide;
import com.example.vivo_backend.vo.GuideVO;

import java.util.List;

public interface GuideService {
    void addGuide(GuideVO guideVO);
    void deleteGuide(int guideId);
    GuideVO getGuideByGuideId(int guideId);
    List<Guide> getGuideListByUserId(int userId);
    List<Guide> getGuideListByCardId(int cardId);
}
