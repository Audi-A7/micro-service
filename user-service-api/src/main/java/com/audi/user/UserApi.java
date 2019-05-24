package com.audi.user;

import com.audi.user.model.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author WangQuanzhou
 * @date 2019-05-24
 */
@RequestMapping("user")
public interface UserApi {


    /**
     * 登录接口
     *
     * @param user
     * @return
     */
    @PostMapping
    boolean register(@RequestBody User user);


    /**
     * 登录接口
     *
     * @param userName
     * @param email
     * @param pwd
     * @return
     */
    @GetMapping
    boolean login(@RequestParam(name = "userName") String userName,
                  @RequestParam(name = "email") String email,
                  @RequestParam(name = "pwd") String pwd);


    /**
     * 查询用户信息  查询时  需要判断用户是否已经登录
     *
     * @param email
     * @return
     */
    @GetMapping(value = "{email}")
    User query(@PathVariable(name = "email") String email);
}
