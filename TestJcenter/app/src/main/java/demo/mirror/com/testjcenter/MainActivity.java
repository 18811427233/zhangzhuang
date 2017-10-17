package demo.mirror.com.testjcenter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

import demo.mirror.com.mylibrary.okhttp.HttpConstant;
import demo.mirror.com.mylibrary.okhttp.HttpHandlerAdapter;
import demo.mirror.com.mylibrary.okhttp.OkHttpUtil;
import demo.mirror.com.mylibrary.okhttp.entity.FeedbackReq;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class MainActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void click1(View v) {
        String url = HttpConstant.PATH_CAROUSEL_LIST;
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("cityName", "全国");
        OkHttpUtil okHttpUtils = new OkHttpUtil();
        okHttpUtils.getOkHttpTwo(url, paramsMap, new HttpHandlerAdapter() {
            @Override
            public void onStart() {
                super.onStart();

                Log.e(TAG, "=======onStart====");
            }

            @Override
            public void onSuccess(String response) {
                Log.e(TAG, "=======onSuccess====");
            }

            @Override
            public void onFailure(int statusCode, String response, Throwable error) {
                Log.e(TAG, "=======onFailure====");
            }

            @Override
            public void onFinish() {
                Log.e(TAG, "=======onFinish====");
            }

            @Override
            public void onNetError() {
                super.onNetError();
                Log.e(TAG, "=======onNetError====");
            }
        });

    }

    public void click2(View v) {
        String url = HttpConstant.PATH_FEEDBACK_CREATE;
        FeedbackReq feedbackReq = new FeedbackReq();
        feedbackReq.setContent("不错");
        MediaType JSON1 = MediaType.parse("application/json; charset=utf-8");//数据类型为json格式，
        RequestBody body = RequestBody.create(JSON1, JSON.toJSONString(feedbackReq));

        OkHttpUtil okHttpUtils = new OkHttpUtil();
        okHttpUtils.postOkHttp(url, JSON.toJSONString(body), new HttpHandlerAdapter() {
            @Override
            public void onStart() {
                super.onStart();

                Log.e(TAG, "=======onStart====");
            }

            @Override
            public void onSuccess(String response) {
                Log.e(TAG, "=======onSuccess====");
            }

            @Override
            public void onFailure(int statusCode, String response, Throwable error) {
                Log.e(TAG, "=======onFailure====");
            }

            @Override
            public void onFinish() {
                Log.e(TAG, "=======onFinish====");
            }

            @Override
            public void onNetError() {
                super.onNetError();
                Log.e(TAG, "=======onNetError====");
            }
        });
    }

    public void click3(View v) {
        String url = HttpConstant.PATH_MUSEUM_LIST_TYPE;
        OkHttpUtil okHttpUtils = new OkHttpUtil();
        okHttpUtils.getOkHttp(url, new HttpHandlerAdapter() {
            @Override
            public void onStart() {
                super.onStart();

                Log.e(TAG, "=======onStart====");
            }

            @Override
            public void onSuccess(String response) {
                Log.e(TAG, "=======onSuccess====");
            }

            @Override
            public void onFailure(int statusCode, String response, Throwable error) {
                Log.e(TAG, "=======onFailure====");
            }

            @Override
            public void onFinish() {
                Log.e(TAG, "=======onFinish====");
            }

            @Override
            public void onNetError() {
                super.onNetError();
                Log.e(TAG, "=======onNetError====");
            }
        });
    }
}
