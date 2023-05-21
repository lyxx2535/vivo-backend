package com.example.vivo_backend.controller;

import com.example.vivo_backend.vo.user.LoginForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "登陆与注册")
public class UserController {

    @PostMapping("/login")
    @ApiOperation(value = "用户登录",
                notes = "该方法会1.检查数据库中是否有对应账号 2.检查密码是否一致; 返回错误提示/true(目前全部返回true)")
    @ApiImplicitParam(name="loginForm",value = "登录信息表单",required = true)
    public boolean login(@RequestBody LoginForm loginForm) {
        return true;
    }

    @PostMapping("/register")
    @ApiOperation(value = "用户注册",
            notes = "该方法会检查数据库中是否有对应账号 返回错误提示/true(目前全部返回true)")
    @ApiImplicitParam(name="loginForm",value = "注册信息表单(username:username, password:password)",required = true)
    public boolean register(@RequestBody LoginForm loginForm) {
        return true;
    }

}
