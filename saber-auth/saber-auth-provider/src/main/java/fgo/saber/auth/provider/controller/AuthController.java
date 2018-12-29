package fgo.saber.auth.provider.controller;

import fgo.saber.auth.api.dto.JwtDto;
import fgo.saber.auth.api.exception.AuthErrorResult;
import fgo.saber.base.json.JsonResult;
import fgo.saber.commom.jwt.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

/**
 * @author zq
 * @date 2018/10/19
 */
@Api(value = "AuthController", description = "用户登录，token管理控制器")
@RestController
@RequestMapping("auth")
public class AuthController {

    @GetMapping("apply_token/{appId}")
    public JsonResult<JwtDto> applyToken(@PathVariable String appId) {
        JwtDto jwtDto = JwtDto.builder()
                .jwt(JwtUtil.issueJwt(appId, "token_server", 60000L, "admin", "create,read,update,delete"))
                .build();
        return JsonResult.success(jwtDto);
    }

    @ApiOperation(value="用户登录", notes="用户登录接口,用于返回生成的token")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true ,dataType = "string"),
            @ApiImplicitParam(name = "password", value = "密码", required = true ,dataType = "string")
    })
    @PostMapping("login")
    public JsonResult loginIn(@NotBlank(message = "用户名 不能为空") String username,
                              @NotBlank(message = "密码 不能为空") String password) {

        return null;
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
