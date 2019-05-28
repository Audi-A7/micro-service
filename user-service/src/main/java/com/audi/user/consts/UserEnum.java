package com.audi.user.consts;

/**
 * user枚举定义
 *
 * @author WangQuanzhou
 * @date 2019-05-27
 */
public enum UserEnum {

    /**
     * 未知的错误类型
     */
    SUCCESS("0000", "操作成功"),
    UNKNOWN_ERROR("9999", "未知的错误类型"),
    USER_EXISTS("0001", "用户已存在"),
    ;

    private String code;

    private String message;

    UserEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
