package fgo.saber.auth.controller.controller;

import fgo.saber.auth.api.cloudservice.UserCloudService;
import fgo.saber.auth.api.dto.UserDto;
import fgo.saber.auth.api.param.UserParam;
import fgo.saber.base.json.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * @author zq
 * @Date 2018/9/19
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserCloudService userCloudService;

    @GetMapping("/{userId}")
    public JsonResult findUserWithId(@PathVariable Long userId) {
        return null;
    }

    @GetMapping("/list")
    public JsonResult findUsers(UserParam userParam) {
        return userCloudService.findUsers(userParam);
    }

    @GetMapping("/dept/{deptId}")
    public JsonResult findUsersWithDeptId(@PathVariable Long deptId) {
        return null;
    }

    @GetMapping("/role/{roleId}")
    public JsonResult findUsersWithRoleId(@PathVariable Long roleId) {
        return null;
    }

    @PostMapping("/del")
    public JsonResult delUserWithId(@NotNull Long userId) {
        return null;
    }

    @PostMapping("/save")
    public JsonResult saveUser(UserDto userDto) {
        return null;
    }

}
