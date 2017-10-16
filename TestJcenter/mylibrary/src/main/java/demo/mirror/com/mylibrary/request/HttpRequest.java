package demo.mirror.com.mylibrary.request;

import android.content.Context;

import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import demo.mirror.com.mylibrary.base.BaseHttpClient;

/**
 * request请求实体
 */
public class HttpRequest {

    /**
     * 类型
     */
    private RequestType type;
    /**
     * Context
     */
    private Context context;
    /**
     * BaseHttpClient
     */
    private BaseHttpClient baseHttpClient;
    /**
     * root URL
     */
    private String url;
    /**
     * 请求参数
     */
    private RequestParams params;
    /**
     * 请求的JSON数据
     */
    private String httpJson;
    /**
     * 请求实体
     */
    private HttpEntity httpEntity;
    /**
     * 请求头信息
     */
    private Header[] headers;
    /**
     * 是否重试
     */
    private boolean retry = false;

    public HttpRequest(BaseHttpClient baseHttpClient) {
        this.baseHttpClient = baseHttpClient;
    }

    public RequestType getType() {
        return type;
    }

    public HttpRequest setType(RequestType type) {
        this.type = type;
        return this;
    }

    public Context getContext() {
        return context;
    }

    public HttpRequest setContext(Context context) {
        this.context = context;
        return this;
    }

    public BaseHttpClient getHttpClient() {
        return baseHttpClient;
    }

    public HttpRequest setHttpClient(BaseHttpClient baseHttpClient) {
        this.baseHttpClient = baseHttpClient;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public HttpRequest setUrl(String url) {
        this.url = url;
        return this;
    }

    public RequestParams getParams() {
        return params;
    }

    public HttpRequest setParams(RequestParams params) {
        this.params = params;
        return this;
    }

    public String getHttpJson() {
        return httpJson;
    }

    public HttpRequest setHttpJson(String httpJson) {
        this.httpJson = httpJson;
        return this;
    }

    public HttpEntity getHttpEntity() {
        return httpEntity;
    }

    public HttpRequest setHttpEntity(HttpEntity httpEntity) {
        this.httpEntity = httpEntity;
        return this;
    }

    public Header[] getHeaders() {
        return headers;
    }

    public HttpRequest setHeaders(Header[] headers) {
        this.headers = headers;
        return this;
    }

    public boolean isRetry() {
        return retry;
    }

    public HttpRequest setRetry(boolean retry) {
        this.retry = retry;
        return this;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder("HttpRequest:[\n");
        builder.append("type:").append(type.name()).append("\n");
        builder.append("url:").append(url).append("\n");
        if (params != null) {
            builder.append("params:").append(params.toString()).append("\n");
        }
        if (httpJson != null && httpJson.length() != 0) {
            builder.append("httpJson:").append(httpJson).append("\n");
        }
        if (retry) {
            builder.append("再次请求状态Retry:").append(retry).append("\n");
        }
        builder.append("]");
        return builder.toString().trim();
    }
}
