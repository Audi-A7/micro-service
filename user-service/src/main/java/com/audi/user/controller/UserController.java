package com.audi.user.controller;

import com.audi.user.UserApi;
import com.audi.user.model.User;
import com.audi.user.sevice.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户controller
 *
 * @author WangQuanzhou
 * @date 2019-05-24
 */
@RestController
@Slf4j
public class UserController implements UserApi {

    @Autowired
    UserService userService;

    @Override
    public boolean register(User user) {
        log.info("received register user request, email = {}", user.getEmail());
        return userService.register(user);
    }

    @Override
    public boolean login(String userName, String email, String pwd) {
        return false;
    }

    @Override
    public User query(String email) {
        log.info("enter query method, email = {}", email);
        return null;
    }

    @Override
    public boolean sendVerifyCode(String email) {
        return false;
    }
}
