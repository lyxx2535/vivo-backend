package com.example.vivo_backend.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class PictureVO {
    @ApiModelProperty(value = "用户名", example = "lyx")
    private int pictureId;
    @ApiModelProperty(value = "密码", example = "123456")
    private String password;
}
