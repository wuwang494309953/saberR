package fgo.saber.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zq
 * @date 2019/8/17
 */
@RestController
public class Test1Controller {

    @GetMapping("/test1")
    public String test1() {
        return "登录后可以访问";
    }

    @GetMapping("/test2")
    public String test2() {
        return "需要角色 boy 可以访问";
    }

    @GetMapping("/test3")
    public String test3() {
        return "需要权限点 test1 可以访问";
    }

}
