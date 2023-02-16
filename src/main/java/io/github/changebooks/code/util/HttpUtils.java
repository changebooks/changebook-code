package io.github.changebooks.code.util;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Http请求
 *
 * <pre>
 * CloseableHttpClient httpClient = HttpClientBuilder.create().build();
 * HttpGet httpGet = new HttpGet("http://***.com");
 *
 * HttpResult result = Http.execute(httpClient, httpGet);
 * System.out.println(result);
 * </pre>
 *
 * @author changebooks@qq.com
 */
public final class HttpUtils {
    /**
     * 默认的字符编码
     */
    private static final Charset DEFAULT_CHARSET = Consts.UTF_8;

    private HttpUtils() {
    }

    /**
     * Send Http Request
     *
     * @param httpClient  HttpClientBuilder.create().build();
     * @param httpRequest HttpGet, HttpPost, HttpPut, HttpDelete
     * @return HttpResult
     * @throws IOException if an error occurs reading the input stream
     */
    public static HttpResult execute(final CloseableHttpClient httpClient, HttpRequestBase httpRequest) throws IOException {
        return execute(httpClient, httpRequest, DEFAULT_CHARSET);
    }

    /**
     * Send Http Request
     *
     * @param httpClient  HttpClientBuilder.create().build();
     * @param httpRequest HttpGet, HttpPost, HttpPut, HttpDelete
     * @param charset     Charset，Default: {@link #DEFAULT_CHARSET}
     * @return HttpResult
     * @throws IOException if an error occurs reading the input stream
     */
    public static HttpResult execute(final CloseableHttpClient httpClient, HttpRequestBase httpRequest, final Charset charset) throws IOException {
        AssertUtils.nonNull(httpClient, "httpClient");
        AssertUtils.nonNull(httpRequest, "httpRequest");

        CloseableHttpResponse httpResponse = httpClient.execute(httpRequest);
        AssertUtils.nonNull(httpResponse, "httpResponse");

        try {
            return readResponse(httpResponse, charset);
        } finally {
            httpResponse.close();
        }
    }

    /**
     * Read Response
     *
     * @param httpResponse CloseableHttpClient.execute(HttpRequestBase)
     * @param charset      Charset，Default: {@link #DEFAULT_CHARSET}
     * @return HttpResult
     * @throws IOException if an error occurs reading the input stream
     */
    public static HttpResult readResponse(final CloseableHttpResponse httpResponse, final Charset charset) throws IOException {
        AssertUtils.nonNull(httpResponse, "httpResponse");

        StatusLine statusLine = httpResponse.getStatusLine();
        AssertUtils.nonNull(statusLine, "statusLine");

        HttpResult result = new HttpResult();
        result.setStatusCode(statusLine.getStatusCode());
        result.setHeaders(httpResponse.getAllHeaders());

        HttpEntity httpEntity = httpResponse.getEntity();
        if (httpEntity == null) {
            return result;
        }

        try {
            String data = EntityUtils.toString(httpEntity, (charset != null) ? charset : DEFAULT_CHARSET);
            result.setData(data);
            return result;
        } finally {
            EntityUtils.consume(httpEntity);
        }
    }

}
