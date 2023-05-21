package com.example.vivo_backend.vo.user;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class LoginForm {
    @ApiModelProperty(value = "用户名", example = "123456")
    private String username;
    @ApiModelProperty(value = "密码", example = "123456")
    private String password;

}
