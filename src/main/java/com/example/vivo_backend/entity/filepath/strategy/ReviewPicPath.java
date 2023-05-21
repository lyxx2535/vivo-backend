package com.example.vivo_backend.entity.filepath.strategy;

import com.example.vivo_backend.constant.FileType;

public class ReviewPicPath extends FilePath{
    public ReviewPicPath(String downloadUrl, String typePath, FileType fileType) {
        super(downloadUrl, typePath, fileType);
    }

    @Override
    public String getContentType() {
        return "image/png";
    }
}
