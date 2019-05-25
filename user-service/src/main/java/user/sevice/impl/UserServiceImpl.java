package user.sevice.impl;

import cn.hutool.core.date.DateUtil;
import com.audi.user.model.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.dao.UserMapper;
import user.dao.po.UserPO;
import user.sevice.UserService;

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
    public boolean register(User user) {
        // 注册之前先判断用户是否存在
        if (null != userMapper.selectOne(new LambdaQueryWrapper<UserPO>().eq(UserPO::getEmail, user.getEmail()))) {
            log.error("user alredy exists, email = {}", user.getEmail());
            return false;
        }
        userMapper.insert(convertUser(user));
        return true;
    }

    @Override
    public boolean login(String userName, String email, String pwd) {
        return false;
    }

    @Override
    public User query(String email) {
        return null;
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
        userPO.setCreatedBy("wqz");
        userPO.setUpdatedBy("wqz");
        userPO.setCreatedAt(DateUtil.date());
        userPO.setUpdatedAt(DateUtil.date());
        return userPO;
    }
}
