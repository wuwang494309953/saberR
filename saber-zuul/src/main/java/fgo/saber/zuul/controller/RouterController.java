package fgo.saber.zuul.controller;

import fgo.saber.base.json.JsonResult;
import fgo.saber.zuul.CustomRouteLocator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * @author zq
 * @date 2019/9/20
 */
@RestController
@RequestMapping("/router")
@Slf4j
public class RouterController {

    @Autowired
    @Qualifier("routeLocator")
    private CustomRouteLocator routeLocator;

    @RequestMapping("/setting/refresh")
    public JsonResult refreshSetting() {
        try {
            routeLocator.manualRefresh();
        } catch (Exception e) {
            log.warn("路由配置信息配置失败。", e);
        }
        return JsonResult.success("刷新配置成功");
    }

    @PostConstruct
    public void init() {
        routeLocator.manualRefresh();
    }

}
