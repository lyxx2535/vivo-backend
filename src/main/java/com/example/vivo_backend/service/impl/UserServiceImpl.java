package com.example.vivo_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.vivo_backend.entity.User;
import com.example.vivo_backend.exception.BadRequestException;
import com.example.vivo_backend.mapper.UserMapper;
import com.example.vivo_backend.service.UserService;
import com.example.vivo_backend.vo.user.UserVO;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int login(UserVO loginForm) {
        String username = loginForm.getUsername(), password = loginForm.getPassword();
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);

        User user;
        try {//找到的用户名多于一条
            user = userMapper.selectOne(wrapper);
        } catch (Exception e) {
            throw new BadRequestException("该用户名已被使用！");
        }
        if (user == null)
            throw new BadRequestException("该用户名尚未注册！");

        if (password == null || !password.equals(user.getPassword()))
            throw new BadRequestException("密码错误！");

        return user.getId();
    }

    /**
     * @return 不为空 则存在
     */
    @Override
    public Boolean existsTheUsername(String username) {
        System.out.println(username);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);

        User user = userMapper.selectOne(wrapper);//如果能找到，说明用户名已经存在
        return user != null;
    }

    @Override
    public void register(UserVO registerForm) {
        if (existsTheUsername(registerForm.getUsername()))
            throw new BadRequestException("该用户名已经存在！");
        System.out.println("here");
        User user = registerForm.toUser();
        userMapper.insert(user);
    }

}
