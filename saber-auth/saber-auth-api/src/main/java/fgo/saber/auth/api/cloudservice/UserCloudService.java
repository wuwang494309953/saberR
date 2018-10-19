package fgo.saber.auth.api.cloudservice;

import fgo.saber.auth.api.dto.PageDto;
import fgo.saber.auth.api.dto.UserDto;
import fgo.saber.base.json.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author zq
 * @Date 2018/9/13
 */
@FeignClient(value = "${feign.name}")
public interface UserCloudService {

    /**
     * 根据用户id获取用户
     * @param userId
     * @return
     */
    @GetMapping("/user/{userId}")
    JsonResult<UserDto> findUserWithId(@PathVariable(name = "userId") Long userId);


    @GetMapping(value = "/user/list")
    JsonResult<PageDto> findUsers(@RequestParam Map<String, Object> map);

    /**
     * 根据部门id获取部门下的用户
     * @param deptId
     * @return
     */
    @GetMapping("/user_dept/{deptId}")
    JsonResult<List<UserDto>> findUsersWithDeptId(@PathVariable(name = "deptId") Long deptId);

    /**
     * 根据角色id获取角色下的用户
     * @param roleId
     * @return
     */
    @GetMapping("/dept_role/{roleId}")
    JsonResult<List<UserDto>> findUsersWithRoleId(@PathVariable(name = "roleId") Long roleId);

    /**
     * 根据id删除用户
     * @param userId
     * @return
     */
    @PostMapping("/user/del")
    JsonResult<Integer> delUserWithId(@RequestParam(name = "userId") Long userId);

    /**
     * 保存用户
     * @param userDto
     * @return
     */
    @PostMapping("/user/save")
    JsonResult<Integer> saveUser(@RequestBody UserDto userDto);

}
