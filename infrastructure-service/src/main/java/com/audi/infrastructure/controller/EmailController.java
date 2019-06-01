package com.audi.infrastructure.controller;

import com.audi.infrastructure.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("send/{email}/{len}")
    public void sendEmail(@PathVariable("email") String email, @PathVariable("len") int len) {
        emailService.sendVerifyCode(email, len);
        return;
    }
}
