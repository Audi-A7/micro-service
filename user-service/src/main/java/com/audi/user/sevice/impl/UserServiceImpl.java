package com.audi.user.sevice.impl;

import cn.hutool.core.date.DateUtil;
import com.audi.consts.GenericResult;
import com.audi.consts.Results;
import com.audi.user.consts.UserEnum;
import com.audi.user.dao.UserMapper;
import com.audi.user.dao.po.UserPO;
import com.audi.user.model.User;
import com.audi.user.sevice.UserService;
import com.audi.user.utils.CryptoUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    UserMapper userMapper;

    @Override
    public GenericResult<Boolean> register(User user) {
        // 注册之前先判断用户是否存在
        if (null != userMapper.selectOne(new LambdaQueryWrapper<UserPO>().eq(UserPO::getEmail, user.getEmail()))) {
            log.error("user alredy exists, email = {}", user.getEmail());
            return Results.failedGeneric(UserEnum.USER_EXISTS.getCode(), UserEnum.USER_EXISTS.getMessage());
        }
        userMapper.insert(convertUser(user));
        return Results.successGeneric(true);
    }

    @Override
    public GenericResult<Boolean> login(String userName, String email, String pwd) {
        return null;
    }

    @Override
    public GenericResult<User> query(String email) {
        return null;
    }

    @Override
    public GenericResult<Boolean> sendVerifyCode(String email) {
        return null;
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
}
