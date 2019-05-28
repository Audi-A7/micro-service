package com.audi.consts;

import java.util.List;

/**
 * 带分页信息的操作结果dto类
 *
 * @author WangQuanzhou
 * @date 2019-05-28
 */
public class PagedResult<T> extends GenericResult<List<T>> {

    /**
     * 数据总数
     */
    private long total;

    /**
     * 当前页
     */
    private int pageIndex;

    /**
     * 每页数据量
     */
    private int pageSize;

    public long getTotal() {
        return total;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public PagedResult(boolean success, String code, String message, List<T> data, long total, int pageIndex, int pageSize) {
        super(success, code, message, data);
        this.total = total;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }
}
