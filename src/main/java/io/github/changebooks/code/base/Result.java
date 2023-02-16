package io.github.changebooks.code.base;

import java.io.Serializable;

/**
 * Data Transfer Object
 *
 * @author changebooks@qq.com
 */
public final class Result<T> implements IResult, Serializable {
    /**
     * 错误码
     * 0：正确、gt 0：错误、lt 0：弃用
     */
    private int code;

    /**
     * 错误信息
     * ok：正确、!ok：错误
     */
    private String message;

    /**
     * 内容
     */
    private T data;

    public Result() {
        this.code = Code.SYSTEM_RUN_ERR;
        this.message = Errors.SYSTEM_RUN_ERR.getMessage();
    }

    @Override
    public String toString() {
        return JsonParser.toJson(this);
    }

    public boolean isSuccess() {
        return code == Errors.SUCCESS.getCode();
    }

    public boolean isError() {
        return code != Errors.SUCCESS.getCode();
    }

    @Override
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
