package com.audi.utils;

import java.util.Random;

/**
 * 生成随机数字
 *
 * @author WangQuanzhou
 * @date 2019-06-01
 */
public class CodeUtil {

    private static final String str = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String generateCode(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(str.charAt(new Random().nextInt(str.length())));
        }
        return sb.toString();
    }


    public static void main(String[] args) {
         System.out.println(generateCode(6));
    }


}
