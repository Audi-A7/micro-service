package com.audi.user.dao.po;

import lombok.Data;

/**
 * user 数据库持久化对象
 *
 * @author WangQuanzhou
 * @date 2019-05-24
 */
@Data
public class UserPO extends BasePO {
    private String userName;
    private String pwd;
    private String email;
}
