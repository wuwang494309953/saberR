package fgo.saber.auth.provider.controller;

import fgo.saber.auth.api.dto.UserDto;
import fgo.saber.auth.api.param.UserPageParam;
import fgo.saber.base.json.JsonResult;
import lombok.extern.slf4j.Slf4j;
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

    @GetMapping("/{userId}")
    public JsonResult<UserDto> findUserWithId(@NotNull Long userId) {
        return null;
    }



    @GetMapping("/list")
    public JsonResult<List<UserDto>> findUsers(@RequestBody UserPageParam userPageParam) {
        log.info(userPageParam.toString());
        return null;
    }

    @GetMapping("/dept/{deptId}")
    public JsonResult<List<UserDto>> findUsersWithDeptId(Long deptId) {
        return null;
    }

    @GetMapping("/role/{roleId}")
    public JsonResult<List<UserDto>> findUsersWithRoleId(Long roleId) {
        return null;
    }

    @PostMapping("/del")
    public JsonResult<Integer> delUserWithId(@NotNull Long userId) {
        return null;
    }

    @PostMapping("/save")
    public JsonResult<Integer> saveUser(UserDto userDto) {
        return null;
    }
}
