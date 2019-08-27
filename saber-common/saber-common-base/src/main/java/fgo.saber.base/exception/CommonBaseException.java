package fgo.saber.base.exception;

import fgo.saber.base.json.JsonResult;

/**
 * @author zq
 * @Date 2018/9/12
 */
public class CommonBaseException extends RuntimeException {

    private JsonResult result;

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

    public CommonBaseException(JsonResult result) {
        this.result = result;
    }

    public CommonBaseException(String message, JsonResult result) {
        super(message);
        this.result = result;
    }

    public JsonResult getResult() {
        return result;
    }

    public void setResult(JsonResult result) {
        this.result = result;
    }
}
