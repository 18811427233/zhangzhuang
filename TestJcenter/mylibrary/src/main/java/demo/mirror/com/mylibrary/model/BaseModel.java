package demo.mirror.com.mylibrary.model;

import android.content.Context;

import com.loopj.android.http.RequestParams;
import com.mirror.common.commondialog.httploadingdialog.HttpLoadingDialog;

import cn.trinea.android.common.base.CommonModel;
import cn.trinea.android.common.util.ToastUtils;
import demo.mirror.com.mylibrary.AppApplication;
import demo.mirror.com.mylibrary.R;
import demo.mirror.com.mylibrary.http.BaseResponse;
import demo.mirror.com.mylibrary.http.HttpClient;
import demo.mirror.com.mylibrary.http.HttpHandler;
import demo.mirror.com.mylibrary.http.RequestParamsUtil;

/**
 * 父类Model
 * Created by lihaotian on 16/1/4.
 */
public class BaseModel extends CommonModel {

    private HttpClient httpClient;
    protected HttpLoadingDialog httpLoadingDialog;

    public BaseModel(Context context) {
        super(context);

        httpClient = AppApplication.getHttpClient();
        httpLoadingDialog = new HttpLoadingDialog(context);
    }

    /**
     * 把Object对象转换为RequestParams对象
     *
     * @param object
     * @return
     */
    public static RequestParams toParams(Object object) {
        return RequestParamsUtil.toRequestParams(object);
    }

    /**
     * 发送Get请求
     *
     * @param url
     * @param httpHandler
     */
    public void sendGet(String url, HttpHandler httpHandler) {
        if (hasNetWork()) {
            httpClient.sendGet(url, httpHandler);
        } else {
            showNetWorkError();
        }
    }

    /**
     * 发送Post请求
     *
     * @param url
     * @param httpHandler
     */
    public void sendPost(String url, HttpHandler httpHandler) {
        if (hasNetWork()) {
            httpClient.sendPost(url, httpHandler);
        } else {
            showNetWorkError();
        }
    }

    /**
     * 发送Post请求
     *
     * @param url
     * @param req
     * @param httpHandler
     */
    public void sendPost(String url, Object req, HttpHandler httpHandler) {
        if (hasNetWork()) {
            httpClient.sendPost(url, toJSONString(req), httpHandler);
        } else {
            showNetWorkError();
        }
    }

    /**
     * 发送Get请求
     *
     * @param url
     * @param req
     * @param httpHandler
     */
    public  void sendGet(String url, Object req, HttpHandler httpHandler) {
        if (hasNetWork()) {
            httpClient.sendGet(url, toParams(req), httpHandler);
        } else {
            showNetWorkError();
        }
    }

    /**
     * 提示网络错误
     */
    public void showNetWorkError() {
        ToastUtils.show(context, context.getString(R.string.text_error_no_network));
    }

    /**
     * 处理Http请求失败之后的响应
     *
     * @param response
     */
    protected void handleFailure(String response) {
        BaseResponse resp = parseObject(response, BaseResponse.class);
        if (resp != null && isNotEmpty(resp.getErrmsg())) {
            showToast(resp.getErrmsg());
        }
    }
}
