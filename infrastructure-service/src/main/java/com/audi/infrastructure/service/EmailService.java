package com.audi.infrastructure.service;

public interface EmailService {

    /**
     * 发送邮件验证码
     *
     * @param email
     * @param len
     */
    void sendVerifyCode(String email, int len);


    /**
     * 获取指定长度的token
     *
     * @param len
     * @return
     */
    String token(int len);
}
