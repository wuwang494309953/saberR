package fgo.saber.authr.cloud.service;

import fgo.saber.authr.cloud.service.DTO.UserDTO;
import fgo.saber.base.json.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zq
 * @date 2019/9/23
 */
@FeignClient(value = "saber-authr-service", path = "/user")
public interface UserCloudService {

    @GetMapping("/username")
    JsonResult<UserDTO> findUserWithUsername(@RequestParam("username") String username);

}
