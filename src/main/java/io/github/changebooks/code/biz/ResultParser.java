package io.github.changebooks.code.biz;

import io.github.changebooks.code.base.Check;
import io.github.changebooks.code.base.Errors;
import io.github.changebooks.code.base.JsonParser;
import io.github.changebooks.code.base.Result;
import io.github.changebooks.code.util.AssertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * 解析 View Object Json Result
 * <pre>
 * {"success":true}
 * {"success":true,"data":123456}
 * {"code":500,"message":"系统运行异常"}
 * {"code":500,"message":"系统运行异常","data":123456}
 * </pre>
 *
 * @author changebooks@qq.com
 */
public final class ResultParser {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResultParser.class);

    /**
     * Success Result View Object
     * <pre>
     * {"success":true}
     * </pre>
     */
    public static final class ResultSuccess {
        /**
         * 状态
         */
        private boolean success = false;

    }

    /**
     * Result.setCode(int code)
     * Result.setMessage(String message)
     */
    private static final String METHOD_NAME_SET_CODE = "setCode";
    private static final String METHOD_NAME_SET_MESSAGE = "setMessage";
    private static final Method SET_CODE;
    private static final Method SET_MESSAGE;

    static {
        Method setCode;
        Method setMessage;

        try {
            setCode = Result.class.getDeclaredMethod(METHOD_NAME_SET_CODE, int.class);
            setMessage = Result.class.getDeclaredMethod(METHOD_NAME_SET_MESSAGE, String.class);
        } catch (NoSuchMethodException ex) {
            LOGGER.error("reflect result's declared method failed, METHOD_NAME_SET_CODE: {}, METHOD_NAME_SET_MESSAGE: {}, throwable: ",
                    METHOD_NAME_SET_CODE, METHOD_NAME_SET_MESSAGE, ex);
            throw new RuntimeException(ex);
        }

        SET_CODE = setCode;
        SET_MESSAGE = setMessage;
    }

    private ResultParser() {
    }

    /**
     * Json Str to Object
     * <pre>
     * jsonStr: {"success":true},               return: Result {"code":0, "message":"ok"}
     * jsonStr: {"success":false},              return: Result {"code":500,"message":"system error"}
     * jsonStr: {"code":500,"message":"error"}, return: Result {"code":500,"message":"error"}
     * </pre>
     *
     * @param jsonStr View Object Result Json: {"success":true}
     * @param type    the reflect of the desired result
     * @param <T>     the type of the desired result
     * @return Result
     */
    public static <T> T parseJson(String jsonStr, Type type) {
        try {
            return parseJsonThrowException(jsonStr, type);
        } catch (InvocationTargetException | IllegalAccessException ex) {
            LOGGER.error("parseJson failed, jsonStr: {}, type: {}, throwable: ", jsonStr, type, ex);
            throw new RuntimeException(ex);
        }
    }

    /**
     * Json Str to Object
     * <pre>
     * jsonStr: {"success":true},               return: Result {"code":0, "message":"ok"}
     * jsonStr: {"success":false},              return: Result {"code":500,"message":"system error"}
     * jsonStr: {"code":500,"message":"error"}, return: Result {"code":500,"message":"error"}
     * </pre>
     *
     * @param jsonStr View Object Result Json: {"success":true}
     * @param type    the reflect of the desired result
     * @param <T>     the type of the desired result
     * @return Result
     * @throws InvocationTargetException if the underlying method throws an exception.
     * @throws IllegalAccessException    if this {@code Method} object is enforcing Java language access control and
     *                                   the underlying method is inaccessible.
     */
    public static <T> T parseJsonThrowException(String jsonStr, Type type)
            throws InvocationTargetException, IllegalAccessException {
        if (Check.isEmpty(jsonStr)) {
            return null;
        }

        T result = JsonParser.fromJson(jsonStr, type);
        if (Check.isNull(result)) {
            return null;
        }

        if (result instanceof Result && success(jsonStr)) {
            AssertUtils.nonNull(SET_CODE, "ResultParser.SET_CODE");
            AssertUtils.nonNull(SET_MESSAGE, "ResultParser.SET_MESSAGE");

            SET_CODE.invoke(result, Errors.SUCCESS.getCode());
            SET_MESSAGE.invoke(result, Errors.SUCCESS.getMessage());
        }

        return result;
    }

    /**
     * Success Result ?
     * <pre>
     * jsonStr: {"success":true},               return: true
     * jsonStr: {"success":false},              return: false
     * jsonStr: {"code":500,"message":"error"}, return: false
     * </pre>
     *
     * @param jsonStr View Object Result Json: {"success":true}
     * @return contains key: success ?
     */
    public static boolean success(String jsonStr) {
        if (Check.isEmpty(jsonStr)) {
            return false;
        }

        ResultSuccess result = JsonParser.fromJson(jsonStr, ResultSuccess.class);
        if (Check.isNull(result)) {
            return false;
        } else {
            return result.success;
        }
    }

}
