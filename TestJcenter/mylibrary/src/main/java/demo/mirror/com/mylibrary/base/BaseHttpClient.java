package demo.mirror.com.mylibrary.base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.ResponseHandlerInterface;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.protocol.HTTP;
import demo.mirror.com.mylibrary.adapter.HttpCallBack;
import demo.mirror.com.mylibrary.request.HttpRequest;
import demo.mirror.com.mylibrary.request.RequestType;


/**
 * BaseHttpClient
 * <p/>
 * <ul>
 * <li>Http client use AsyncHttpClient {@link AsyncHttpClient}</li>
 * </ul>
 * <ul>
 * <strong>Public Method</strong>
 * <li>get AsyncHttpClient {@link #getHttpClient() }</li>
 * <li>get Context {@link #getContext() }</li>
 * <li>get contentTypeJson {@link #getContentTypeJson()}</li>
 * </ul>
 * <ul>
 * <strong>Http GET Method</strong>
 * <li>HTTP GET {@link #sendGet(String, HttpCallBack)}, {@link #sendGet(String, RequestParams, HttpCallBack)}</li>
 * <li>HTTP POST {@link #sendPost(String, HttpCallBack)}, {@link #sendPost(String, RequestParams, HttpCallBack)}, {@link #sendPost(String, String, HttpCallBack)}</li>
 * <li>HTTP PUT {@link #sendPut(String, HttpCallBack)}, {@link #sendPut(String, String, HttpCallBack)}</li>
 * <li>HTTP DELETE {@link #sendDelete(String, HttpCallBack)}, {@link #sendDelete(String, String, HttpCallBack)}</li>
 * </ul>
 *
 * @see com.mirror.httpsession.HttpSession
 * @see HttpSessionConfiguration
 * @see BaseAsyncHttpClient
 * @see HttpRequest
 */
public abstract class BaseHttpClient {

    private static final String CONTENT_TYPE_JSON = "application/json";
    private HttpRequest httpRequest;

    /**
     * 获取httpClient对象
     *
     * @return AsyncHttpClient 对象
     */
    public static AsyncHttpClient getHttpClient() {
        return BaseAsyncHttpClient.getHttpClient();
    }

    /**
     * 获取Context对象
     *
     * @return Context 对象
     */
    public static Context getContext() {
        return BaseAsyncHttpClient.getContext();
    }

    /**
     * 获取JSON的类型
     *
     * @return application/json
     */
    public static String getContentTypeJson() {
        return CONTENT_TYPE_JSON;
    }


    /** ==================== Get请求 ====================**/

    /**
     * 发送Get请求
     *
     * @param pathCarouselList
     * @param url          网络请求地址
     * @param httpCallBack 请求回调函数
     */
    public void sendGet(String pathCarouselList, String url, HttpCallBack httpCallBack) {
        sendGet(url, httpCallBack, false);
    }

    /**
     * 发送Get请求
     *
     * @param url          网络请求地址
     * @param httpCallBack 请求回调函数
     * @param retry        是否重试 默认应为false,重新登录之后为true
     */
    public void sendGet(String url, HttpCallBack httpCallBack, boolean retry) {
        if (hasNetwork()) {
            httpRequest = new HttpRequest(this);
            httpRequest.setContext(getContext())
                    .setType(RequestType.GET)
                    .setRetry(retry)
                    .setUrl(url);
            BaseAsyncHttpClient.get(url, getResponseHandler(httpRequest, httpCallBack));
        } else {
            httpCallBack.onNetError();
            httpCallBack.onFinish();
        }
    }

    /** ==================== RequestParams 的Get请求 ====================**/

    /**
     * 发送Get请求
     *
     * @param url          网络请求地址
     * @param params       请求参数
     * @param httpCallBack 请求回调函数
     */
    public void sendGet(String url, RequestParams params, HttpCallBack httpCallBack) {
        sendGet(url, params, httpCallBack, false);
    }

    /**
     * 发送Get请求
     *
     * @param url          网络请求地址
     * @param params       请求参数
     * @param httpCallBack 请求回调函数
     * @param retry        是否重试 默认应为false,重新登录之后为true
     */
    public void sendGet(String url, RequestParams params, HttpCallBack httpCallBack, boolean retry) {

        if (hasNetwork()) {
            httpRequest = new HttpRequest(this);
            httpRequest.setContext(getContext())
                    .setType(RequestType.GET_PARAMS)
                    .setRetry(retry)
                    .setUrl(url)
                    .setParams(params);
            BaseAsyncHttpClient.get(url, params, getResponseHandler(httpRequest, httpCallBack));
        } else {
            httpCallBack.onNetError();
            httpCallBack.onFinish();
        }
    }

    /** ==================== JSON 的Post请求 ====================**/

    /**
     * 发送Post请求
     *
     * @param url          网络请求地址
     * @param request      请求参数
     * @param httpCallBack 请求回调函数
     */
    public void sendPost(String url, String request, HttpCallBack httpCallBack) {
        sendPost(url, request, httpCallBack, false);
    }

    /**
     * 发送带token的Post请求
     *
     * @param url          网络请求地址
     * @param request      请求参数
     * @param httpCallBack 请求回调函数
     * @param retry        是否重试 默认应为false,重新登录之后为true
     */
    public void sendPost(String url, String request, HttpCallBack httpCallBack, boolean retry) {
        if (hasNetwork()) {
            StringEntity stringEntity = null;
            try {
                stringEntity = new StringEntity(request, HTTP.UTF_8);
            } catch (Exception e) {
                stringEntity = null;
            }

            httpRequest = new HttpRequest(this);
            httpRequest.setContext(getContext())
                    .setType(RequestType.POST_ENTITY)
                    .setRetry(retry)
                    .setUrl(url)
                    .setHttpEntity(stringEntity)
                    .setHttpJson(request);

            BaseAsyncHttpClient.post(getContext(), url, stringEntity, getContentTypeJson(), getResponseHandler(httpRequest, httpCallBack));
        } else {

            httpCallBack.onNetError();
            httpCallBack.onFinish();
        }
    }

    /** ==================== RequestParams 的Post请求 =    ===================**/

    /**
     * 发送Post请求
     *
     * @param url          网络请求地址
     * @param params       请求参数
     * @param httpCallBack 请求回调函数
     */
    public void sendPost(String url, RequestParams params, HttpCallBack httpCallBack) {
        sendPost(url, params, httpCallBack, false);
    }

    /**
     * 发送Post请求
     *
     * @param url          网络请求地址
     * @param params       请求参数
     * @param httpCallBack 请求回调函数
     * @param retry        是否重试 默认应为false,重新登录之后为true
     */
    public void sendPost(String url, RequestParams params, HttpCallBack httpCallBack, boolean retry) {
        if (hasNetwork()) {

            httpRequest = new HttpRequest(this);
            httpRequest.setContext(getContext())
                    .setType(RequestType.POST_PARAMS)
                    .setRetry(retry)
                    .setParams(params)
                    .setUrl(url);

            BaseAsyncHttpClient.post(url, params, getResponseHandler(httpRequest, httpCallBack));
        } else {

            httpCallBack.onNetError();
            httpCallBack.onFinish();
        }
    }

    /** ==================== Http 的Post请求 ====================**/

    /**
     * 发送Post请求
     *
     * @param url          网络请求地址
     * @param httpCallBack 请求回调函数
     */
    public void sendPost(String url, HttpCallBack httpCallBack) {
        sendPost(url, httpCallBack, false);
    }

    /**
     * 发送Post请求
     *
     * @param url          网络请求地址
     * @param httpCallBack 请求回调函数
     * @param retry        是否重试 默认应为false,重新登录之后为true
     */
    public void sendPost(String url, HttpCallBack httpCallBack, boolean retry) {
        if (hasNetwork()) {
            httpRequest = new HttpRequest(this);
            httpRequest.setContext(getContext())
                    .setType(RequestType.POST)
                    .setRetry(retry)
                    .setUrl(url);

            BaseAsyncHttpClient.post(url, getResponseHandler(httpRequest, httpCallBack));
        } else {
            httpCallBack.onNetError();
            httpCallBack.onFinish();
        }
    }

    /** ==================== HttpEntity 的Post请求 ====================**/

    /**
     * 发送Post请求
     *
     * @param url          网络请求地址
     * @param entity       请求实体
     * @param httpCallBack 请求回调函数
     */
    public void sendPost(String url, HttpEntity entity, HttpCallBack httpCallBack) {
        sendPost(url, entity, httpCallBack, false);
    }

    /**
     * 发送带token的Post请求
     *
     * @param url          网络请求地址
     * @param entity       请求实体
     * @param httpCallBack 请求回调函数
     * @param retry        是否重试 默认应为false,重新登录之后为true
     */
    public void sendPost(String url, HttpEntity entity, HttpCallBack httpCallBack, boolean retry) {
        if (hasNetwork()) {
            httpRequest = new HttpRequest(this);
            httpRequest.setContext(getContext())
                    .setType(RequestType.POST_ENTITY)
                    .setRetry(retry)
                    .setUrl(url)
                    .setHttpEntity(entity);

            BaseAsyncHttpClient.post(getContext(), url, entity, CONTENT_TYPE_JSON, getResponseHandler(httpRequest, httpCallBack));
        } else {
            httpCallBack.onNetError();
            httpCallBack.onFinish();
        }
    }

    /** ==================== Delete 请求 ====================**/

    /**
     * 发送Delete请求
     *
     * @param url          网络请求地址
     * @param httpCallBack 请求回调函数
     */
    public void sendPut(String url, HttpCallBack httpCallBack) {
        sendPut(url, httpCallBack, false);
    }

    /**
     * 发送Delete请求
     *
     * @param url          网络请求地址
     * @param httpCallBack 请求回调函数
     * @param retry        是否重试 默认应为false,重新登录之后为true
     */
    public void sendPut(String url, HttpCallBack httpCallBack, boolean retry) {
        if (hasNetwork()) {
            httpRequest = new HttpRequest(this);
            httpRequest.setContext(getContext())
                    .setType(RequestType.PUT)
                    .setRetry(retry)
                    .setUrl(url);
            BaseAsyncHttpClient.put(url, getResponseHandler(httpRequest, httpCallBack));
        } else {
            httpCallBack.onFinish();
        }
    }

    /** ==================== JSON 的Put请求 ====================**/

    /**
     * 发送Post请求
     *
     * @param url          网络请求地址
     * @param request      请求参数
     * @param httpCallBack 请求回调函数
     */
    public void sendPut(String url, String request, HttpCallBack httpCallBack) {
        sendPut(url, request, httpCallBack, false);
    }

    /**
     * 发送带token的Post请求
     *
     * @param url          网络请求地址
     * @param request      请求参数
     * @param httpCallBack 请求回调函数
     * @param retry        是否重试 默认应为false,重新登录之后为true
     */
    public void sendPut(String url, String request, HttpCallBack httpCallBack, boolean retry) {
        if (hasNetwork()) {
            StringEntity stringEntity = null;
            try {
                stringEntity = new StringEntity(request, HTTP.UTF_8);
            } catch (Exception e) {
                stringEntity = null;
            }

            httpRequest = new HttpRequest(this);
            httpRequest.setContext(getContext())
                    .setType(RequestType.PUT_ENTITY)
                    .setRetry(retry)
                    .setUrl(url)
                    .setHttpEntity(stringEntity)
                    .setHttpJson(request);

            BaseAsyncHttpClient.put(getContext(), url, stringEntity, CONTENT_TYPE_JSON, getResponseHandler(httpRequest, httpCallBack));
        } else {
            httpCallBack.onNetError();
            httpCallBack.onFinish();
        }
    }

    /** ==================== HttpEntity 的Put请求 ====================**/

    /**
     * 发送Post请求
     *
     * @param url          网络请求地址
     * @param entity       请求实体
     * @param httpCallBack 请求回调函数
     */
    public void sendPut(String url, HttpEntity entity, HttpCallBack httpCallBack) {
        sendPut(url, entity, httpCallBack, false);
    }

    /**
     * 发送带token的Post请求
     *
     * @param url          网络请求地址
     * @param entity       请求实体
     * @param httpCallBack 请求回调函数
     * @param retry        是否重试 默认应为false,重新登录之后为true
     */
    public void sendPut(String url, HttpEntity entity, HttpCallBack httpCallBack, boolean retry) {
        if (hasNetwork()) {
            httpRequest = new HttpRequest(this);
            httpRequest.setContext(getContext())
                    .setType(RequestType.PUT_ENTITY)
                    .setRetry(retry)
                    .setUrl(url)
                    .setHttpEntity(entity);

            BaseAsyncHttpClient.put(getContext(), url, entity, CONTENT_TYPE_JSON, getResponseHandler(httpRequest, httpCallBack));
        } else {
            httpCallBack.onNetError();
            httpCallBack.onFinish();
        }
    }

    /** ==================== Delete 请求 ====================**/

    /**
     * 发送Delete请求
     *
     * @param url          网络请求地址
     * @param httpCallBack 请求回调函数
     */
    public void sendDelete(String url, HttpCallBack httpCallBack) {
        sendDelete(url, httpCallBack, false);
    }

    /**
     * 发送Delete请求
     *
     * @param url          网络请求地址
     * @param httpCallBack 请求回调函数
     * @param retry        是否重试 默认应为false,重新登录之后为true
     */
    public void sendDelete(String url, HttpCallBack httpCallBack, boolean retry) {
        if (hasNetwork()) {
            httpRequest = new HttpRequest(this);
            httpRequest.setContext(getContext())
                    .setType(RequestType.DELETE)
                    .setRetry(retry)
                    .setUrl(url);
            BaseAsyncHttpClient.delete(url, getResponseHandler(httpRequest, httpCallBack));
        } else {
            httpCallBack.onNetError();
            httpCallBack.onFinish();
        }
    }

    /** ==================== JSON 的Delete请求 ====================**/

    /**
     * 发送Post请求
     *
     * @param url          网络请求地址
     * @param request      请求参数
     * @param httpCallBack 请求回调函数
     */
    public void sendDelete(String url, String request, HttpCallBack httpCallBack) {
        sendDelete(url, request, httpCallBack, false);
    }

    /**
     * 发送带token的Post请求
     *
     * @param url          网络请求地址
     * @param request      请求参数
     * @param httpCallBack 请求回调函数
     * @param retry        是否重试 默认应为false,重新登录之后为true
     */
    public void sendDelete(String url, String request, HttpCallBack httpCallBack, boolean retry) {
        if (hasNetwork()) {
            StringEntity stringEntity = null;
            try {
                stringEntity = new StringEntity(request, HTTP.UTF_8);
            } catch (Exception e) {
                stringEntity = null;
            }

            httpRequest = new HttpRequest(this);
            httpRequest.setContext(getContext())
                    .setType(RequestType.DELETE_ENTITY)
                    .setRetry(retry)
                    .setUrl(url)
                    .setHttpEntity(stringEntity)
                    .setHttpJson(request);

            BaseAsyncHttpClient.delete(getContext(), url, stringEntity, CONTENT_TYPE_JSON, getResponseHandler(httpRequest, httpCallBack));
        } else {
            httpCallBack.onNetError();
            httpCallBack.onFinish();
        }
    }

    /** ==================== HttpEntity 的Delete请求 ====================**/

    /**
     * 发送Delete请求
     *
     * @param url          网络请求地址
     * @param entity       请求实体
     * @param httpCallBack 请求回调函数
     */
    public void sendDelete(String url, HttpEntity entity, HttpCallBack httpCallBack) {
        sendDelete(url, entity, httpCallBack, false);
    }

    /**
     * 发送Delete请求
     *
     * @param url          网络请求地址
     * @param entity       请求实体
     * @param httpCallBack 请求回调函数
     * @param retry        是否重试 默认应为false,重新登录之后为true
     */
    public void sendDelete(String url, HttpEntity entity, HttpCallBack httpCallBack, boolean retry) {
        if (hasNetwork()) {
            httpRequest = new HttpRequest(this);
            httpRequest.setContext(getContext())
                    .setType(RequestType.DELETE_ENTITY)
                    .setRetry(retry)
                    .setUrl(url)
                    .setHttpEntity(entity);

            BaseAsyncHttpClient.delete(getContext(), url, entity, CONTENT_TYPE_JSON, getResponseHandler(httpRequest, httpCallBack));
        } else {
            httpCallBack.onNetError();
            httpCallBack.onFinish();
        }
    }

    /**
     * 判断是否有网路连接
     *
     * @return true | false
     */
    public boolean hasNetwork() {
        if (getContext() != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    public abstract ResponseHandlerInterface getResponseHandler(HttpRequest httpRequest, HttpCallBack httpCallBack);
}
