package com.audi.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Slf4j
public class MyFilter extends ZuulFilter {

    private static final String TOKEN = "token";

    private static final String REGISTER_URI = "/user/register";

    private static final String LOGIN_URI = "/user/login";

    private static final String EMAIL_URI = "/email";

    private static final String EMAIL = "email";

    private static final String PREFIX = ":token:";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        String uri = request.getRequestURI();
        log.info("request uri = {}", uri);

        String token = request.getHeader(TOKEN);
        String email = request.getHeader(EMAIL);


        //  除开注册服务 和邮件服务  其他的请求都应该进行过滤
        if (uri.equals(REGISTER_URI) || uri.startsWith(LOGIN_URI) || uri.startsWith(EMAIL_URI)) {
            return null;
        }
        if (StringUtils.isEmpty(token)) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("token is empty");
        } else if (!token.equals(stringRedisTemplate.opsForValue().get(email + PREFIX))) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(403);
            ctx.setResponseBody("token invalid");
        }
        return null;
    }
}
