package fgo.saber.base.statuscode;

import fgo.saber.base.json.JsonResult;

/**
 * @author zq
 * @date 2019/1/3
 */
public class CommonStatusCode {

    public final static JsonResult ERROR = JsonResult.fail(1000, "系统异常");

    public final static JsonResult NOT_LOGIN = JsonResult.fail(1001, "用户未登陆");

    public final static JsonResult LOGIN_ERROR = JsonResult.fail(1002, "用户名或密码错误");

    public final static JsonResult LOGIN_UNKNOW_ERROR = JsonResult.fail(1003, "账户异常");



    public final static JsonResult USER_NOT_EXIST = JsonResult.fail(1101, "用户不存在");

}
