package io.github.changebooks.code.biz;

import io.github.changebooks.code.base.*;

/**
 * 构建 Data Transfer Object
 *
 * @author changebooks@qq.com
 */
public final class ResultUtils {

    private ResultUtils() {
    }

    /**
     * OK
     *
     * @param data the data of result
     * @param <T>  the type of the desired data
     * @return Result
     */
    public static <T> Result<T> toSuccess(T data) {
        Result<T> result = new Result<>();

        result.setCode(Errors.SUCCESS.getCode());
        result.setMessage(Errors.SUCCESS.getMessage());
        result.setData(data);

        return result;
    }

    /**
     * Data Transfer Object to Data Transfer Object
     *
     * @param parameter the before dto
     * @param <T>       the type of the after data
     * @param <S>       the type of the before data
     * @return the after dto
     */
    public static <T, S> Result<T> fromResult(Result<S> parameter) {
        Result<T> result = new Result<>();

        if (parameter != null) {
            result.setCode(parameter.getCode());
            result.setMessage(parameter.getMessage());
        }

        return result;
    }

    /**
     * BizException to Data Transfer Object
     *
     * @param ex  the business exception
     * @param <T> the type of the desired data
     * @return Result
     */
    public static <T> Result<T> fromException(BizException ex) {
        Result<T> result = new Result<>();

        if (ex != null) {
            result.setCode(ex.getCode());
            result.setMessage(ex.getMessage());
        }

        return result;
    }

    /**
     * NullPointerException to Data Transfer Object
     *
     * @param ex  the null pointer exception
     * @param <T> the type of the desired data
     * @return Result
     */
    public static <T> Result<T> fromException(NullPointerException ex) {
        Result<T> result = new Result<>();

        if (ex != null) {
            result.setCode(Errors.ARGS_ERR.getCode());
            result.setMessage(ex.getMessage());
        }

        return result;
    }

    /**
     * IllegalArgumentException to Data Transfer Object
     *
     * @param ex  the illegal argument exception
     * @param <T> the type of the desired data
     * @return Result
     */
    public static <T> Result<T> fromException(IllegalArgumentException ex) {
        Result<T> result = new Result<>();

        if (ex != null) {
            result.setCode(Errors.ARGS_ERR.getCode());
            result.setMessage(ex.getMessage());
        }

        return result;
    }

    /**
     * Throwable to Data Transfer Object
     *
     * @param tr  the throwable
     * @param <T> the type of the desired data
     * @return Result
     */
    public static <T> Result<T> fromThrowable(Throwable tr) {
        Result<T> result = new Result<>();

        if (tr != null) {
            result.setMessage(tr.getMessage());
        }

        return result;
    }

    /**
     * Error Message to Data Transfer Object
     *
     * @param message the error message
     * @param <T>     the type of the desired data
     * @return Result
     */
    public static <T> Result<T> fromMessage(String message) {
        return fromMessage(Code.SYSTEM_RUN_ERR, message);
    }

    /**
     * Error Code and Error Message to Data Transfer Object
     *
     * @param code    the error code
     * @param message the error message
     * @param <T>     the type of the desired data
     * @return Result
     */
    public static <T> Result<T> fromMessage(int code, String message) {
        Result<T> result = new Result<>();

        result.setCode(code);
        result.setMessage(message);

        return result;
    }

    /**
     * Data Transfer Interface to Data Transfer Object
     *
     * @param ri  the before dti
     * @param <T> the type of the desired data
     * @return the after dto
     */
    public static <T> Result<T> fromResult(IResult ri) {
        return fromResult(ri, null);
    }

    /**
     * Data Transfer Interface and Error Message to Data Transfer Object
     *
     * @param ri      the before dti
     * @param message the error message
     * @param <T>     the type of the desired data
     * @return the after dto
     */
    public static <T> Result<T> fromResult(IResult ri, String message) {
        Result<T> result = new Result<>();

        if (ri != null) {
            result.setCode(ri.getCode());
            result.setMessage(ri.getMessage());
        }

        if (message != null) {
            result.setMessage(message);
        }

        return result;
    }

    /**
     * Data Transfer Object to View Object
     * Result to ResultSuccess
     * Result to ResultSuccess.WithoutData
     * Result to ResultError
     * Result to ResultError.WithoutData
     *
     * @param result the dto
     * @param <T>    the type of the desired data
     * @return the vo
     */
    public static <T> Object dtoToVo(Result<T> result) {
        if (result == null) {
            return null;
        }

        T data = result.getData();

        if (result.isSuccess()) {
            return (data != null) ? new ResultSuccess<>(data) : new ResultSuccess.WithoutData();
        } else {
            int code = result.getCode();
            String message = result.getMessage();

            return (data != null) ? new ResultError<>(code, message, data) : new ResultError.WithoutData(code, message);
        }
    }

}
