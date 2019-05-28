package com.audi.consts;

import com.audi.exception.BusinessException;

/**
 * 操作结果dto类
 *
 * @author WangQuanzhou
 * @date 2019-05-28
 */
public class Result {

    /**
     * 操作是否成功
     */
    private boolean success;

    /**
     * 错误代码
     */
    private String code;

    /**
     * 错误消息
     */
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Result(boolean success, String code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    /**
     * 检查当前状态是否为success,如果为false则抛出{@link com.t4f.gaea.exception.LogicException}
     */
    public void check() throws BusinessException {
        if (!isSuccess()) {
            throw new BusinessException(code, message);
        }
    }
}
