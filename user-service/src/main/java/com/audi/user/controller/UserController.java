package com.audi.user.controller;

import com.audi.consts.GenericResult;
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
    public GenericResult<Boolean> register(User user) {
        log.info("received register user request, email = {}", user.getEmail());
        return userService.register(user);
    }

    @Override
    public GenericResult<Boolean> login(String userName, String email, String pwd) {
        return userService.login(userName, email, pwd);
    }

    @Override
    public GenericResult<User> query(String email) {
        log.info("enter query method, email = {}", email);
        return userService.query(email);
    }

    @Override
    public GenericResult<Boolean> sendVerifyCode(String email) {
        return userService.sendVerifyCode(email);
    }
}
