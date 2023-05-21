package com.example.vivo_backend.controller;

import com.example.vivo_backend.service.UserService;
import com.example.vivo_backend.vo.ResponseVO;
import com.example.vivo_backend.vo.user.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
                notes = "该方法会1.检查数据库中是否有对应账号 2.检查密码是否一致; 正确则返回")
    @ApiImplicitParam(name="loginForm",value = "登录信息表单",required = true)
    public Long login(@RequestBody UserVO loginForm) {
        return new ResponseVO<>(userService.login(loginForm));
    }

    @PostMapping("/register")
    @ApiOperation(value = "用户注册",
            notes = "该方法会检查数据库中是否有对应账号 返回错误提示/true(目前全部返回true)")
    @ApiImplicitParam(name="loginForm",value = "注册信息表单(username:username, password:password)",required = true)
    public Long register(@RequestBody UserVO registerForm) {
        return new ResponseVO<>(userService.register(registerForm));
    }

}
