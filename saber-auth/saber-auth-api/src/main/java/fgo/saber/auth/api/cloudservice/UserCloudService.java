package fgo.saber.auth.api.cloudservice;

import fgo.saber.auth.api.dto.PageDto;
import fgo.saber.auth.api.dto.UserDto;
import fgo.saber.auth.api.dto.UserPasswordDto;
import fgo.saber.auth.api.param.UserPageParam;
import fgo.saber.auth.api.param.UserParam;
import fgo.saber.base.json.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author zq
 * @Date 2018/9/13
 */
@FeignClient(value = "saber-auth-provider")
public interface UserCloudService {

    /**
     * 根据用户id获取用户
     * @param userId
     * @return
     */
    @GetMapping("/user/{userId}")
    JsonResult<UserDto> findUserWithId(@PathVariable(name = "userId") Long userId);


    @GetMapping(value = "/user/list")
    JsonResult<PageDto> findUsers(@SpringQueryMap UserPageParam userParam);

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
     * @param userParam
     * @return
     */
    @PostMapping(value = "/user/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    JsonResult<Integer> saveUser(UserParam userParam);

    /**
     * 根据手机号/邮箱/用户名查找用户信息
     * @param keyWorld
     * @return
     */
    @GetMapping("/user/findUserWithKeyWorld")
    JsonResult<UserPasswordDto> findUserWithKeyWorld(@RequestParam(name = "keyWorld") String keyWorld);

}
