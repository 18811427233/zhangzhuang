package demo.mirror.com.mylibrary.adapter;

/**
 * @see com.loopj.android.http.AsyncHttpResponseHandler
 */
public interface HttpCallBack {
    public void onStart();

    public void onSuccess(String response);

    public void onFailure(int statusCode, String response, Throwable error);

    public void onProgress(long bytesWritten, long totalSize);

    public void onRetry(int retryNo);

    public void onNetError();

    public void onFinish();
}
