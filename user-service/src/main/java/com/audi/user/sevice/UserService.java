package com.audi.user.sevice;


import com.audi.consts.GenericResult;
import com.audi.user.model.User;

public interface UserService {

    GenericResult<Boolean> register(User user);

    GenericResult<Boolean> login(String userName, String email, String pwd);

    GenericResult<User> query(String email);

    GenericResult<Boolean> sendVerifyCode(String email);
}
