package demo.mirror.com.mylibrary.http;

import com.loopj.android.http.RequestParams;
import com.loopj.android.http.ResponseHandlerInterface;

import java.io.File;
import java.io.FileNotFoundException;

import demo.mirror.com.mylibrary.adapter.HttpCallBack;
import demo.mirror.com.mylibrary.base.BaseHttpClient;
import demo.mirror.com.mylibrary.request.HttpRequest;

/**
 * 网络连接类
 */
public class HttpClient extends BaseHttpClient {

    @Override
    public ResponseHandlerInterface getResponseHandler(HttpRequest httpRequest, HttpCallBack httpCallBack) {
        return new ResponseHandlerAdapter(httpRequest, httpCallBack);
    }

    /**
     * 上传文件
     *
     * @param url
     * @param file
     */
    public void sendFile(String url, File file, HttpCallBack httpCallBack) {

        RequestParams params = new RequestParams();
        try {
            params.put("file", file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        sendPost(url, params, httpCallBack);
    }

}
