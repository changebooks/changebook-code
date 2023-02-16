package io.github.changebooks.code.biz;

import io.github.changebooks.code.base.Code;
import io.github.changebooks.code.base.Errors;
import io.github.changebooks.code.base.IResult;

/**
 * 业务异常
 *
 * @author changebooks@qq.com
 */
public class BizException extends RuntimeException {
    /**
     * 错误码
     */
    private int code;

    public BizException(Throwable cause) {
        super(cause);
        this.code = Code.SYSTEM_RUN_ERR;
    }

    public BizException(String message) {
        super(message);
        this.code = Code.SYSTEM_RUN_ERR;
    }

    public BizException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BizException(IResult result) {
        super(result.getMessage());
        this.code = result.getCode();
    }

    public BizException(Errors err) {
        super(err.getMessage());
        this.code = err.getCode();
    }

    public int getCode() {
        return code;
    }

}
