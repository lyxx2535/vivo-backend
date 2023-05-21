package com.example.vivo_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.vivo_backend.entity.Picture;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PictureMapper extends BaseMapper<Picture> {
}
