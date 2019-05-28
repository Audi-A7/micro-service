package com.audi.consts;

import java.util.List;

/**
 * 操作结果辅助类
 *
 * @author WangQuanzhou
 * @date 2019-05-28
 */
public class Results {

    /**
     * 生成一个成功结果
     *
     * @return
     */
    public static Result success() {
        Result result = new Result(true, null, null);

        return result;
    }

    /**
     * 生成一个错误结果
     *
     * @param code    错误码
     * @param message 错误消息
     * @return
     */
    public static Result failed(final String code, final String message) {
        Result result = new Result(false, code, message);

        return result;
    }

    /**
     * 生成一个泛型成功结果
     *
     * @param data 泛型实例
     * @param <T>  泛型类型
     * @return
     */
    public static <T> GenericResult<T> successGeneric(final T data) {
        GenericResult<T> result = new GenericResult<T>(true, null, null, data);

        return result;
    }

    /**
     * 生成一个泛型错误结果
     *
     * @param code    错误码
     * @param message 错误消息
     * @param <T>     泛型类型
     * @return
     */
    public static <T> GenericResult<T> failedGeneric(final String code, final String message) {
        GenericResult<T> result = new GenericResult<T>(false, code, message, null);

        return result;
    }

    /**
     * 生成一个分页成功结果
     *
     * @param data  数据列表
     * @param total 总记录数
     * @param <T>   泛型类型
     * @return
     */
    public static <T> PagedResult<T> successPaged(final List<T> data, final long total) {
        PagedResult<T> result = new PagedResult<T>(true, null, null, data, total, 0, 0);

        return result;
    }

    /**
     * 生成一个带页码的分页成功结果
     *
     * @param data      数据列表
     * @param total     总记录数
     * @param pageIndex 页码
     * @param pageSize  每页大小
     * @param <T>       泛型类型
     * @return
     */
    public static <T> PagedResult<T> successPaged(final List<T> data, final long total, final int pageIndex, final int pageSize) {
        PagedResult<T> result = new PagedResult<T>(true, null, null, data, total, pageIndex, pageSize);

        return result;
    }

    /**
     * 返回错误的分页结果
     *
     * @param code
     * @param message
     * @param <T>
     * @return
     */
    public static <T> PagedResult<T> failedPaged(final String code, final String message) {
        PagedResult<T> result = new PagedResult<T>(false, code, message, null, 0, 0, 0);

        return result;
    }
}
