package com.example.vivo_backend;

import com.example.vivo_backend.controller.UserController;
import com.example.vivo_backend.exception.BadRequestException;
import com.example.vivo_backend.vo.UserVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class UserTests {
    @Autowired
    private UserController userController;
    @Test
    @Transactional
    @Rollback(value = true)
    void userTest(){
        UserVO userVO = new UserVO("notInDB","md5CypherString");
        try{
            userController.login(userVO);
            Assertions.assertEquals(0,1);
        }catch (BadRequestException e){

        }

        try {
            int id = userController.register(userVO).getData();
            int id2 = userController.login(userVO).getData();
            Assertions.assertEquals(id,id2);
        }catch (Exception e){
            Assertions.assertEquals(0,1);
        }

        try{
            userController.register(userVO);
            Assertions.assertEquals(0,1);
        }catch (BadRequestException e){

        }
    }
}
