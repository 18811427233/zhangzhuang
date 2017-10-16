package demo.mirror.com.mylibrary;

import android.content.Context;
import android.util.Log;

import demo.mirror.com.mylibrary.http.HttpConstant;
import demo.mirror.com.mylibrary.http.HttpHandler;
import demo.mirror.com.mylibrary.http.entity.CarouselListReq;
import demo.mirror.com.mylibrary.model.BaseModel;

/**
 * Created by zhangzhuang on 17/10/12.
 */

public class TestUtil extends BaseModel{

    public static final int A = 0;

    public TestUtil(Context context) {
        super(context);
    }

    /**
     * 首页banner
     */
    public static void carouselList() {

        CarouselListReq req = new CarouselListReq();
        req.setCityName("全国");

        sendGet(HttpConstant.PATH_CAROUSEL_LIST, req, new HttpHandler() {

            @Override
            public void onStart() {
                super.onStart();

            }

            @Override
            public void onSuccess(String response) {
                super.onSuccess(response);

                Log.e("====library=======","========="+response.toString());

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

}
