package io.github.changebooks.code.biz;

import io.github.changebooks.code.base.IResult;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;

/**
 * 前提条件，标准提示
 *
 * @author changebooks@qq.com
 */
public final class BizAssert {

    private BizAssert() {
    }

    /**
     * 正确？is true
     * %s must be true
     *
     * @param b      the boolean
     * @param result the data transfer interface
     * @throws BizException if the value is false
     */
    public static void isTrue(boolean b, IResult result) {
        if (!b) {
            throw new BizException(result);
        }
    }

    /**
     * 错误？is false
     * %s must be false
     *
     * @param b      the boolean
     * @param result the data transfer interface
     * @throws BizException if the value is true
     */
    public static void isFalse(boolean b, IResult result) {
        if (b) {
            throw new BizException(result);
        }
    }

    /**
     * 空对象？is null
     * %s must be null
     *
     * @param obj    the object
     * @param result the data transfer interface
     * @throws BizException if the object is not null
     */
    public static void isNull(Object obj, IResult result) {
        if (obj != null) {
            throw new BizException(result);
        }
    }

    /**
     * 非空对象？not null
     * %s can't be null
     *
     * @param obj    the object
     * @param result the data transfer interface
     * @throws BizException if the object is null
     */
    public static void nonNull(Object obj, IResult result) {
        if (obj == null) {
            throw new BizException(result);
        }
    }

    /**
     * 非空字符串？not null and not empty ("")
     * %s can't be null
     * %s can't be empty
     *
     * @param str    the string
     * @param result the data transfer interface
     * @throws BizException if the str is null
     * @throws BizException if the str is empty
     */
    public static void nonEmpty(String str, IResult result) {
        nonNull(str, result);

        if (str.isEmpty()) {
            throw new BizException(result);
        }
    }

    /**
     * 非空集合？not null and not empty
     * %s can't be null
     * %s can't be empty
     *
     * @param collection the collection
     * @param result     the data transfer interface
     * @throws BizException if the collection is null
     * @throws BizException if the collection is empty
     */
    public static void nonEmpty(Collection<?> collection, IResult result) {
        nonNull(collection, result);

        if (collection.isEmpty()) {
            throw new BizException(result);
        }
    }

    /**
     * 非空Map？not null and not empty
     * %s can't be null
     * %s can't be empty
     *
     * @param map    the map
     * @param result the data transfer interface
     * @throws BizException if the map is null
     * @throws BizException if the map is empty
     */
    public static void nonEmpty(Map<?, ?> map, IResult result) {
        nonNull(map, result);

        if (map.isEmpty()) {
            throw new BizException(result);
        }
    }

    /**
     * 非零？not null and unequal than 0
     * %s can't be null
     * %s can't be equal than 0
     *
     * @param num    the int
     * @param result the data transfer interface
     * @throws BizException if the num is null
     * @throws BizException if the num is equal than 0
     */
    public static void nonZero(Integer num, IResult result) {
        nonNull(num, result);

        if (num == 0) {
            throw new BizException(result);
        }
    }

    /**
     * 非零？not null and unequal than 0
     * %s can't be null
     * %s can't be equal than 0
     *
     * @param num    the long
     * @param result the data transfer interface
     * @throws BizException if the num is null
     * @throws BizException if the num is equal than 0
     */
    public static void nonZero(Long num, IResult result) {
        nonNull(num, result);

        if (num == 0L) {
            throw new BizException(result);
        }
    }

    /**
     * 非零？not null and unequal than 0
     * %s can't be null
     * %s can't be equal than 0
     *
     * @param num    the decimal
     * @param result the data transfer interface
     * @throws BizException if the num is null
     * @throws BizException if the num is equal than 0
     */
    public static void nonZero(BigDecimal num, IResult result) {
        nonNull(num, result);

        if (num.compareTo(BigDecimal.ZERO) == 0) {
            throw new BizException(result);
        }
    }

    /**
     * 正数？not null and greater than 0
     * %s can't be null
     * %s must be greater than 0
     *
     * @param num    the int
     * @param result the data transfer interface
     * @throws BizException if the num is null
     * @throws BizException if the num is less or equal than 0
     */
    public static void isPositive(Integer num, IResult result) {
        nonNull(num, result);

        if (num <= 0) {
            throw new BizException(result);
        }
    }

    /**
     * 正数？not null and greater than 0
     * %s can't be null
     * %s must be greater than 0
     *
     * @param num    the long
     * @param result the data transfer interface
     * @throws BizException if the num is null
     * @throws BizException if the num is less or equal than 0
     */
    public static void isPositive(Long num, IResult result) {
        nonNull(num, result);

        if (num <= 0L) {
            throw new BizException(result);
        }
    }

    /**
     * 正数？not null and greater than 0
     * %s can't be null
     * %s must be greater than 0
     *
     * @param num    the decimal
     * @param result the data transfer interface
     * @throws BizException if the num is null
     * @throws BizException if the num is less or equal than 0
     */
    public static void isPositive(BigDecimal num, IResult result) {
        nonNull(num, result);

        if (num.compareTo(BigDecimal.ZERO) <= 0) {
            throw new BizException(result);
        }
    }

    /**
     * 非负数？not null and (greater or equal than 0)
     * %s can't be null
     * %s can't be less than 0
     *
     * @param num    the int
     * @param result the data transfer interface
     * @throws BizException if the num is null
     * @throws BizException if the num is less than 0
     */
    public static void nonNegative(Integer num, IResult result) {
        nonNull(num, result);

        if (num < 0) {
            throw new BizException(result);
        }
    }

    /**
     * 非负数？not null and (greater or equal than 0)
     * %s can't be null
     * %s can't be less than 0
     *
     * @param num    the long
     * @param result the data transfer interface
     * @throws BizException if the num is null
     * @throws BizException if the num is less than 0
     */
    public static void nonNegative(Long num, IResult result) {
        nonNull(num, result);

        if (num < 0L) {
            throw new BizException(result);
        }
    }

    /**
     * 非负数？not null and (greater or equal than 0)
     * %s can't be null
     * %s can't be less than 0
     *
     * @param num    the decimal
     * @param result the data transfer interface
     * @throws BizException if the num is null
     * @throws BizException if the num is less than 0
     */
    public static void nonNegative(BigDecimal num, IResult result) {
        nonNull(num, result);

        if (num.compareTo(BigDecimal.ZERO) < 0) {
            throw new BizException(result);
        }
    }

}
