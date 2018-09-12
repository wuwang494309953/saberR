package fgo.saber.base.exception;

/**
 * @author zq
 * @Date 2018/9/12
 */
public class CommonBaseException extends RuntimeException {

    public CommonBaseException() {
        super();
    }

    public CommonBaseException(String message) {
        super(message);
    }

    public CommonBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommonBaseException(Throwable cause) {
        super(cause);
    }

    protected CommonBaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
