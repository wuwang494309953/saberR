package fgo.saber.auth.controller.controller;

import fgo.saber.auth.api.cloudservice.UserCloudService;
import fgo.saber.auth.api.param.PageParam;
import fgo.saber.auth.api.param.UserPageParam;
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
    public JsonResult findUsers(UserPageParam userParam) {
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
    public JsonResult delUserWithId(@NotNull(message = "userId不能为空") Long userId) {
        return userCloudService.delUserWithId(userId);
    }

    @PostMapping("/save")
    public JsonResult saveUser(UserParam userParam) {
        return userCloudService.saveUser(userParam);
    }

}
