package fgo.saber.authr.service.controller;

import fgo.saber.authr.service.model.param.RolePermissionParam;
import fgo.saber.authr.service.service.RolePermissionServiceImpl;
import fgo.saber.base.json.JsonResult;
import fgo.saber.util.BeanValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zq
 * @date 2019/9/20
 */
@RestController
@RequestMapping("/rolePermission")
public class RolePermissionController {

    @Autowired
    private RolePermissionServiceImpl rolePermissionService;

    @PostMapping("/save")
    public JsonResult save(RolePermissionParam param) {
        BeanValidator.check(param);
        rolePermissionService.save(param);
        return JsonResult.success("保存用户角色关系成功");
    }
}
