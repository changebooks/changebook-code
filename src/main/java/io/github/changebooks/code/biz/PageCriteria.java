package io.github.changebooks.code.biz;

import io.github.changebooks.code.base.Check;
import io.github.changebooks.code.base.JsonParser;

import java.io.Serializable;

/**
 * 分页条件
 * <pre>
 * 普通分页
 * LIMIT ${startRow}, ${pageSize}
 * </pre>
 *
 * <pre>
 * id分页
 * id &gt; ${startId}
 * LIMIT ${pageSize}
 * </pre>
 *
 * @author changebooks@qq.com
 */
public class PageCriteria implements Serializable {
    /**
     * 每页行数
     * LIMIT 0, pageSize
     */
    private Integer pageSize;

    /**
     * 开始行数
     * LIMIT startRow, 10
     */
    private Long startRow;

    /**
     * 开始id
     * id &gt; startId LIMIT 10
     */
    private Long startId;

    @Override
    public String toString() {
        return JsonParser.toJson(this);
    }

    public int getPageSize() {
        return Check.isPositive(pageSize) ? pageSize : 0;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public long getStartRow() {
        return Check.isPositive(startRow) ? startRow : 0;
    }

    public void setStartRow(Long startRow) {
        this.startRow = startRow;
    }

    public long getStartId() {
        return Check.isPositive(startId) ? startId : 0;
    }

    public void setStartId(Long startId) {
        this.startId = startId;
    }

}
