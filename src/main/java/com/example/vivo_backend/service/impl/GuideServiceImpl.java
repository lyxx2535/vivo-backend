package com.example.vivo_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.vivo_backend.entity.Guide;
import com.example.vivo_backend.exception.BadRequestException;
import com.example.vivo_backend.exception.NotFoundException;
import com.example.vivo_backend.mapper.GuideMapper;
import com.example.vivo_backend.service.GuideService;
import com.example.vivo_backend.vo.ResponseVO;
import com.example.vivo_backend.vo.guide.GuideVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuideServiceImpl implements GuideService {
    @Autowired
    private GuideMapper guideMapper;

    @Override
    public void addGuide(GuideVO guideVO) {
        Guide guide = guideVO.toGuide();
        guideMapper.insert(guide);
    }

    @Override
    public void deleteGuide(int guideId) {
        guideMapper.deleteById(guideId);
    }

    @Override
    public void updateGuide(GuideVO guideVO) {
        Guide guide = guideVO.toGuide();
        guideMapper.updateById(guide);
    }

    @Override
    public GuideVO getGuideByGuideId(int guideId) {
        Guide guide = guideMapper.selectById(guideId);
        if(guide == null){
            throw new BadRequestException("没有相应的guide");
        }
        return guide.toGuideVO();
    }

    @Override
    public List<GuideVO> getGuideListByUserId(int userId) {
        try {
            List<Guide> guides = guideMapper.selectList(new QueryWrapper<>(Guide.builder().userId(userId).build()));
            System.out.println(guides.size());
            List<GuideVO> result = new ArrayList<>(guides.size());

            for (Guide guide : guides) {
                GuideVO guideVO = guide.toGuideVO();
                System.out.println(guideVO);
                result.add(guideVO);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        }
    }

    @Override
    public List<GuideVO> getGuideListByCardId(int cardId) {
        try {
            List<Guide> guides = guideMapper.selectList(new QueryWrapper<>(Guide.builder().cardId(cardId).build()));
            List<GuideVO> result = new ArrayList<>(guides.size());

            for (Guide guide : guides) {
                GuideVO guideVO = guide.toGuideVO();
                result.add(guideVO);
            }

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        }
    }
}
