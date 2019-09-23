package fgo.saber.authr.cloud.service;

import fgo.saber.authr.cloud.service.DTO.AppShiroSettingDTO;
import fgo.saber.base.json.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author zq
 * @date 2019/9/23
 */
@FeignClient(value = "saber-authr-service", path = "/shiro/setting")
public interface ShiroSettingCloudService {

    @GetMapping("/all")
    JsonResult<List<AppShiroSettingDTO>> all();

}
