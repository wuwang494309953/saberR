package fgo.saber.util.exception;

import fgo.saber.base.exception.CommonBaseException;

/**
 * @author zq
 * @Date 2018/9/12
 */
public class CommonUtilException extends CommonBaseException {

    public CommonUtilException() {
        super();
    }

    public CommonUtilException(String message) {
        super(message);
    }

    public CommonUtilException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommonUtilException(Throwable cause) {
        super(cause);
    }

    protected CommonUtilException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
