package fgo.saber.auth.provider.controller;

import fgo.saber.auth.api.dto.JwtDto;
import fgo.saber.base.json.JsonResult;
import fgo.saber.commom.jwt.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zq
 * @date 2018/10/19
 */
@RestController
@RequestMapping("auth")
public class AuthController {

    @GetMapping("apply_token/{appId}")
    public JsonResult<JwtDto> findDeptWithId(@PathVariable String appId) {
        JwtDto jwtDto = JwtDto.builder()
                .jwt(JwtUtil.issueJwt(appId, "token_server", 60000L, "admin", "create,read,update,delete"))
                .build();
        return JsonResult.success(jwtDto);
    }

}
