package demo.mirror.com.mylibrary.http;

/**
 * base response
 * Created by lihaotian on 2016/11/25.
 */

public class BaseResponse {

    /**
     * error code
     */
    private int errno;

    /**
     * error message
     */
    private String errmsg;

    /**
     * total
     */
    private int total;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
