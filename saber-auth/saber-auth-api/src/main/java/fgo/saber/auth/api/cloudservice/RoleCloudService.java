package fgo.saber.auth.api.cloudservice;

import fgo.saber.auth.api.dto.RoleDto;
import fgo.saber.base.json.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author zq
 * @date 2019/1/28
 */
@FeignClient(value = "${feign.name}")
public interface RoleCloudService {

    /**
     * 根据用户id获取角色
     * @param userId
     * @return
     */
    @GetMapping("/role/user/{userId}")
    JsonResult<List<RoleDto>> findRolesWithUserId(@PathVariable(name ="userId") Long userId);
}
