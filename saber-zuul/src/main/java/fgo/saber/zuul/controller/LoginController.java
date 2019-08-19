package fgo.saber.zuul.controller;

import fgo.saber.base.json.JsonResult;
import fgo.saber.base.statuscode.CommonStatusCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * @author zq
 * @date 2019/8/19
 */
@RestController
@RequestMapping("/login")
@Slf4j
@Validated
public class LoginController {

    @PostMapping("/in")
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

    @PostMapping("/out")
    public JsonResult loginOut() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return JsonResult.success("退出成功");
    }

}
