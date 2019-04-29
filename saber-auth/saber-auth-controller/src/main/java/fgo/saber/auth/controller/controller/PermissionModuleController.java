package fgo.saber.auth.controller.controller;

import fgo.saber.auth.api.cloudservice.PermissionModuleCloudService;
import fgo.saber.auth.api.dto.PermissionModuleTreeDto;
import fgo.saber.auth.api.param.PermissionModuleParam;
import fgo.saber.base.json.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zq
 * @date 2019/4/29
 */
@RestController
@RequestMapping("/permission_module")
public class PermissionModuleController {

    @Autowired
    private PermissionModuleCloudService permissionModuleCloudService;

    @PostMapping("/save")
    public JsonResult save(PermissionModuleParam permissionModuleParam) {
        return permissionModuleCloudService.save(permissionModuleParam);
    }

    @PostMapping("/del")
    public JsonResult delPermissionModuleWithId(Long permissionModuleId) {
        return permissionModuleCloudService.delPermissionModuleWithId(permissionModuleId);
    }

    @GetMapping("/tree")
    public JsonResult<List<PermissionModuleTreeDto>> getDeptTree() {
        return permissionModuleCloudService.getPermissionModuleTree();
    }

}
