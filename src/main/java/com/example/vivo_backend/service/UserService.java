package com.example.vivo_backend.service;

import com.example.vivo_backend.vo.user.UserVO;

public interface UserService {
    Long login(UserVO loginForm);
    void register(UserVO registerForm);
    Boolean existsTheUsername(String username);
}
