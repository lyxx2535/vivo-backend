package com.example.vivo_backend.constant;

import com.baomidou.mybatisplus.core.enums.IEnum;

public enum FileType implements IEnum<Integer> {
    REVIEW_PIC(1, "REVIEW_PIC"), // 游记图片
    PDF_REPORT(2, "PDF_DOCUMENT"); // pdf报告

    private final int value;
    private final String desc;

    FileType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }


    @Override
    public String toString() {
        return this.desc;
    }
}