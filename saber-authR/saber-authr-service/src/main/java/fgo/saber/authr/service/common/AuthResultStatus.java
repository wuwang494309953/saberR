package fgo.saber.authr.service.common;

import fgo.saber.base.json.JsonResult;

/**
 * @author zq
 * @date 2019/8/27
 */
public class AuthResultStatus {

    public static final JsonResult ERROR = JsonResult.fail(1000, "未知的错误");

    public static final JsonResult PARAM_EXCEPTION = JsonResult.fail(1001, "参数错误");

    public static final JsonResult NOT_FOUND_EXCEPTION = JsonResult.fail(1002, "地址未找到");

    public static final JsonResult PARAM_TYPE_EXCEPTION = JsonResult.fail(1003, "参数类型错误");

    public static final JsonResult GATEWAY_NOT_EXIST = JsonResult.fail(1010, "网关设置信息不存在");

    public static final JsonResult APP_NOT_EXIST = JsonResult.fail(1011, "应用不存在");

    public static final JsonResult PERMISSION_NOT_EXIST = JsonResult.fail(1012, "权限点不存在");

    public static final JsonResult ROLE_NOT_EXIST = JsonResult.fail(1013, "角色不存在");

    public static final JsonResult RESOURCE_NOT_EXIST = JsonResult.fail(1014, "资源不存在");

    public static final JsonResult USER_NOT_EXIST = JsonResult.fail(1015, "用户不存在");

}
