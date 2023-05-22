package com.example.vivo_backend.service.impl;

import com.example.vivo_backend.entity.Guide;
import com.example.vivo_backend.service.GuideService;
import com.example.vivo_backend.service.ReportService;
import com.example.vivo_backend.service.ReviewService;
import com.example.vivo_backend.vo.ReportVO;
import com.example.vivo_backend.vo.Review.RealReviewVO;
import com.example.vivo_backend.vo.TagVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    private static final HashMap<String, Integer> tags = new HashMap<>();
    static {
        tags.put("美食",0);
        tags.put("人文景点",1);
        tags.put("自然景点",2);
        tags.put("购物",3);
        tags.put("商务",4);
        tags.put("运动",5);
        tags.put("其他",6);
    }
    @Autowired
    private GuideService guideService;

    @Autowired
    private ReviewService reviewService;
    @Override
    public ReportVO getReviewReport(int userId) {
        List<RealReviewVO> reviews = reviewService.getReviewListByUserId(userId);
        List<TagVO>tagVOS = initTagVOList();
        for(RealReviewVO realReviewVO: reviews){
            tagVOS.get(tags.get(realReviewVO.getType())).addOne();
        }
        return new ReportVO(tagVOS);
    }

    @Override
    public ReportVO getGuideReport(int userId) {
        List<Guide> guides = guideService.getGuideListByUserId(userId);
        List<TagVO>tagVOS = initTagVOList();
        for(Guide guide: guides){
            tagVOS.get(tags.get(guide.getType())).addOne();
        }
        return new ReportVO(tagVOS);
    }
    private List<TagVO> initTagVOList(){
        List<TagVO> tagVOS = new ArrayList<>();
        tagVOS.add(new TagVO("美食",0));
        tagVOS.add(new TagVO("人文景点",0));
        tagVOS.add(new TagVO("自然景点",0));
        tagVOS.add(new TagVO("购物",0));
        tagVOS.add(new TagVO("商务",0));
        tagVOS.add(new TagVO("运动",0));
        tagVOS.add(new TagVO("其他",0));
        return tagVOS;
    }
}
