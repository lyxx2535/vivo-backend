package com.example.vivo_backend.controller;

import com.example.vivo_backend.service.UserService;
import com.example.vivo_backend.vo.ResponseVO;
import com.example.vivo_backend.vo.user.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "登陆与注册")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "用户登录",
                notes = "该方法会1.检查数据库中是否有对应账号 2.检查密码是否一致; 正确则返回userid")
    public ResponseVO<Integer> login(@RequestBody UserVO userVO) {
        return new ResponseVO<>(userService.login(userVO));
    }

    @PostMapping("/register")
    @ApiOperation(value = "用户注册",
            notes = "该方法会检查数据库中是否有对应账号 返回错误提示/true(目前全部返回true)")
    public void register(@RequestBody UserVO userVO) {
        userService.register(userVO);
    }

}
