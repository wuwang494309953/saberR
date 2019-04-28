package fgo.saber.auth.api.cloudservice;

import fgo.saber.auth.api.dto.PageDto;
import fgo.saber.auth.api.dto.RoleDto;
import fgo.saber.auth.api.param.RoleParam;
import fgo.saber.base.json.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author zq
 * @date 2019/1/28
 */
@FeignClient(value = "${feign.name}", path = "/role")
public interface RoleCloudService {

    /**
     * 获取角色列表
     * @param roleParam
     * @return
     */
    @GetMapping("/list")
    JsonResult<PageDto> findRoleList(@SpringQueryMap RoleParam roleParam);

    /**
     * 根据id删除角色
     * @param roleId
     * @return
     */
    @PostMapping("/del")
    JsonResult<Integer> delRoleWithId(@NotNull @RequestParam(name = "roleId") Long roleId);

    /**
     * 保存角色
     * @param roleParam
     * @return
     */
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    JsonResult<Integer> saveRole(RoleParam roleParam);

    /**
     * 根据用户id获取角色
     * @param userId
     * @return
     */
    @GetMapping("/role/user/{userId}")
    JsonResult<List<RoleDto>> findRolesWithUserId(@PathVariable(name ="userId") Long userId);
}
