package io.github.changebooks.code.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.*;

/**
 * Http下载
 *
 * @author changebooks@qq.com
 */
public final class DownloadUtils {
    /**
     * 分配缓存空间，单位：字节
     */
    private static final int BUFFER_SIZE = 4096;

    /**
     * 下载进度，回调接口
     */
    public interface ProgressListener {
        /**
         * 监听下载进度
         *
         * @param complete     完成？
         * @param totalSize    总文件大小，单位：字节
         * @param downloadSize 已下载文件大小，单位：字节
         */
        void onListen(boolean complete, long totalSize, long downloadSize);

    }

    private DownloadUtils() {
    }

    /**
     * 执行下载
     *
     * @param url      待下载文件，远程地址，如：http://picture.example/abc.jpg
     * @param path     下载到本地，保存地址，如：/picture/abc.jpg
     * @param listener 下载进度，回调接口
     * @return 状态码、总文件大小、已下载文件大小
     * @throws IOException 读写失败
     */
    public static DownloadResult execute(String url, String path, ProgressListener listener) throws IOException {
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            return execute(httpClient, url, path, listener);
        }
    }

    /**
     * 执行下载
     *
     * @param httpClient HttpClientBuilder.create().build();
     * @param url        待下载文件，远程地址，如：http://picture.example/abc.jpg
     * @param path       下载到本地，保存地址，如：/picture/abc.jpg
     * @param listener   下载进度，回调接口
     * @return 状态码、总文件大小、已下载文件大小
     * @throws IOException 读写失败
     */
    public static DownloadResult execute(final CloseableHttpClient httpClient, String url, String path, ProgressListener listener) throws IOException {
        AssertUtils.nonNull(httpClient, "httpClient");
        AssertUtils.nonEmpty(url, "url");
        AssertUtils.nonEmpty(path, "path");

        HttpGet httpGet = new HttpGet(url);
        File file = new File(path);

        try (CloseableHttpResponse httpResponse = httpClient.execute(httpGet)) {
            return responseToFile(httpResponse, file, BUFFER_SIZE, listener);
        }
    }

    /**
     * 读取远程文件，写入本地文件
     *
     * @param httpResponse 待下载文件，远程文件
     * @param file         下载到本地，保存文件
     * @param bufferSize   分配缓存空间，单位：字节
     * @param listener     下载进度，回调接口
     * @return 状态码、总文件大小、已下载文件大小
     * @throws IOException 读写失败
     */
    public static DownloadResult responseToFile(final CloseableHttpResponse httpResponse, File file, int bufferSize, ProgressListener listener) throws IOException {
        AssertUtils.nonNull(httpResponse, "httpResponse");
        AssertUtils.nonNull(file, "file");
        AssertUtils.isPositive(bufferSize, "bufferSize");

        StatusLine statusLine = httpResponse.getStatusLine();
        AssertUtils.nonNull(statusLine, "statusLine");

        DownloadResult result = new DownloadResult();

        int statusCode = statusLine.getStatusCode();
        result.setStatusCode(statusCode);

        if (statusCode != HttpStatus.SC_OK) {
            return result;
        }

        HttpEntity httpEntity = httpResponse.getEntity();
        AssertUtils.nonNull(httpEntity, "httpEntity");

        try (InputStream in = httpEntity.getContent();
             OutputStream out = new FileOutputStream(file)) {
            long totalSize = httpEntity.getContentLength();
            long downloadSize = readAndWrite(in, out, bufferSize, totalSize, listener);

            result.setTotalSize(totalSize);
            result.setDownloadSize(downloadSize);
            return result;
        }
    }

    /**
     * 读取远程文件输入流，写入本地文件输出流
     *
     * @param in         待下载文件，远程文件输入流
     * @param out        下载到本地，保存文件输出流
     * @param bufferSize 分配缓存空间，单位：字节
     * @param totalSize  总文件大小，单位：字节
     * @param listener   下载进度，回调接口
     * @return 已下载文件大小，单位：字节
     * @throws IOException 读写失败
     */
    public static long readAndWrite(InputStream in, OutputStream out, int bufferSize, long totalSize, ProgressListener listener) throws IOException {
        AssertUtils.nonNull(in, "in");
        AssertUtils.nonNull(out, "out");
        AssertUtils.isPositive(bufferSize, "bufferSize");
        AssertUtils.isPositive(totalSize, "totalSize");

        try (BufferedInputStream bufferedIn = new BufferedInputStream(in);
             BufferedOutputStream bufferedOut = new BufferedOutputStream(out)) {
            long downloadSize = 0;

            byte[] bucket = new byte[bufferSize];
            int size;
            while ((size = bufferedIn.read(bucket)) != -1) {
                if (size > 0) {
                    bufferedOut.write(bucket, 0, size);
                    bufferedOut.flush();

                    downloadSize += size;
                    if (listener != null) {
                        listener.onListen(false, totalSize, downloadSize);
                    }
                }
            }

            if (listener != null) {
                listener.onListen(true, totalSize, downloadSize);
            }

            return downloadSize;
        }
    }

}
