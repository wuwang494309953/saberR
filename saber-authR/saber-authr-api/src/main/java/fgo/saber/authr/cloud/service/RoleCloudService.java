package fgo.saber.authr.cloud.service;

import fgo.saber.authr.cloud.service.DTO.RoleDTO;
import fgo.saber.base.json.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author zq
 * @date 2019/9/23
 */
@FeignClient(value = "saber-authr-service", path = "/role")
public interface RoleCloudService {

    @GetMapping("/list/{appId}/{userId}")
    JsonResult<List<RoleDTO>> listWithAppAndUser(@PathVariable(value = "appId") Long appId, @PathVariable(value = "userId") Long userId);

}
