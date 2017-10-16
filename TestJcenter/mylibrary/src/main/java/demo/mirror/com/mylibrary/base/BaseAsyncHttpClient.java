package demo.mirror.com.mylibrary.base;

import android.content.Context;
import android.text.TextUtils;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.ResponseHandlerInterface;

import junit.framework.Assert;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import demo.mirror.com.mylibrary.HttpSessionConfiguration;


/**
 * Http网络请求基类
 */
public final class BaseAsyncHttpClient {

    private static Context context;

    private static final String FIELD_ACCEPT = "Accept";
    private static final String FIELD_VERSION = "Version";
    private static final String VALUE_ACCEPT = "application/json";
    private static final String VALUE_VERSION = "v1.0.5";

    private static AsyncHttpClient asyncHttpClient = new AsyncHttpClient(true, 80, 443);
    private static PersistentCookieStore cookieStore = null;
    private static HttpSessionConfiguration configuration = null;

    //////////////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    //////////////////////////////////////////////////////////////////////////////////////

    private BaseAsyncHttpClient() {
    }

    //////////////////////////////////////////////////////////////////////////////////////
    // PUBLIC METHODS
    //////////////////////////////////////////////////////////////////////////////////////

    public static synchronized void initialize(HttpSessionConfiguration configuration) {
        Assert.assertNotNull(configuration);

        BaseAsyncHttpClient.configuration = configuration;
        context = configuration.getContext();
        asyncHttpClient.addHeader(FIELD_ACCEPT, VALUE_ACCEPT);
        asyncHttpClient.addHeader(FIELD_VERSION, VALUE_VERSION);

        // Set User Agent
        if (!TextUtils.isEmpty(configuration.getUserAgent())) {
            asyncHttpClient.setUserAgent(configuration.getUserAgent());
        }

        // Set Time Out
        asyncHttpClient.setTimeout(configuration.getTimeOut());

        // Set Logging Enable
        asyncHttpClient.setLoggingEnabled(configuration.getLoggingEnabled());

        // Set Log Level
        asyncHttpClient.setLoggingLevel(configuration.getLogLevel());

        // Set Cookie
        cookieStore = new PersistentCookieStore(context);
        asyncHttpClient.setCookieStore(cookieStore);
    }

    /**
     * @return AsyncHttpClient
     */
    public static synchronized AsyncHttpClient getHttpClient() {
        return asyncHttpClient;
    }

    /**
     * @return Context
     */
    public static Context getContext() {
        return context;
    }

    /**
     * @return HttpSessionConfiguration
     */
    public static HttpSessionConfiguration getConfiguration() {
        return configuration;
    }

    //////////////////////////////////////////////////////////////////////////////////////
    // HTTP FUNCTION
    //////////////////////////////////////////////////////////////////////////////////////
    // [+] HTTP HEAD

    /**
     * Perform a HTTP HEAD request, without any parameters.
     *
     * @param url             the URL to send the request to.
     * @param responseHandler the response handler instance that should handle the response.
     * @return RequestHandle of future request process
     */
    public static RequestHandle head(String url, ResponseHandlerInterface responseHandler) {
        return asyncHttpClient.head(url, responseHandler);
    }

    /**
     * Perform a HTTP HEAD request with parameters.
     *
     * @param url             the URL to send the request to.
     * @param params          additional HEAD parameters to send with the request.
     * @param responseHandler the response handler instance that should handle the response.
     * @return RequestHandle of future request process
     */
    public static RequestHandle head(String url, RequestParams params, ResponseHandlerInterface responseHandler) {
        return asyncHttpClient.head(url, params, responseHandler);
    }

    /**
     * Perform a HTTP HEAD request without any parameters and track the Android Context which
     * initiated the request.
     *
     * @param context         the Android Context which initiated the request.
     * @param url             the URL to send the request to.
     * @param responseHandler the response handler instance that should handle the response.
     * @return RequestHandle of future request process
     */
    public static RequestHandle head(Context context, String url, ResponseHandlerInterface responseHandler) {
        return asyncHttpClient.head(context, url, responseHandler);
    }

    /**
     * Perform a HTTP HEAD request and track the Android Context which initiated the request.
     *
     * @param context         the Android Context which initiated the request.
     * @param url             the URL to send the request to.
     * @param params          additional HEAD parameters to send with the request.
     * @param responseHandler the response handler instance that should handle the response.
     * @return RequestHandle of future request process
     */
    public static RequestHandle head(Context context, String url, RequestParams params, ResponseHandlerInterface responseHandler) {
        return asyncHttpClient.head(context, url, params, responseHandler);
    }

    /**
     * Perform a HTTP HEAD request and track the Android Context which initiated the request with
     * customized headers
     *
     * @param context         Context to execute request against
     * @param url             the URL to send the request to.
     * @param headers         set headers only for this request
     * @param params          additional HEAD parameters to send with the request.
     * @param responseHandler the response handler instance that should handle the response.
     * @return RequestHandle of future request process
     */
    public static RequestHandle head(Context context, String url, Header[] headers, RequestParams params, ResponseHandlerInterface responseHandler) {
        return asyncHttpClient.head(context, url, headers, params, responseHandler);
    }

    // [-] HTTP HEAD
    // [+] HTTP GET

    /**
     * Perform a HTTP GET request, without any parameters.
     *
     * @param url             the URL to send the request to.
     * @param responseHandler the response handler instance that should handle the response.
     * @return RequestHandle of future request process
     */
    public static RequestHandle get(String url, ResponseHandlerInterface responseHandler) {
        return asyncHttpClient.get(url, responseHandler);
    }

    /**
     * Perform a HTTP GET request with parameters.
     *
     * @param url             the URL to send the request to.
     * @param params          additional GET parameters to send with the request.
     * @param responseHandler the response handler instance that should handle the response.
     * @return RequestHandle of future request process
     */
    public static RequestHandle get(String url, RequestParams params, ResponseHandlerInterface responseHandler) {
        return asyncHttpClient.get(url, params, responseHandler);
    }

    /**
     * Perform a HTTP GET request without any parameters and track the Android Context which
     * initiated the request.
     *
     * @param context         the Android Context which initiated the request.
     * @param url             the URL to send the request to.
     * @param responseHandler the response handler instance that should handle the response.
     * @return RequestHandle of future request process
     */
    public static RequestHandle get(Context context, String url, ResponseHandlerInterface responseHandler) {
        return asyncHttpClient.get(context, url, responseHandler);
    }

    /**
     * Perform a HTTP GET request and track the Android Context which initiated the request.
     *
     * @param context         the Android Context which initiated the request.
     * @param url             the URL to send the request to.
     * @param params          additional GET parameters to send with the request.
     * @param responseHandler the response handler instance that should handle the response.
     * @return RequestHandle of future request process
     */
    public static RequestHandle get(Context context, String url, RequestParams params, ResponseHandlerInterface responseHandler) {
        return asyncHttpClient.get(context, url, params, responseHandler);
    }

    /**
     * Perform a HTTP GET request and track the Android Context which initiated the request with
     * customized headers
     *
     * @param context         Context to execute request against
     * @param url             the URL to send the request to.
     * @param headers         set headers only for this request
     * @param params          additional GET parameters to send with the request.
     * @param responseHandler the response handler instance that should handle the response.
     * @return RequestHandle of future request process
     */
    public static RequestHandle get(Context context, String url, Header[] headers, RequestParams params, ResponseHandlerInterface responseHandler) {
        return asyncHttpClient.get(context, url, headers, params, responseHandler);
    }

    /**
     * Perform a HTTP GET request and track the Android Context which initiated the request.
     *
     * @param context         the Android Context which initiated the request.
     * @param url             the URL to send the request to.
     * @param entity          a raw {@link HttpEntity} to send with the request, for
     *                        example, use this to send string/json/xml payloads to a server by
     *                        passing a {@link cz.msebera.android.httpclient.entity.StringEntity}.
     * @param contentType     the content type of the payload you are sending, for example
     *                        application/json if sending a json payload.
     * @param responseHandler the response ha   ndler instance that should handle the response.
     * @return RequestHandle of future request process
     */
    public static RequestHandle get(Context context, String url, HttpEntity entity, String contentType, ResponseHandlerInterface responseHandler) {
        return asyncHttpClient.get(context, url, entity, contentType, responseHandler);
    }

    // [-] HTTP GET
    // [+] HTTP POST

    /**
     * Perform a HTTP POST request, without any parameters.
     *
     * @param url             the URL to send the request to.
     * @param responseHandler the response handler instance that should handle the response.
     * @return RequestHandle of future request process
     */
    public static RequestHandle post(String url, ResponseHandlerInterface responseHandler) {
        return asyncHttpClient.post(url, responseHandler);
    }

    /**
     * Perform a HTTP POST request with parameters.
     *
     * @param url             the URL to send the request to.
     * @param params          additional POST parameters or files to send with the request.
     * @param responseHandler the response handler instance that should handle the response.
     * @return RequestHandle of future request process
     */
    public static RequestHandle post(String url, RequestParams params, ResponseHandlerInterface responseHandler) {
        return asyncHttpClient.post(url, params, responseHandler);
    }

    /**
     * Perform a HTTP POST request and track the Android Context which initiated the request.
     *
     * @param context         the Android Context which initiated the request.
     * @param url             the URL to send the request to.
     * @param params          additional POST parameters or files to send with the request.
     * @param responseHandler the response handler instance that should handle the response.
     * @return RequestHandle of future request process
     */
    public static RequestHandle post(Context context, String url, RequestParams params, ResponseHandlerInterface responseHandler) {
        return asyncHttpClient.post(context, url, params, responseHandler);
    }

    /**
     * Perform a HTTP POST request and track the Android Context which initiated the request.
     *
     * @param context         the Android Context which initiated the request.
     * @param url             the URL to send the request to.
     * @param entity          a raw {@link HttpEntity} to send with the request, for
     *                        example, use this to send string/json/xml payloads to a server by
     *                        passing a {@link cz.msebera.android.httpclient.entity.StringEntity}.
     * @param contentType     the content type of the payload you are sending, for example
     *                        application/json if sending a json payload.
     * @param responseHandler the response ha   ndler instance that should handle the response.
     * @return RequestHandle of future request process
     */
    public static RequestHandle post(Context context, String url, HttpEntity entity, String contentType, ResponseHandlerInterface responseHandler) {
        return asyncHttpClient.post(context, url, entity, contentType, responseHandler);
    }

    /**
     * Perform a HTTP POST request and track the Android Context which initiated the request. Set
     * headers only for this request
     *
     * @param context         the Android Context which initiated the request.
     * @param url             the URL to send the request to.
     * @param headers         set headers only for this request
     * @param params          additional POST parameters to send with the request.
     * @param contentType     the content type of the payload you are sending, for example
     *                        application/json if sending a json payload.
     * @param responseHandler the response handler instance that should handle the response.
     * @return RequestHandle of future request process
     */
    public static RequestHandle post(Context context, String url, Header[] headers, RequestParams params, String contentType,
                                     ResponseHandlerInterface responseHandler) {
        return asyncHttpClient.post(context, url, headers, params, contentType, responseHandler);
    }

    /**
     * Perform a HTTP POST request and track the Android Context which initiated the request. Set
     * headers only for this request
     *
     * @param context         the Android Context which initiated the request.
     * @param url             the URL to send the request to.
     * @param headers         set headers only for this request
     * @param entity          a raw {@link HttpEntity} to send with the request, for example, use
     *                        this to send string/json/xml payloads to a server by passing a {@link
     *                        cz.msebera.android.httpclient.entity.StringEntity}.
     * @param contentType     the content type of the payload you are sending, for example
     *                        application/json if sending a json payload.
     * @param responseHandler the response handler instance that should handle the response.
     * @return RequestHandle of future request process
     */
    public static RequestHandle post(Context context, String url, Header[] headers, HttpEntity entity, String contentType,
                                     ResponseHandlerInterface responseHandler) {
        return asyncHttpClient.post(context, url, headers, entity, contentType, responseHandler);
    }

    // [-] HTTP POST
    // [+] HTTP PUT

    /**
     * Perform a HTTP PUT request, without any parameters.
     *
     * @param url             the URL to send the request to.
     * @param responseHandler the response handler instance that should handle the response.
     * @return RequestHandle of future request process
     */
    public static RequestHandle put(String url, ResponseHandlerInterface responseHandler) {
        return asyncHttpClient.put(url, responseHandler);
    }

    /**
     * Perform a HTTP PUT request with parameters.
     *
     * @param url             the URL to send the request to.
     * @param params          additional PUT parameters or files to send with the request.
     * @param responseHandler the response handler instance that should handle the response.
     * @return RequestHandle of future request process
     */
    public static RequestHandle put(String url, RequestParams params, ResponseHandlerInterface responseHandler) {
        return asyncHttpClient.put(url, params, responseHandler);
    }

    /**
     * Perform a HTTP PUT request and track the Android Context which initiated the request.
     *
     * @param context         the Android Context which initiated the request.
     * @param url             the URL to send the request to.
     * @param params          additional PUT parameters or files to send with the request.
     * @param responseHandler the response handler instance that should handle the response.
     * @return RequestHandle of future request process
     */
    public static RequestHandle put(Context context, String url, RequestParams params, ResponseHandlerInterface responseHandler) {
        return asyncHttpClient.put(context, url, params, responseHandler);
    }

    /**
     * Perform a HTTP PUT request and track the Android Context which initiated the request. And set
     * one-time headers for the request
     *
     * @param context         the Android Context which initiated the request.
     * @param url             the URL to send the request to.
     * @param entity          a raw {@link HttpEntity} to send with the request, for example, use
     *                        this to send string/json/xml payloads to a server by passing a {@link
     *                        cz.msebera.android.httpclient.entity.StringEntity}.
     * @param contentType     the content type of the payload you are sending, for example
     *                        application/json if sending a json payload.
     * @param responseHandler the response handler instance that should handle the response.
     * @return RequestHandle of future request process
     */
    public static RequestHandle put(Context context, String url, HttpEntity entity, String contentType, ResponseHandlerInterface responseHandler) {
        return asyncHttpClient.put(context, url, entity, contentType, responseHandler);
    }

    /**
     * Perform a HTTP PUT request and track the Android Context which initiated the request. And set
     * one-time headers for the request
     *
     * @param context         the Android Context which initiated the request.
     * @param url             the URL to send the request to.
     * @param headers         set one-time headers for this request
     * @param entity          a raw {@link HttpEntity} to send with the request, for example, use
     *                        this to send string/json/xml payloads to a server by passing a {@link
     *                        cz.msebera.android.httpclient.entity.StringEntity}.
     * @param contentType     the content type of the payload you are sending, for example
     *                        application/json if sending a json payload.
     * @param responseHandler the response handler instance that should handle the response.
     * @return RequestHandle of future request process
     */
    public static RequestHandle put(Context context, String url, Header[] headers, HttpEntity entity, String contentType, ResponseHandlerInterface responseHandler) {
        return asyncHttpClient.put(context, url, headers, entity, contentType, responseHandler);
    }

    /**
     * Perform a HTTP
     * request, without any parameters.
     *
     * @param url             the URL to send the request to.
     * @param responseHandler the response handler instance that should handle the response.
     * @return RequestHandle of future request process
     */
    public static RequestHandle patch(String url, ResponseHandlerInterface responseHandler) {
        return asyncHttpClient.patch(url, responseHandler);
    }

    /**
     * Perform a HTTP PATCH request with parameters.
     *
     * @param url             the URL to send the request to.
     * @param params          additional PUT parameters or files to send with the request.
     * @param responseHandler the response handler instance that should handle the response.
     * @return RequestHandle of future request process
     */
    public static RequestHandle patch(String url, RequestParams params, ResponseHandlerInterface responseHandler) {
        return asyncHttpClient.patch(url, params, responseHandler);
    }

    /**
     * Perform a HTTP PATCH request and track the Android Context which initiated the request.
     *
     * @param context         the Android Context which initiated the request.
     * @param url             the URL to send the request to.
     * @param params          additional PUT parameters or files to send with the request.
     * @param responseHandler the response handler instance that should handle the response.
     * @return RequestHandle of future request process
     */
    public static RequestHandle patch(Context context, String url, RequestParams params, ResponseHandlerInterface responseHandler) {
        return asyncHttpClient.patch(context, url, params, responseHandler);
    }

    /**
     * Perform a HTTP PATCH request and track the Android Context which initiated the request.
     *
     * @param context         the Android Context which initiated the request.
     * @param url             the URL to send the request to.
     * @param responseHandler the response handler instance that should handle the response.
     * @param entity          a raw {@link HttpEntity} to send with the request, for example, use
     *                        this to send string/json/xml payloads to a server by passing a {@link
     *                        cz.msebera.android.httpclient.entity.StringEntity}
     * @param contentType     the content type of the payload you are sending, for example
     *                        "application/json" if sending a json payload.
     * @return RequestHandle of future request process
     */
    public static RequestHandle patch(Context context, String url, HttpEntity entity, String contentType, ResponseHandlerInterface responseHandler) {
        return asyncHttpClient.patch(context, url, entity, contentType, responseHandler);
    }

    /**
     * Perform a HTTP PATCH request and track the Android Context which initiated the request. And set
     * one-time headers for the request
     *
     * @param context         the Android Context which initiated the request.
     * @param url             the URL to send the request to.
     * @param headers         set one-time headers for this request
     * @param entity          a raw {@link HttpEntity} to send with the request, for example, use
     *                        this to send string/json/xml payloads to a server by passing a {@link
     *                        cz.msebera.android.httpclient.entity.StringEntity}.
     * @param contentType     the content type of the payload you are sending, for example
     *                        application/json if sending a json payload.
     * @param responseHandler the response handler instance that should handle the response.
     * @return RequestHandle of future request process
     */
    public static RequestHandle patch(Context context, String url, Header[] headers, HttpEntity entity, String contentType, ResponseHandlerInterface responseHandler) {
        return asyncHttpClient.patch(context, url, headers, entity, contentType, responseHandler);
    }

    // [-] HTTP PUT
    // [+] HTTP DELETE

    /**
     * Perform a HTTP DELETE request.
     *
     * @param url             the URL to send the request to.
     * @param responseHandler the response handler instance that should handle the response.
     * @return RequestHandle of future request process
     */
    public static RequestHandle delete(String url, ResponseHandlerInterface responseHandler) {
        return asyncHttpClient.delete(url, responseHandler);
    }

    /**
     * Perform a HTTP DELETE request.
     *
     * @param context         the Android Context which initiated the request.
     * @param url             the URL to send the request to.
     * @param responseHandler the response handler instance that should handle the response.
     * @return RequestHandle of future request process
     */
    public static RequestHandle delete(Context context, String url, ResponseHandlerInterface responseHandler) {
        return asyncHttpClient.delete(context, url, responseHandler);
    }

    /**
     * Perform a HTTP DELETE request.
     *
     * @param context         the Android Context which initiated the request.
     * @param url             the URL to send the request to.
     * @param headers         set one-time headers for this request
     * @param responseHandler the response handler instance that should handle the response.
     * @return RequestHandle of future request process
     */
    public static RequestHandle delete(Context context, String url, Header[] headers, ResponseHandlerInterface responseHandler) {
        return asyncHttpClient.delete(context, url, headers, responseHandler);
    }

    /**
     * Perform a HTTP DELETE request.
     *
     * @param url             the URL to send the request to.
     * @param params          additional DELETE parameters or files to send with the request.
     * @param responseHandler the response handler instance that should handle the response.
     */
    public static void delete(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        asyncHttpClient.delete(url, params, responseHandler);
    }

    /**
     * Perform a HTTP DELETE request.
     *
     * @param context         the Android Context which initiated the request.
     * @param url             the URL to send the request to.
     * @param headers         set one-time headers for this request
     * @param params          additional DELETE parameters or files to send along with request
     * @param responseHandler the response handler instance that should handle the response.
     * @return RequestHandle of future request process
     */
    public static RequestHandle delete(Context context, String url, Header[] headers, RequestParams params, ResponseHandlerInterface responseHandler) {
        return asyncHttpClient.delete(context, url, headers, params, responseHandler);
    }

    /**
     * Perform a HTTP DELETE request and track the Android Context which initiated the request.
     *
     * @param context         the Android Context which initiated the request.
     * @param url             the URL to send the request to.
     * @param entity          a raw {@link HttpEntity} to send with the request, for
     *                        example, use this to send string/json/xml payloads to a server by
     *                        passing a {@link cz.msebera.android.httpclient.entity.StringEntity}.
     * @param contentType     the content type of the payload you are sending, for example
     *                        application/json if sending a json payload.
     * @param responseHandler the response ha   ndler instance that should handle the response.
     * @return RequestHandle of future request process
     */
    public static RequestHandle delete(Context context, String url, HttpEntity entity, String contentType, ResponseHandlerInterface responseHandler) {
        return asyncHttpClient.delete(context, url, entity, contentType, responseHandler);
    }

    // [-] HTTP DELETE
}
