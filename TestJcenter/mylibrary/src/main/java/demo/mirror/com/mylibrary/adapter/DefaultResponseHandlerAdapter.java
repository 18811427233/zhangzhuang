package demo.mirror.com.mylibrary.adapter;

import com.loopj.android.http.AsyncHttpResponseHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cz.msebera.android.httpclient.Header;
import demo.mirror.com.mylibrary.logger.HttpLogger;
import demo.mirror.com.mylibrary.request.HttpRequest;

/**
 * DefaultResponseHandlerAdapter.java
 * <p/>
 * <pre>
 *     处理HttpClient接收到的网络响应数据
 * </pre>
 */
public class DefaultResponseHandlerAdapter extends AsyncHttpResponseHandler {

    public static final int ERROR_CODE_OK = 0;

    /**
     * Logger for this class
     */
    private static final Logger logger = LoggerFactory.getLogger(DefaultResponseHandlerAdapter.class);
    private HttpCallBack httpCallBack;
    private HttpRequest httpRequest;

    public DefaultResponseHandlerAdapter(HttpRequest httpRequest, HttpCallBack httpCallBack) {
        this.httpRequest = httpRequest;
        this.httpCallBack = httpCallBack;
    }

    public void onStart() {
        HttpLogger.loggerOnStart(logger, httpRequest);
        httpCallBack.onStart();
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
        HttpLogger.loggerOnSuccess(logger, httpRequest, statusCode, headers, responseBody);
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
        HttpLogger.loggerOnFailure(logger, httpRequest, statusCode, headers, responseBody, error);
    }

    @Override
    public void onRetry(int retryNo) {
        httpCallBack.onRetry(retryNo);
    }

    @Override
    public void onProgress(long bytesWritten, long totalSize) {
        httpCallBack.onProgress(bytesWritten * 100 / totalSize, totalSize);
    }

    @Override
    public void onFinish() {
        HttpLogger.loggerOnFinish(logger);
        httpCallBack.onFinish();
    }

    // get call back
    public HttpCallBack getHttpCallBack() {
        return httpCallBack;
    }

    // get http request
    public HttpRequest getHttpRequest() {
        return httpRequest;
    }
}