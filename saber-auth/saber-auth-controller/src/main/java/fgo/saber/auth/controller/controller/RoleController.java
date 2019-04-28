package fgo.saber.auth.controller.controller;

import fgo.saber.auth.api.cloudservice.RoleCloudService;
import fgo.saber.auth.api.param.RoleParam;
import fgo.saber.base.json.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zq
 * @date 2019/4/28
 */
@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleCloudService roleCloudService;

    @GetMapping("/list")
    public JsonResult findDeptList(RoleParam roleParam) {
        return roleCloudService.findRoleList(roleParam);
    }

    @PostMapping("/save")
    public JsonResult saveRole(RoleParam roleParam) {
        roleCloudService.saveRole(roleParam);
        return JsonResult.success("保存角色成功");
    }

    @PostMapping("/del")
    public JsonResult delRoleWithId(Long roleId) {
        roleCloudService.delRoleWithId(roleId);
        return JsonResult.success("删除角色成功");
    }

}
