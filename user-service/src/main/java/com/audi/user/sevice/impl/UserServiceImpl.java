package com.audi.user.sevice.impl;

import cn.hutool.core.date.DateUtil;
import com.audi.user.dao.UserMapper;
import com.audi.user.dao.po.UserPO;
import com.audi.user.integration.EmailClient;
import com.audi.user.sevice.UserService;
import com.audi.user.sevice.entity.User;
import com.audi.user.utils.CryptoUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

/**
 * user service 接口实现
 *
 * @author WangQuanzhou
 * @date 2019-05-24
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private EmailClient emailClient;

    private static final String VERIFY_PREFIX = ":verify_code:";

    private static final String TOKEN_PREFIX = ":token:";

    @Override
    public boolean register(User user) {
        // 注册之前先判断用户是否存在
        if (null != userMapper.selectOne(new LambdaQueryWrapper<UserPO>().eq(UserPO::getEmail, user.getEmail()))) {
            log.error("user alredy exists, email = {}", user.getEmail());
            return false;
        }

        // 验证验证码
        if (!stringRedisTemplate.hasKey(user.getEmail() + VERIFY_PREFIX) || !stringRedisTemplate.opsForValue().get(user.getEmail() + VERIFY_PREFIX).equals(user.getVerifyCode())) {
            log.error("false verify code for email = {}", user.getEmail());
            return false;
        }


        userMapper.insert(convertUser(user));
        return true;
    }

    @Override
    public String login(String userName, String email, String pwd) {
        UserPO userPO = userMapper.selectOne(new LambdaQueryWrapper<UserPO>().eq(UserPO::getEmail, email));
        if (null == userPO || !userPO.getPwd().equals(CryptoUtil.getMD5(pwd)) || !userPO.getUserName().equals(userName)) {
            return null;
        }
        String token = emailClient.token(32);
        stringRedisTemplate.opsForValue().set(email + TOKEN_PREFIX, token);
        System.out.println(stringRedisTemplate.opsForValue().get(email + TOKEN_PREFIX));
        return token;
    }

    @Override
    public User query(String email) {
        UserPO userPO = userMapper.selectOne(new LambdaQueryWrapper<UserPO>().eq(UserPO::getEmail, email));
        return convertUserPO(userPO);
    }

    @Override
    public boolean sendVerifyCode(String email) {
        return false;
    }

    private UserPO convertUser(User user) {
        if (null == user) {
            return null;
        }
        UserPO userPO = new UserPO();
        BeanUtils.copyProperties(user, userPO);
        userPO.setPwd(CryptoUtil.getMD5(user.getPwd()));
        userPO.setCreatedBy("wqz");
        userPO.setUpdatedBy("wqz");
        userPO.setCreatedAt(DateUtil.date());
        userPO.setUpdatedAt(DateUtil.date());
        return userPO;
    }

    private User convertUserPO(UserPO userPO) {
        if (null == userPO) {
            return null;
        }
        User user = new User();
        BeanUtils.copyProperties(userPO, user);
        user.setPwd(null);
        return user;
    }

}
