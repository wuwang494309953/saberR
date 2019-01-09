package fgo.saber.base.statuscode;

import fgo.saber.base.json.JsonResult;

/**
 * @author zq
 * @date 2019/1/3
 */
public class CommonStatusCode {

    public final static JsonResult NOT_LOGIN = JsonResult.fail(1001, "用户未登陆");

    public final static JsonResult LOGIN_ERROR = JsonResult.fail(1002, "用户名或密码错误");

}
