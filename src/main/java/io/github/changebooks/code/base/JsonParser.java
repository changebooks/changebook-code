package io.github.changebooks.code.base;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;

/**
 * 解析Json
 *
 * @author changebooks@qq.com
 */
public final class JsonParser {
    /**
     * 默认的时间格式
     */
    private static final String PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * Parser
     */
    private static final Gson PARSER = (new GsonBuilder()).
            disableHtmlEscaping().
            setDateFormat(PATTERN).
            create();

    private JsonParser() {
    }

    /**
     * Convert Object to Json String
     *
     * @param src the object
     * @return a json string
     */
    public static String toJson(Object src) {
        return PARSER.toJson(src);
    }

    /**
     * Convert Object to Json String
     *
     * @param src       the object
     * @param typeOfSrc new TypeToken&lt;Collection&lt;Foo&gt;&gt;(){}.getType();
     * @return a json string
     */
    public static String toJson(Object src, final Type typeOfSrc) {
        return PARSER.toJson(src, typeOfSrc);
    }

    /**
     * Convert Json String to Object
     *
     * @param json     the json string
     * @param classOfT the class of T
     * @param <T>      the type of the desired object
     * @return an object of type T from the string
     * @throws JsonSyntaxException if json is not a valid representation for an object of type classOfT
     */
    public static <T> T fromJson(String json, final Class<T> classOfT) throws JsonSyntaxException {
        return PARSER.fromJson(json, classOfT);
    }

    /**
     * Convert Json String to Object
     *
     * @param json    the json string
     * @param typeOfT new TypeToken&lt;Collection&lt;Foo&gt;&gt;(){}.getType();
     * @param <T>     the type of the desired object
     * @return an object of type T from the string
     * @throws JsonSyntaxException if json is not a valid representation for an object of type classOfT
     */
    public static <T> T fromJson(String json, final Type typeOfT) throws JsonSyntaxException {
        return PARSER.fromJson(json, typeOfT);
    }

}
