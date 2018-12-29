package fgo.saber.auth.provider.controller;

import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import fgo.saber.auth.api.dto.PageDto;
import fgo.saber.auth.api.dto.UserDto;
import fgo.saber.auth.api.param.PageParam;
import fgo.saber.auth.api.param.PermissionParam;
import fgo.saber.auth.provider.model.entity.Permission;
import fgo.saber.auth.provider.service.impl.PermissionServiceImpl;
import fgo.saber.base.json.JsonResult;
import fgo.saber.util.BeanUtil;
import fgo.saber.util.BeanValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author zq
 * @date 2018/10/24
 */
@Api(value = "PermissionController", description = "权限点控制器")
@RestController
@RequestMapping("permission")
@Validated
public class PermissionController {

    @Autowired
    private PermissionServiceImpl permissionService;

    @ApiOperation(value="保存权限点", notes="permissionId 为空时新增,否则更新")
    @PostMapping("/save")
    public JsonResult<Integer> save(@RequestBody PermissionParam param) {
        BeanValidator.check(param);
        Permission permission = BeanUtil.to(param, Permission.class);
        Preconditions.checkNotNull(permission, "转换后的权限点信息为Null");
        if (param.getPermissionId() == null) {
            return JsonResult.success(permissionService.insertSelective(permission));
        }
        return JsonResult.success(permissionService.updateByPrimaryKeySelective(permission));
    }

    @ApiOperation(value="删除权限点")
    @PostMapping("/del")
    public JsonResult<Integer> del(@NotNull(message = "权限点模块id不能为空") @ApiParam(value = "权限点Id", required = true) Long permissionId) {
        permissionService.deleteByPrimaryKey(permissionId);
        return JsonResult.success();
    }

    @ApiOperation(value="获取权限点")
    @GetMapping("/list")
    public JsonResult<PageDto> findRoles(PermissionParam permissionParam, PageParam pageParam) {
        PageInfo<Permission> rolePageInfo = permissionService.findPermissionList(permissionParam, pageParam);

        List<UserDto> roleList = BeanUtil.toList(rolePageInfo.getList(), UserDto.class);
        PageDto pageDto = new PageDto<>(rolePageInfo.getTotal(), roleList);
        return JsonResult.success(pageDto);
    }

    @ApiOperation(value="根据权限模块id获取权限点")
    @GetMapping("/module/{permissionModuleId}")
    public JsonResult<List<Permission>> findRoles(@NotNull(message = "权限模块id不能为空") @PathVariable Long permissionModuleId) {
        List<Permission> rolePageInfo = permissionService.findPermissionWithModuleId(permissionModuleId);
        return JsonResult.success(rolePageInfo);
    }

}
