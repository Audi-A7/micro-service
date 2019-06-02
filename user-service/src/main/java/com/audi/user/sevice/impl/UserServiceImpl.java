package com.audi.user.sevice.impl;

import cn.hutool.core.date.DateUtil;
import com.audi.user.dao.UserMapper;
import com.audi.user.dao.po.UserPO;
import com.audi.user.sevice.UserService;
import com.audi.user.sevice.entity.User;
import com.audi.user.utils.CryptoUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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

    private RedisTemplate redisTemplate;

    private static final String PREFIX = ":verify_code:";

    @Override
    public boolean register(User user) {
        // 注册之前先判断用户是否存在
        if (null != userMapper.selectOne(new LambdaQueryWrapper<UserPO>().eq(UserPO::getEmail, user.getEmail()))) {
            log.error("user alredy exists, email = {}", user.getEmail());
            return false;
        }

        // 验证验证码
        if (!redisTemplate.hasKey(user.getEmail() + PREFIX) || !redisTemplate.opsForValue().get(user.getEmail() + PREFIX).equals(user.getVerifyCode())) {
            log.error("false verify code for email = {}", user.getEmail());
            return false;
        }


        userMapper.insert(convertUser(user));
        return true;
    }

    @Override
    public boolean login(String userName, String email, String pwd) {
        UserPO userPO = userMapper.selectOne(new LambdaQueryWrapper<UserPO>().eq(UserPO::getEmail, email));
        if (null == userPO || userPO.getPwd() != CryptoUtil.getMD5(pwd) || !userPO.getUserName().equals(userName)) {
            return true;
        }
        return false;
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

    @Autowired(required = false)
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        this.redisTemplate = redisTemplate;
    }
}
