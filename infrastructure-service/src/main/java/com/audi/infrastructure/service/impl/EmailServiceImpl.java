package com.audi.infrastructure.service.impl;

import com.audi.infrastructure.service.EmailService;
import com.audi.infrastructure.utils.CodeUtil;
import com.audi.infrastructure.utils.MailUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final String PREFIX = ":verify_code:";

    private static final String SUBJECT = "注册验证码";

    private static final String CONTENT = "您的验证码是：";

    @Override
    public void sendVerifyCode(String email, int len) {
        String code = CodeUtil.generateCode(len);
        log.info("verify code for {}  = {}", email, code);
        try {

            MailUtil.sendEmail("audi.car@qq.com", email, code, SUBJECT, CONTENT);
        } catch (Exception e) {
            log.error("send verify code error, email = {}", email, e);
            return;
        }
        stringRedisTemplate.opsForValue().set(email + PREFIX, code, 10, TimeUnit.MINUTES);
    }

    /**
     * 获取指定长度的token
     *
     * @param len
     * @return
     */
    @Override
    public String token(int len) {
        String token = CodeUtil.generateCode(len);
        log.info("len = {}, token = {}", len, token);
        return token;
    }
}
