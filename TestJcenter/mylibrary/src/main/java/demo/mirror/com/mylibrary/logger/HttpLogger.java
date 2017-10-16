package demo.mirror.com.mylibrary.logger;


import org.slf4j.Logger;

import java.util.Locale;

import cz.msebera.android.httpclient.Header;
import demo.mirror.com.mylibrary.request.HttpRequest;

/**
 * Http logger
 */
public class HttpLogger {

    /**
     * 登录
     *
     * @param logger
     * @param username
     * @param password
     */
    public static void loggerLogin(Logger logger, String username, String password) {
        logger.info("====================Request Start====================\nusername:{},password:{}\n====================Request End====================", username, password);
    }

    /**
     * HttpStart
     *
     * @param logger
     * @param httpRequest
     */
    public static void loggerOnStart(Logger logger, HttpRequest httpRequest) {
        logger.info("====================Start====================");
        logger.info("====================Request Start====================\nrequest:{}\n====================Request End====================", httpRequest.toString());
    }

    /**
     * HttpSuccess
     *
     * @param logger
     * @param httpRequest
     * @param statusCode
     * @param headers
     * @param responseBody
     */
    public static void loggerOnSuccess(Logger logger, HttpRequest httpRequest, int statusCode, Header[] headers, byte[] responseBody) {
        StringBuilder builder = new StringBuilder();
        if (headers != null) {
            for (Header h : headers) {
                String _h = String.format(Locale.getDefault(), "%s : %s", h.getName(), h.getValue());
                builder.append(_h);
                builder.append("\n");
            }
        }
        String response = (responseBody == null || responseBody.length == 0) ? "" : new String(responseBody);
        logger.info("====================Success Start====================\nurl:{}\nstatusCode:{},headers:{},responseBody:{}\n====================Success End====================",
                httpRequest.getUrl(), statusCode, builder.toString(), response);
    }

    /**
     * HttpFailure
     *
     * @param logger
     * @param httpRequest
     * @param statusCode
     * @param headers
     * @param responseBody
     * @param error
     */
    public static void loggerOnFailure(Logger logger, HttpRequest httpRequest, int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
        StringBuilder builder = new StringBuilder();
        if (headers != null) {
            for (Header h : headers) {
                String _h = String.format(Locale.getDefault(), "%s : %s", h.getName(), h.getValue());
                builder.append(_h);
                builder.append("\n");
            }
        }
        logger.info("====================Failure Start====================\nurl:{}\nstatusCode:{},headers:{},error:{}\n====================Failure End====================", httpRequest.getUrl(),
                statusCode, builder.toString(), error.getMessage());
    }

    /**
     * httpFinish
     *
     * @param logger
     */
    public static void loggerOnFinish(Logger logger) {
        logger.info("====================Finish====================");
    }
}
