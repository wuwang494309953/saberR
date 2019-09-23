package fgo.saber.zuul.common;

import fgo.saber.base.json.JsonResult;

/**
 * @author zq
 * @date 2019/8/27
 */
public class GatewayResultStatus {

    public static final JsonResult ERROR = JsonResult.fail(2000, "未知的错误");

    public static final JsonResult PERMISSION_INIT_ERROR = JsonResult.fail(2001, "初始化权限配置失败");

}
