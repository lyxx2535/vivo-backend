package com.example.vivo_backend.service;

import com.example.vivo_backend.vo.UserVO;

public interface UserService {
    int login(UserVO loginForm);
    int register(UserVO registerForm);
    Boolean existsTheUsername(String username);
}
