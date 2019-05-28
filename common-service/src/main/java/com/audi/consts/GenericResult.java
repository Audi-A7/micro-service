package com.audi.consts;

import com.audi.exception.BusinessException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 泛型操作结果dto类
 *
 * @author WangQuanzhou
 * @date 2019-05-28
 */
public class GenericResult<T> extends Result {

    /**
     * 泛型实例
     */
    private T data;

    /**
     * 尝试获取data,如果当前状态不是success,则抛出{@link BusinessException}
     *
     * @return
     */
    @JsonIgnore
    public T getData() throws BusinessException {
        check();

        return getDataSafely();
    }

    /**
     * 安全的获取data,不会抛出{@link BusinessException}
     *
     * @return
     */
    @JsonProperty("data")
    public T getDataSafely() {
        return data;
    }

    @JsonCreator
    public GenericResult(
            @JsonProperty("success") boolean success,
            @JsonProperty("code") String code,
            @JsonProperty("message") String message,
            @JsonProperty("data") T data) {
        super(success, code, message);
        this.data = data;
    }
}
