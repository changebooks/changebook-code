package io.github.changebooks.code.util;

import io.github.changebooks.code.base.Check;

/**
 * Boolean类型转换
 *
 * <pre>
 * 1 to True
 * !1 to False
 * True to 1
 * False to 0
 * </pre>
 *
 * @author changebooks@qq.com
 */
public final class BooleanCast {
    /**
     * 1-True
     * 0-False
     */
    public static final int TRUE = 1;
    public static final int FALSE = 0;

    public static boolean fromInt(Integer value) {
        return Check.nonNull(value) && value == TRUE;
    }

    public static int toInt(Boolean value) {
        return Check.isTrue(value) ? TRUE : FALSE;
    }

}
