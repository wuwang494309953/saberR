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
        return "hello world 1";
    }

    @GetMapping("/test2")
    public String test2() {
        return "my test 2";
    }

}
