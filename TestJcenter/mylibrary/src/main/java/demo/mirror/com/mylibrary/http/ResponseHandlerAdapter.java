package demo.mirror.com.mylibrary.http;

import com.mirror.httpsession.adapter.DefaultResponseHandlerAdapter;
import com.mirror.httpsession.adapter.HttpCallBack;
import com.mirror.httpsession.request.HttpRequest;

import cn.trinea.android.common.util.JsonUtils;
import cz.msebera.android.httpclient.Header;

/**
 * ResponseHandlerAdapter.java
 * <p/>
 * <pre>
 *     处理HttpClient接收到的网络响应数据
 * </pre>
 */
public class ResponseHandlerAdapter extends DefaultResponseHandlerAdapter {
    /**
     * Logger for this class
     */
//    private static final String NETWORK_ERROR_CODE_0 = ConstantNotice.HTTP_EXCEPTION_REQUEST;
//    private static final String NETWORK_ERROR_CODE_500 = "服务器开小差了，请您稍后再试!";

    private static final int LOGIN_TIMEOUT = 31004;
    public ResponseHandlerAdapter(HttpRequest httpRequest, HttpCallBack httpCallBack) {
        super(httpRequest, httpCallBack);
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
        super.onSuccess(statusCode, headers, responseBody);

        if (responseBody != null) {

            String response = new String(responseBody);

            BaseResponse resp = JsonUtils.parseObject(response, BaseResponse.class);
            if (resp != null) {
                if (resp.getErrno() == ERROR_CODE_OK) {
                    getHttpCallBack().onSuccess(response);
                } else if (resp.getErrno() == LOGIN_TIMEOUT) {

//                    ToastUtils.show(getHttpRequest().getContext(), "登录超时，请重新登录");
//                    Intent intent = new Intent(getHttpRequest().getContext(), LoginActivity.class);
//                    Bundle bundle = new Bundle();
//                    bundle.putBoolean(Constant.INTENT_EXTRA_BOOT_LOGIN, false);
//                    intent.putExtras(bundle);
//                    getHttpRequest().getContext().startActivity(intent);
//                    getHttpCallBack().onFinish();

                } else {
                    getHttpCallBack().onFailure(statusCode, response, null);

                }
            } else {
                getHttpCallBack().onFailure(statusCode, "", null);
            }
        }
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
        super.onFailure(statusCode, headers, responseBody, error);

        if (responseBody == null || responseBody.length == 0) {
            getHttpCallBack().onFailure(statusCode, "", error);
        } else {
            getHttpCallBack().onFailure(statusCode, new String(responseBody), error);
        }
    }

}