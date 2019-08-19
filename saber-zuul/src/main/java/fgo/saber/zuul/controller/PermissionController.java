package fgo.saber.zuul.controller;

import fgo.saber.base.json.JsonResult;
import fgo.saber.shiro.extension.SbPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zq
 * @date 2019/8/19
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    public SbPermissions sbPermissions;

    @PostMapping("/change")
    public JsonResult updateFilter() {
        Map<String, String> filterMap = new HashMap<>();
        filterMap.put("/login/in", "anon");
        //把 admin 设置成不需要拦截
        filterMap.put("/**", "authc");
        sbPermissions.updatePermission(filterMap);
        return JsonResult.success(filterMap);
    }

    @PostConstruct
    private void init() {
        this.updateFilter();
    }

}
