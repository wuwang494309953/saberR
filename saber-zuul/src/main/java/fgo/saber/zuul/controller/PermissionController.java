package fgo.saber.zuul.controller;

import com.google.common.collect.Maps;
import fgo.saber.authr.cloud.service.DTO.AppShiroSettingDTO;
import fgo.saber.authr.cloud.service.ShiroSettingCloudService;
import fgo.saber.base.json.JsonResult;
import fgo.saber.shiro.extension.SbPermissions;
import fgo.saber.zuul.common.GatewayResultStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * @author zq
 * @date 2019/8/19
 */
@RestController
@RequestMapping("/permission")
@Slf4j
public class PermissionController {

    @Autowired
    public SbPermissions sbPermissions;

    @Autowired
    public ShiroSettingCloudService shiroSettingCloudService;

    @PostMapping("/setting/refresh")
    public JsonResult refresh() {
        JsonResult<List<AppShiroSettingDTO>> result = shiroSettingCloudService.all();

        if (result.getCode() != 0) {
            return GatewayResultStatus.PERMISSION_INIT_ERROR;
        }
        Map<String, String> filterMap = Maps.newLinkedHashMap();
        for (AppShiroSettingDTO shiroSettingDTO : result.getData()) {
            filterMap.put(shiroSettingDTO.getShiroPath(), shiroSettingDTO.getShiroAuth());
        }
        //把 admin 设置成不需要拦截
//        filterMap.put("/**", "authc");

        sbPermissions.updatePermission(filterMap);
        return JsonResult.success(filterMap);
    }

    @PostConstruct
    private void init() {
        try {
            this.refresh();
        } catch (Exception e) {
            log.error("Shiro权限配置初始化失败.", e);
        }
    }

}
