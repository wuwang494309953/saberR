package fgo.saber.auth.provider.controller;

import com.github.pagehelper.PageInfo;
import fgo.saber.auth.api.dto.PageDto;
import fgo.saber.auth.api.param.PageParam;
import fgo.saber.auth.api.param.RoleParam;
import fgo.saber.auth.provider.model.entity.Role;
import fgo.saber.auth.provider.service.impl.RoleServiceImpl;
import fgo.saber.base.json.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author zq
 * @date 2018/10/23
 */
@Api(value = "RoleController", tags = "角色接口")
@RestController
@RequestMapping("/role")
@Validated
public class RoleController {

    @Autowired
    private RoleServiceImpl roleService;

    @ApiOperation(value="保存角色", notes="roleId为空时新增,否则更新")
    @PostMapping("/save")
    public JsonResult<Integer> saveRole(RoleParam roleParam) {
        roleService.save(roleParam);
        return JsonResult.success("角色保存成功");
    }

    @ApiOperation(value="删除角色")
    @PostMapping("/del")
    public JsonResult<Integer> delDeptWithId(@ApiParam(value = "角色Id", required = true) @NotNull Long roleId) {
        roleService.deleteByPrimaryKey(roleId);
        return JsonResult.success();
    }

    @ApiOperation(value="获取角色")
    @GetMapping("/list")
    public JsonResult<PageDto> findRoles(RoleParam roleParam, PageParam pageParam) {
        PageInfo<Role> rolePageInfo = roleService.findRoleList(roleParam, pageParam);

        PageDto pageDto = new PageDto<>(rolePageInfo.getTotal(), rolePageInfo.getList());
        return JsonResult.success(pageDto);
    }

    @ApiOperation(value="根据用户拥有的角色")
    @GetMapping("/user/{userId}")
    public JsonResult<List<Role>> findRolesWithUserId(@ApiParam(value = "用户id", required = true) @PathVariable(name ="userId") Long userId) {
        return JsonResult.success(roleService.findRolesWithUserId(userId));
    }

}
