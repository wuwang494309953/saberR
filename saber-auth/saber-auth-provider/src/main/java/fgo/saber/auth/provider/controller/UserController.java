package fgo.saber.auth.provider.controller;

import fgo.saber.auth.api.dto.UserDto;
import fgo.saber.auth.api.param.UserPageParam;
import fgo.saber.auth.api.param.UserParam;
import fgo.saber.auth.provider.model.entity.User;
import fgo.saber.auth.provider.service.impl.UserServiceImpl;
import fgo.saber.base.json.JsonResult;
import fgo.saber.util.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author zq
 * @Date 2018/9/19
 */
@RestController
@RequestMapping("user")
@Validated
@Slf4j
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/{userId}")
    public JsonResult<UserDto> findUserWithId(@NotNull Long userId) {
        UserDto userDto = BeanUtil.copy(userService.selectByPrimaryKey(userId), UserDto.class);
        return JsonResult.success(userDto);
    }


    @GetMapping("/list")
    public JsonResult<List<UserDto>> findUsers(@RequestBody UserPageParam userPageParam) {
        log.info(userPageParam.toString());
        return null;
    }

    @GetMapping("/dept_user/{deptId}")
    public JsonResult<List<UserDto>> findUsersWithDeptId(@PathVariable Long deptId) {
        List<User> users = userService.getUsersWithDeptId(deptId);
        return JsonResult.success(BeanUtil.copyList(users, UserDto.class));
    }

    @GetMapping("/role_user/{roleId}")
    public JsonResult<List<UserDto>> findUsersWithRoleId(@PathVariable Long roleId) {
        List<User> users = userService.getUsersWithRoleId(roleId);
        return JsonResult.success(BeanUtil.copyList(users, UserDto.class));
    }

    @PostMapping("/del")
    public JsonResult<Integer> delUserWithId(@NotNull Long userId) {
        return JsonResult.success(userService.deleteByPrimaryKey(userId));
    }

    @PostMapping("/save")
    public JsonResult<Integer> saveUser(UserParam userParam) {

        return null;
    }
}
