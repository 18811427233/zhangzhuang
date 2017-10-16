package demo.mirror.com.mylibrary;

import android.content.Context;

import com.loopj.android.http.RequestParams;

import demo.mirror.com.mylibrary.http.HttpClient;
import demo.mirror.com.mylibrary.http.HttpConstant;
import demo.mirror.com.mylibrary.http.HttpHandler;
import demo.mirror.com.mylibrary.http.RequestParamsUtil;

/**
 * Created by zhangzhuang on 17/10/12.
 */

public class TestUtil {

    public static final int A = 0;
    public static final int B = 1;

    public TestUtil(Context context) {

        HttpSession.initialize(context);
    }

    public void http() {
        HttpClient client = AppApplication.getHttpClient();

        CarouselListReq req = new CarouselListReq();
        req.setCityName("全国");

        client.sendGet(HttpConstant.PATH_CAROUSEL_LIST, toParams(req), new HttpHandler() {

            @Override
            public void onStart() {
                super.onStart();

            }

            @Override
            public void onSuccess(String response) {
                super.onSuccess(response);

            }

            @Override
            public void onFailure(int statusCode, String response, Throwable error) {
                super.onFailure(statusCode, response, error);
            }

            @Override
            public void onFinish() {
                super.onFinish();

            }
        });

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

}
