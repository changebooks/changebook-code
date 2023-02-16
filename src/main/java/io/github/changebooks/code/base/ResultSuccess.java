package io.github.changebooks.code.base;

import java.io.Serializable;

/**
 * View Object
 *
 * @author changebooks@qq.com
 */
public final class ResultSuccess<T> implements Serializable {
    /**
     * 内容（eq null）
     */
    public static final class WithoutData implements Serializable {
        /**
         * 状态
         */
        private final boolean success = true;

        @Override
        public String toString() {
            return JsonParser.toJson(this);
        }

        public boolean isSuccess() {
            return true;
        }

    }

    /**
     * 状态
     */
    private final boolean success = true;

    /**
     * 内容
     */
    private final T data;

    public ResultSuccess(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JsonParser.toJson(this);
    }

    public boolean isSuccess() {
        return true;
    }

    public T getData() {
        return data;
    }

}
