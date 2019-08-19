package fgo.saber.auth.provider.controller;

import fgo.saber.auth.api.exception.AuthErrorResult;
import fgo.saber.base.json.JsonResult;
import fgo.saber.base.statuscode.CommonStatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.validation.constraints.NotBlank;

/**
 * @author zq
 * @date 2018/10/19
 */
@Api(value = "AuthController", tags = "登录相关的接口")
@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    @ApiOperation(value="用户登录", notes="用户登录接口,用于返回生成的token")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true ,dataType = "string"),
            @ApiImplicitParam(name = "password", value = "密码", required = true ,dataType = "string")
    })
    @PostMapping("/login")
    public JsonResult loginIn(@NotBlank(message = "用户名 不能为空") String username,
                              @NotBlank(message = "密码 不能为空") String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(token);
        } catch (UnknownAccountException e) {
            log.info("用户名不存在", e);
            return CommonStatusCode.USER_NOT_EXIST;
        } catch (IncorrectCredentialsException e) {
            log.info("账号密码不匹配", e);
            return CommonStatusCode.LOGIN_ERROR;
        } catch (AuthenticationException e) {
            log.info("登录的未知错误", e);
            return CommonStatusCode.LOGIN_UNKNOW_ERROR;
        }
        return JsonResult.success("登录成功");
    }

    @ApiOperation(value = "根据token获取角色和权限")
    @GetMapping("roles/{token}")
    public JsonResult checkIsLogin(@PathVariable String token) {
        //todo:
        return null;
    }

    @RequestMapping("/not_login")
    public JsonResult notLogin() {
        return AuthErrorResult.NOT_LOGIN;
    }

    @RequestMapping("/not_auth")
    public JsonResult notAuth() {
        return AuthErrorResult.NOT_LOGIN;
    }
}
