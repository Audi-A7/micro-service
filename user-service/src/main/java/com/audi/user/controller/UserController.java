package com.audi.user.controller;

import com.audi.user.api.UserApi;
import com.audi.user.integration.EmailClient;
import com.audi.user.sevice.UserService;
import com.audi.user.sevice.entity.User;
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
    private UserService userService;

    @Autowired
    private EmailClient emailClient;

    @Override
    public boolean register(User user) {
        log.info("received register user request, email = {}", user.getEmail());
        return userService.register(user);
    }

    @Override
    public boolean login(String userName, String email, String pwd) {
        return userService.login(userName, email, pwd);
    }

    @Override
    public User query(String email) {
        log.info("enter query method, email = {}", email);
        return userService.query(email);
    }

    @Override
    public void sendCode(String email, int len) {
        log.info("received send code request, email = {}", email);
        emailClient.sendEmail(email, len);
    }


}
