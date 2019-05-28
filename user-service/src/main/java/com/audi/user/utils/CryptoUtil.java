package com.audi.user.utils;

import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;

/**
 * 加密工具类
 *
 * @author WangQuanzhou
 * @date 2019-05-28
 */
@Slf4j
public class CryptoUtil {

    public static String getMD5(String sourceStr) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(sourceStr.getBytes("utf-8"));
            StringBuffer sb = new StringBuffer();
            String temp;
            for (byte b : bytes) {
                temp = Integer.toHexString(b & 0XFF);
                sb.append(temp.length() == 1 ? "0" + temp : temp);
            }
            return sb.toString();
        } catch (Exception e) {
            log.error("getMD5 with unexpected exception, str:{}", sourceStr, e);
            return null;
        }
    }
}
