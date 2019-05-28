package com.audi.exception;

/**
 * 业务逻辑异常
 * *
 * * 如果要快速跳出业务逻辑,建议抛出这个异常,会返回HTTP status 200,并输出code和message
 *
 * @author WangQuanzhou
 * @date 2019-05-27
 */
public class BusinessException extends RuntimeException {

    /**
     * 错误代码
     */
    private String code;

    public String getCode() {
        return code;
    }

    public BusinessException(String code) {
        this.code = code;
    }

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public BusinessException(String code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public BusinessException(String code, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }
}
