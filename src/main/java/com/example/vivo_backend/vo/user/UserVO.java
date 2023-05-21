package com.example.vivo_backend.vo.user;


import com.example.vivo_backend.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class UserVO {
    @ApiModelProperty(value = "用户名", example = "lyx")
    private String username;
    @ApiModelProperty(value = "密码", example = "123456")
    private String password;

    /**
     * 得到 user，不包括groupId，groupId的绑定通过另外的接口
     * @return User
     */
    public User toUser(){
        return User.builder()
                .username(username)
                .password(password)
                .build();
    }

}
