package fgo.saber.auth.provider.controller;

import fgo.saber.auth.api.dto.PermissionModuleTreeDto;
import fgo.saber.auth.api.param.PermissionModuleParam;
import fgo.saber.auth.provider.model.entity.PermissionModule;
import fgo.saber.auth.provider.service.impl.PermissionModuleServiceImpl;
import fgo.saber.base.json.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author zq
 * @date 2018/10/24
 */
@Api(value = "PermissionModuleController", tags = "权限模块接口")
@RestController
@RequestMapping("/permission_module")
@Validated
public class PermissionModuleController {

    @Autowired
    private PermissionModuleServiceImpl permissionModuleService;

    @ApiOperation(value="保存权限模块", notes="permissionId 为空时新增,否则更新")
    @PostMapping("/save")
    public JsonResult save(PermissionModuleParam param) {
        permissionModuleService.save(param);
        return JsonResult.success("保存权限模块成功");
    }

    @ApiOperation(value="删除权限模块")
    @PostMapping("/del")
    public JsonResult del(Long permissionModuleId) {
        permissionModuleService.deleteByPrimaryKey(permissionModuleId);
        return JsonResult.success("删除权限模块成功");
    }

    @ApiOperation(value="根据角色id获取权限点模块")
    @GetMapping("/role/{roleId}")
    public JsonResult findRoles(@NotNull(message = "角色id不能为空") @PathVariable Long roleId) {
        List<PermissionModule> rolePageInfo = permissionModuleService.findPermissionModuleWithRoleId(roleId);
        return JsonResult.success(rolePageInfo);
    }

    @ApiOperation(value = "根据父模块id获取权限模块")
    @GetMapping(path = {"/parent/{parentId}", "/parent"})
    public JsonResult findPermissionModuleWithParentId(@PathVariable(name = "parentId", required = false) Long parentId) {
        parentId = parentId == null ? 0 : parentId;
        return JsonResult.success(permissionModuleService.findPermissionModuleWithParentId(parentId));
    }

    @ApiOperation(value = "获取所有部门的树形数据")
    @GetMapping("/tree")
    public JsonResult<List<PermissionModuleTreeDto>> getDeptTree() {
        return JsonResult.success(permissionModuleService.getpermissionModuleTree());
    }

}
