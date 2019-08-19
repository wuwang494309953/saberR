package fgo.saber.auth.api.cloudservice;

import fgo.saber.auth.api.dto.AppInfoDto;
import fgo.saber.base.json.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zq
 * @date 2019/8/2
 */
@FeignClient(value = "saber-auth-provider", path = "/app")
public interface AppInfoCloudService {

    /**
     * 根据appId获取app的信息
     * @param appId appId
     * @return
     */
    @GetMapping("/detail/{appId}")
    JsonResult<AppInfoDto> getAppInfoWithId(@PathVariable(name = "appId") Long appId);

}
