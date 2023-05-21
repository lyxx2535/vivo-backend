package com.example.vivo_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.vivo_backend.entity.Guide;
import com.example.vivo_backend.exception.BadRequestException;
import com.example.vivo_backend.exception.NotFoundException;
import com.example.vivo_backend.mapper.GuideMapper;
import com.example.vivo_backend.service.GuideService;
import com.example.vivo_backend.vo.GuideVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Guide> getGuideListByUserId(int userId) {
        try{
            QueryWrapper<Guide> wrapper = new QueryWrapper<>();
            wrapper.eq("user_id", userId);
            return guideMapper.selectList(wrapper);
//            List<Guide> result = new ArrayList<>(guides.size());

//            for (Guide guide : guides) {
//                GuideVO guideVO = guide.toGuideVO();
//                result.add(guideVO);
//            }
        }catch (Exception e){
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        }
    }

    @Override
    public List<Guide> getGuideListByCardId(int cardId) {
        try{
            QueryWrapper<Guide> wrapper = new QueryWrapper<>();
            wrapper.eq("card_id", cardId);
            return guideMapper.selectList(wrapper);
        }catch (Exception e){
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        }
    }
}
