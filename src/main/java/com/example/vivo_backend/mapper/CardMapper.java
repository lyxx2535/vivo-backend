package com.example.vivo_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.vivo_backend.entity.Card;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CardMapper extends BaseMapper<Card> {
}
