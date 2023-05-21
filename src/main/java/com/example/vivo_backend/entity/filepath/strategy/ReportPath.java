package com.example.vivo_backend.entity.filepath.strategy;

import com.example.vivo_backend.constant.FileType;

public class ReportPath extends FilePath{
    public ReportPath(String downloadUrl, String typePath, FileType fileType) {
        super(downloadUrl, typePath, fileType);
    }

    @Override
    public String getContentType() {
        return "application/pdf";
    }
}
