package com.audi.infrastructure.service;

public interface EmailService {

    /**
     * 发送邮件验证码
     *
     * @param email
     * @param len
     */
    void sendVerifyCode(String email, int len);
}
