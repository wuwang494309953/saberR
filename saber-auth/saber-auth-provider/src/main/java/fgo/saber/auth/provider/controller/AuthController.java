package fgo.saber.auth.provider.controller;

import fgo.saber.auth.api.dto.JwtDto;
import fgo.saber.base.json.JsonResult;
import fgo.saber.commom.jwt.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value="用户登录", notes="用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true ,dataType = "string"),
            @ApiImplicitParam(name = "password", value = "密码", required = true ,dataType = "string")
    })
    @PostMapping("login")
    public JsonResult loginIn() {

        return null;
    }

}
