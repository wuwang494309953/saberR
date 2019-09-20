package fgo.saber.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zq
 * @date 2019/8/26
 */
@RestController
public class TestController {

    @GetMapping("/test1")
    public String test1() {
        return "我是权限测试1";
    }

}
