package fgo.saber.authr.cloud.service;

import fgo.saber.authr.cloud.service.DTO.AppGatewaySettingDTO;
import fgo.saber.base.json.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author zq
 * @date 2019/9/20
 */
@FeignClient(value = "saber-authr-service", path = "/gateway/setting")
public interface AppGatewaySettingCloudService {

    @GetMapping("/all")
    JsonResult<List<AppGatewaySettingDTO>> all();

}
