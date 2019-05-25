package user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import user.dao.po.UserPO;

@Repository
public interface UserMapper extends BaseMapper<UserPO> {
}
