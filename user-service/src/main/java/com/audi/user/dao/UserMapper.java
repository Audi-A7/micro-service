package com.audi.user.dao;

import com.audi.user.dao.po.UserPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * user 数据库接口
 *
 * @author WangQuanzhou
 * @date 2019-05-25
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<UserPO> {
}
