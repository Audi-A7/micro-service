package com.audi.user.model;

import lombok.Data;

/**
 * user实体对象
 *
 * @author WangQuanzhou
 * @date 2019-05-24
 */
@Data
public class User {

    private String userName;
    private String pwd;
    private String email;
    private String verifyCode;
    private String token;
}
