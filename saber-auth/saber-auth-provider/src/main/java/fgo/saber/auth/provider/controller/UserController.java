package fgo.saber.auth.provider.controller;

import com.github.pagehelper.PageInfo;
import fgo.saber.auth.api.dto.PageDto;
import fgo.saber.auth.api.dto.UserDto;
import fgo.saber.auth.api.param.UserParam;
import fgo.saber.auth.provider.model.entity.User;
import fgo.saber.auth.provider.service.impl.UserServiceImpl;
import fgo.saber.base.json.JsonResult;
import fgo.saber.util.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author zq
 * @Date 2018/9/19
 */
@RestController
@RequestMapping("/user")
@Validated
@Slf4j
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/{userId}")
    public JsonResult<UserDto> findUserWithId(@NotNull Long userId) {
        UserDto userDto = BeanUtil.to(userService.selectByPrimaryKey(userId), UserDto.class);
        return JsonResult.success(userDto);
    }

    @GetMapping("/list")
    public JsonResult<PageDto> findUsers(UserParam userParam) {
        PageInfo<UserDto> userPageInfo = userService.findUserList(userParam);
        PageDto<UserDto> pageDto = new PageDto<>(userPageInfo.getTotal(), userPageInfo.getList());
        return JsonResult.success(pageDto);
    }

    @GetMapping("/dept_user/{deptId}")
    public JsonResult<List<UserDto>> findUsersWithDeptId(@PathVariable Long deptId) {
        List<User> users = userService.findUsersWithDeptId(deptId);
        return JsonResult.success(BeanUtil.toList(users, UserDto.class));
    }

    @GetMapping("/role_user/{roleId}")
    public JsonResult<List<UserDto>> findUsersWithRoleId(@PathVariable Long roleId) {
        List<User> users = userService.findUsersWithRoleId(roleId);
        return JsonResult.success(BeanUtil.toList(users, UserDto.class));
    }

    @PostMapping("/del")
    public JsonResult<Integer> delUserWithId(@NotNull Long userId) {
        userService.deleteByPrimaryKey(userId);
        return JsonResult.success();
    }

    @PostMapping("/save")
    public JsonResult<Integer> saveUser(UserParam userParam) {
        if (userParam.getUserId() == null) {
            userService.save(userParam);
        } else {
            userService.update(userParam);
        }
        return JsonResult.success();
    }

    @GetMapping("/findUserWithPhone")
    public JsonResult<User> findUserWithPhone(@NotBlank(message = "用户名不能为空") String phone) {
        return JsonResult.success(userService.findUserWithPhone(phone));
    }
}
