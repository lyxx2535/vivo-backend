package com.example.vivo_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.vivo_backend.entity.Guide;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GuideMapper extends BaseMapper<Guide> {
    List<Guide> selectByUserId(int userId);
    List<Guide> selectByCardId(int cardId);
}
