package demo.mirror.com.mylibrary;

import android.app.Application;
import android.content.Context;

import com.mirror.httpsession.HttpSession;

import demo.mirror.com.mylibrary.http.HttpClient;

/**
 * Created by zhangzhuang on 17/10/16.
 */

public class AppApplication extends Application {

    private static Context context;

    private static HttpClient httpClient;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();

    }

    /**
     * 获取网络连接
     *
     * @return
     */
    public static HttpClient getHttpClient() {
        synchronized (AppApplication.class) {
            if (httpClient == null) {
                HttpSession.initialize(context);
                httpClient = new HttpClient();
            }
        }
        return httpClient;
    }

}