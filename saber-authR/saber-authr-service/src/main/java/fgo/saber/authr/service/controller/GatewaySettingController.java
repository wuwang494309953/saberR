package fgo.saber.authr.service.controller;

import com.github.pagehelper.PageInfo;
import fgo.saber.authr.service.model.entity.AppGatewaySetting;
import fgo.saber.authr.service.model.param.GatewaySettingParam;
import fgo.saber.authr.service.model.param.PageParam;
import fgo.saber.authr.service.model.vo.PageVO;
import fgo.saber.authr.service.service.GatewaySettingServiceImpl;
import fgo.saber.base.json.JsonResult;
import fgo.saber.util.BeanValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zq
 * @date 2019/8/27
 */
@RestController
@RequestMapping("/gateway/setting")
public class GatewaySettingController {

    @Autowired
    private GatewaySettingServiceImpl gatewaySettingService;

    @GetMapping("/list")
    public JsonResult list(GatewaySettingParam gatewaySettingParam, PageParam pageParam) {
        PageInfo<AppGatewaySetting> gatewaySettingPageInfo = gatewaySettingService.findSettingList(gatewaySettingParam, pageParam);
        PageVO<AppGatewaySetting> pageDto = new PageVO<>(gatewaySettingPageInfo.getTotal(), gatewaySettingPageInfo.getList());
        return JsonResult.success(pageDto);
    }

    @PostMapping("/save")
    public JsonResult save(GatewaySettingParam gatewaySettingParam) {
        BeanValidator.check(gatewaySettingParam);
        gatewaySettingService.save(gatewaySettingParam);
        return JsonResult.success("保存配置成功");
    }

    @PostMapping("/del/{gatewayId}")
    public JsonResult del(@PathVariable Long gatewayId) {
        gatewaySettingService.deleteByPrimaryKey(gatewayId);
        return JsonResult.success("删除配置成功");
    }

}
