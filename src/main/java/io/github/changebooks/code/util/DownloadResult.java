package io.github.changebooks.code.util;

import io.github.changebooks.code.base.JsonParser;

import java.io.Serializable;

/**
 * Http下载结果
 *
 * @author changebooks@qq.com
 */
public final class DownloadResult implements Serializable {
    /**
     * 状态码
     */
    private int statusCode;

    /**
     * 总文件大小，单位：字节
     */
    private long totalSize;

    /**
     * 已下载文件大小，单位：字节
     */
    private long downloadSize;

    @Override
    public String toString() {
        return JsonParser.toJson(this);
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public long getDownloadSize() {
        return downloadSize;
    }

    public void setDownloadSize(long downloadSize) {
        this.downloadSize = downloadSize;
    }

}
