package com.example.vivo_backend.service.impl;

import com.example.vivo_backend.entity.Picture;
import com.example.vivo_backend.mapper.PictureMapper;
import com.example.vivo_backend.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureMapper pictureMapper;

    @Override
    public void addPicture(String pictureUrl){
        Picture picture = new Picture();
        picture.setPictureUrl(pictureUrl);
        picture.setReviewId(-1);
        pictureMapper.insert(picture);
    }
}
