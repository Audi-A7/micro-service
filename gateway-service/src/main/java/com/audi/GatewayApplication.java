package com.audi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springcloud gateway网关服务
 *
 * @author WangQuanzhou
 * @date 2019-08-18
 */
@Slf4j
@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
        log.info("api gateway service started success...");
    }
}
