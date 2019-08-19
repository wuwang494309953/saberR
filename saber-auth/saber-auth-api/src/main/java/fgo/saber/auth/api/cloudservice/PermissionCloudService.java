package fgo.saber.auth.api.cloudservice;

import fgo.saber.auth.api.dto.PermissionDto;
import fgo.saber.base.json.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author zq
 * @date 2019/1/28
 */
@FeignClient("saber-auth-provider")
public interface PermissionCloudService {

    /**
     * 根据用户id获取权限点
     * @param userId
     * @return
     */
    @GetMapping("/permission/user/{userId}")
    JsonResult<List<PermissionDto>> findPermissionsWithUserId(@PathVariable(name = "userId") Long userId);

}
