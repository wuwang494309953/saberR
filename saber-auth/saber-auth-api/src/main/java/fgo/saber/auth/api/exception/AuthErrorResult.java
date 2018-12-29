package fgo.saber.auth.api.exception;

import fgo.saber.base.json.JsonResult;

/**
 * @author zq
 * @Date 2018/9/12
 */
public class AuthErrorResult {


    public static final JsonResult PARAM_EXCEPTION = JsonResult.fail(1001, "接收参数异常");

    public static final JsonResult NOT_LOGIN = JsonResult.fail(1002, "用户未登录");

    public static final JsonResult NOT_Auth = JsonResult.fail(1003, "用户没有权限");
}
