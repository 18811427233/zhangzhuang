package demo.mirror.com.mylibrary;

import android.app.Application;
import android.content.Context;

import demo.mirror.com.mylibrary.http.HttpClient;


/**
 * AppApplication
 * Created by lihaotian on 2016/11/18.
 */

public class AppApplication extends Application {

    private static Context context;

    private static HttpClient httpClient;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();
        getHttpClient();
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
