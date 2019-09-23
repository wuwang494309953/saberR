package fgo.saber.authr.cloud.service;

import fgo.saber.authr.cloud.service.DTO.PermissionDTO;
import fgo.saber.base.json.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author zq
 * @date 2019/9/23
 */
@FeignClient(value = "saber-authr-service", path = "/permission")
public interface PermissionCloudService {

    @GetMapping("/list/user/{appId}/{userId}")
    JsonResult<List<PermissionDTO>> listWithAppAndUser(@PathVariable(value = "appId") Long appId, @PathVariable(value = "userId") Long userId);

}
