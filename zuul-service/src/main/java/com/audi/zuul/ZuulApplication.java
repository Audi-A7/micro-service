package com.audi.zuul;

import com.audi.zuul.filter.MyFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
        log.info("zuul service started success...");
    }


    /**
     * 使过滤器生效
     *
     * @return
     */
    @Bean
    public MyFilter myFilter() {
        return new MyFilter();
    }

}
