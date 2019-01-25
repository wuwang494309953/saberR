package fgo.saber.commom.shiro.controller;

import fgo.saber.base.json.JsonResult;
import fgo.saber.base.statuscode.CommonStatusCode;
import fgo.saber.commom.shiro.param.LoginParam;
import fgo.saber.util.BeanValidator;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

/**
 * @author zq
 * @date 2019/1/3
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @GetMapping("not")
    public JsonResult notLogin() {
        return CommonStatusCode.NOT_LOGIN;
    }

    @PostMapping(value = "/in")
    public JsonResult login(LoginParam param) {
        BeanValidator.check(param);
        UsernamePasswordToken token = new UsernamePasswordToken(param.getUsername(), param.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return JsonResult.success("登录成功");
        } catch (AuthenticationException e) {
            return CommonStatusCode.LOGIN_ERROR;
        }
    }

}
