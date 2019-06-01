package com.audi.user.integration;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "infrastructure")
public interface EmailClient {

    @GetMapping("send/{email}/{len}")
    void sendEmail(@PathVariable("email") String email, @PathVariable("len") int len);
}
