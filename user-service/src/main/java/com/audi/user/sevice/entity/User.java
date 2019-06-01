package com.audi.user.sevice.entity;


import lombok.Data;

@Data
public class User {
    private String userName;
    private String pwd;
    private String email;
    private String verifyCode;
    private String token;
}
