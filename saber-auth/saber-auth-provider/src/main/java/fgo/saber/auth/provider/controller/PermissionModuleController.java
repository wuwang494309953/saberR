package fgo.saber.auth.provider.controller;

import com.google.common.base.Preconditions;
import fgo.saber.auth.api.param.PermissionModuleParam;
import fgo.saber.auth.provider.model.entity.PermissionModule;
import fgo.saber.auth.provider.service.impl.PermissionModuleServiceImpl;
import fgo.saber.base.json.JsonResult;
import fgo.saber.util.BeanUtil;
import fgo.saber.util.BeanValidator;
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
@Api(value = "PermissionModuleController", description = "权限模块控制器")
@RestController
@RequestMapping("permission_module")
@Validated
public class PermissionModuleController {

    @Autowired
    private PermissionModuleServiceImpl permissionModuleService;

    @ApiOperation(value="保存权限模块", notes="permissionId 为空时新增,否则更新")
    @PostMapping("/save")
    public JsonResult save(@RequestBody PermissionModuleParam param) {
        BeanValidator.check(param);
        PermissionModule permissionModule = BeanUtil.to(param, PermissionModule.class);
        Preconditions.checkNotNull(permissionModule, "转换后的权限模块信息为Null");
        if (param.getPermissionModuleId() == null) {
            return JsonResult.success(permissionModuleService.insertSelective(permissionModule));
        }
        return JsonResult.success(permissionModuleService.updateByPrimaryKeySelective(permissionModule));
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

}
