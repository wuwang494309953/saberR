package fgo.saber.auth.provider.controller;

import fgo.saber.auth.api.dto.AppInfoDto;
import fgo.saber.auth.provider.service.impl.AppInfoServiceImpl;
import fgo.saber.base.json.JsonResult;
import fgo.saber.util.BeanUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zq
 * @date 2019/8/2
 */
@Api(value = "AppInfoController", tags = "app信息相关接口")
@RestController
@RequestMapping("/app")
@Slf4j
public class AppInfoController {

    @Autowired
    private AppInfoServiceImpl appInfoService;

    /**
     * 根据appId获取app的信息
     * @param appId appId
     * @return
     */
    @GetMapping("/detail/{appId}")
    public JsonResult<AppInfoDto> getAppInfoWithId(@PathVariable Long appId) {
        AppInfoDto appInfoDto = BeanUtil.to(appInfoService.selectByPrimaryKey(appId), AppInfoDto.class);
        return JsonResult.success(appInfoDto);
    }

}
