package com.audi.infrastructure.service.impl;

import com.audi.infrastructure.service.EmailService;
import com.audi.infrastructure.utils.CodeUtil;
import com.audi.infrastructure.utils.MailUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {

    private RedisTemplate redisTemplate;

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
        redisTemplate.opsForValue().set(email + PREFIX, code, 10, TimeUnit.MINUTES);
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
