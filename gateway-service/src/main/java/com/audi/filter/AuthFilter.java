package com.audi.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;

/**
 * 过滤器
 *
 * @author WangQuanzhou
 * @date 2019-08-18
 */
@Slf4j
@Component
public class AuthFilter implements GlobalFilter {

    private static final String TOKEN = "token";

    private static final String REGISTER_URI = "/register";

    private static final String LOGIN_URI = "/login";

    private static final String EMAIL_SEND_URI = "/send";

    private static final String EMAIL = "email";

    private static final String PREFIX = ":token:";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("enter gate way filter...");
        String email = exchange.getRequest().getHeaders().getFirst(EMAIL);
        String token = exchange.getRequest().getHeaders().getFirst(TOKEN);
        String path = exchange.getRequest().getURI().getPath();



        //  除开注册服务 和邮件服务  其他的请求都应该进行过滤
        if (path.equals(REGISTER_URI) || path.startsWith(LOGIN_URI) || path.startsWith(EMAIL_SEND_URI)) {
            return chain.filter(exchange);
        }
        if (StringUtils.isEmpty(token)) {
            // FIXME: 2019-08-18 设置返回码
            log.error("token is null...");
            return null;
        } else if (token.equals(stringRedisTemplate.opsForValue().get(email + PREFIX))) {
            log.info("token is correct...");
            return chain.filter(exchange);
        }

        return null;
    }
}
