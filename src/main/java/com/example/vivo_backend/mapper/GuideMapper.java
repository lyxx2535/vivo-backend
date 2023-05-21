package com.example.vivo_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.vivo_backend.entity.Guide;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GuideMapper extends BaseMapper<Guide> {
}
