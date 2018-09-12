package fgo.saber.auth.api.exception;

import fgo.saber.base.json.JsonResult;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zq
 * @Date 2018/9/12
 */
public class AuthErrorResult {

    static AtomicInteger _num = new AtomicInteger(1000);

    public static final JsonResult PARAM_EXCEPTION = JsonResult.fail(_num.incrementAndGet(), "接收参数异常");
}
