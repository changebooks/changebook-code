package io.github.changebooks.code.http;

import io.github.changebooks.code.base.JsonParser;
import io.github.changebooks.code.util.AssertUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Entity常用工具
 *
 * @author changebooks@qq.com
 */
public final class EntityUtils {

    private EntityUtils() {
    }

    /**
     * Object to Json Entity
     *
     * @param params the object
     * @return json entity
     */
    public static HttpEntity toJson(Object params) {
        AssertUtils.nonNull(params, "params");

        String jsonStr = JsonParser.toJson(params);
        return new StringEntity(jsonStr, ContentType.APPLICATION_JSON);
    }

    /**
     * Map to Url Encoded Form Entity
     *
     * @param params the map
     * @return url encoded
     */
    public static HttpEntity toForm(final Map<String, Object> params) {
        return toForm(params, Constant.CHARSET);
    }

    /**
     * Map to Url Encoded Form Entity
     *
     * @param params  the map
     * @param charset the charset
     * @return url encoded
     */
    public static HttpEntity toForm(final Map<String, Object> params, final Charset charset) {
        AssertUtils.nonNull(params, "params");

        List<NameValuePair> pairs = getPairs(params);
        return new UrlEncodedFormEntity(pairs, charset);
    }

    /**
     * Map to List&lt;NameValuePair&gt;
     *
     * @param params the map
     * @return [name : value]
     */
    public static List<NameValuePair> getPairs(final Map<String, Object> params) {
        AssertUtils.nonNull(params, "params");

        List<NameValuePair> result = new ArrayList<>();

        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (entry != null) {
                String key = entry.getKey();
                Object obj = entry.getValue();
                String value = (obj == null) ? "" : obj.toString();
                BasicNameValuePair pair = new BasicNameValuePair(key, value);
                result.add(pair);
            }
        }

        return result;
    }

}
