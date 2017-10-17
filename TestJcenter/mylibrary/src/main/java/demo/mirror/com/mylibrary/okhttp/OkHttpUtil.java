package demo.mirror.com.mylibrary.okhttp;

import java.util.Map;

import static demo.mirror.com.mylibrary.okhttp.BaseHttpUtil.okHttpGet;
import static demo.mirror.com.mylibrary.okhttp.BaseHttpUtil.okHttpPost;

/**
 * Created by zhangzhuang on 17/10/17.
 */

public class OkHttpUtil {

    public void getOkHttp(String url, HttpCallBack httpCallBack) {
        okHttpGet(url, null, httpCallBack);
    }

    public void getOkHttpTwo(String url, Map<String, String> map, HttpCallBack httpCallBack) {
        okHttpGet(url, map, httpCallBack);
    }

    public void postOkHttp(String url, Object object, HttpCallBack httpCallBack) {
        okHttpPost(url, object, httpCallBack);
    }

}
