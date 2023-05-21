package com.example.vivo_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.vivo_backend.entity.Review;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ReviewMapper extends BaseMapper<Review> {
}
