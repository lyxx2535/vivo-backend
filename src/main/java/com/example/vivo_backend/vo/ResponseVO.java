package com.example.vivo_backend.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 状态信息类
 */
@Data
@NoArgsConstructor
public class ResponseVO<T> {
    private String msg;
    private T data;

    public ResponseVO(T data) {
        this.data = data;
        this.msg = "success";
    }

}
