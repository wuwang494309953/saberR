package fgo.saber.auth.controller.controller;

import fgo.saber.auth.api.cloudservice.UserCloudService;
import fgo.saber.auth.api.dto.UserDto;
import fgo.saber.auth.api.param.PageParam;
import fgo.saber.auth.api.param.UserParam;
import fgo.saber.base.json.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Map;

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
    public JsonResult<UserDto> findUserWithId(@PathVariable Long userId) {
        return null;
    }

    @GetMapping("/list")
    public Map findUsers(UserParam userParam, PageParam pageParam, @RequestParam Map Param) {
        return userCloudService.findUsers(userParam, pageParam).toMap();
    }

    @GetMapping("/dept/{deptId}")
    public Map findUsersWithDeptId(@PathVariable Long deptId) {
        return null;
    }

    @GetMapping("/role/{roleId}")
    public Map findUsersWithRoleId(@PathVariable Long roleId) {
        return null;
    }

    @PostMapping("/del")
    public Map delUserWithId(@NotNull Long userId) {
        return null;
    }

    @PostMapping("/save")
    public Map saveUser(UserDto userDto) {
        return null;
    }

}
