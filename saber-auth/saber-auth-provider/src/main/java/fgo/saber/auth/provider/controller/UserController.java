package fgo.saber.auth.provider.controller;

import com.github.pagehelper.PageInfo;
import fgo.saber.auth.api.dto.PageDto;
import fgo.saber.auth.api.dto.UserDto;
import fgo.saber.auth.api.param.PageParam;
import fgo.saber.auth.api.param.UserParam;
import fgo.saber.auth.provider.model.entity.User;
import fgo.saber.auth.provider.service.impl.UserServiceImpl;
import fgo.saber.base.json.JsonResult;
import fgo.saber.base.statuscode.CommonStatusCode;
import fgo.saber.util.BeanUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author zq
 * @Date 2018/9/19
 */
@Api(value = "RoleController", tags = "用户接口")
@RestController
@RequestMapping("/user")
@Validated
@Slf4j
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @ApiOperation(value="根据userId查找用户", notes="userId不能为空")
    @GetMapping("/{userId}")
    public JsonResult<UserDto> findUserWithId(@PathVariable Long userId) {
        UserDto userDto = BeanUtil.to(userService.selectByPrimaryKey(userId), UserDto.class);
        return JsonResult.success(userDto);
    }

    @ApiOperation(value="查询用户列表")
    @GetMapping("/list")
    public JsonResult<PageDto> findUsers(UserParam userParam, PageParam pageParam) {
        PageInfo<UserDto> userPageInfo = userService.findUserList(userParam, pageParam);
        PageDto<UserDto> pageDto = new PageDto<>(userPageInfo.getTotal(), userPageInfo.getList());
        return JsonResult.success(pageDto);
    }

    @ApiOperation(value="根据部门下的用户")
    @GetMapping("/dept_user/{deptId}")
    public JsonResult<List<UserDto>> findUsersWithDeptId(@PathVariable Long deptId) {
        List<User> users = userService.findUsersWithDeptId(deptId);
        return JsonResult.success(BeanUtil.toList(users, UserDto.class));
    }

    @ApiOperation(value="根据具有改角色的用户")
    @GetMapping("/role_user/{roleId}")
    public JsonResult<List<UserDto>> findUsersWithRoleId(@PathVariable Long roleId) {
        List<User> users = userService.findUsersWithRoleId(roleId);
        return JsonResult.success(BeanUtil.toList(users, UserDto.class));
    }

    @ApiOperation(value="根据userId删除用户")
    @PostMapping("/del")
    public JsonResult<Integer> delUserWithId(@NotNull Long userId) {
        userService.deleteByPrimaryKey(userId);
        return JsonResult.success("删除成功");
    }

    @ApiOperation(value="新增/修改用户", notes="userId为空则新增，否则修改")
    @PostMapping("/save")
    public JsonResult<Integer> saveUser(UserParam userParam) {
        userService.save(userParam);
        return JsonResult.success("保存成功");
    }

    @ApiOperation(value="根据邮箱/手机号/用户名 查找用户")
    @GetMapping("/findUserWithKeyWorld")
    public JsonResult findUserWithKeyWorld(@NotBlank(message = "用户名不能为空") String keyWorld) {
        User user = userService.findUserWithKeyWorld(keyWorld);
        if (user == null) {
            return CommonStatusCode.USER_NOT_EXIST;
        }
        return JsonResult.success(user);
    }
}
