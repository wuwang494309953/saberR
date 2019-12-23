package fgo.saber.zuul;

import com.google.common.collect.Maps;
import fgo.saber.authr.cloud.service.AppGatewaySettingCloudService;
import fgo.saber.authr.cloud.service.DTO.AppGatewaySettingDTO;
import fgo.saber.base.json.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.RefreshableRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zq
 * @date 2019/8/16
 */
@Slf4j
public class CustomRouteLocator extends SimpleRouteLocator implements RefreshableRouteLocator {

    @Autowired
    private AppGatewaySettingCloudService appGatewaySettingCloudService;

    private static final ScheduledExecutorService SCHEDULED_EXECUTOR_SERVICE = Executors.newSingleThreadScheduledExecutor();

    public void init() {
        initScheduled();
    }

    public CustomRouteLocator(String servletPath, ZuulProperties properties) {
        super(servletPath, properties);
    }

    @Override
    protected Map<String, ZuulProperties.ZuulRoute> locateRoutes() {
        Map<String, ZuulProperties.ZuulRoute> routeMap = Maps.newLinkedHashMap();

        ZuulProperties.ZuulRoute route = new ZuulProperties.ZuulRoute();
        route.setPath("/v1/saberAuth/**");
        route.setServiceId("saber-authr-service");
        route.setId("saber-authr");
        routeMap.put(route.getPath(), route);

        ZuulProperties.ZuulRoute route1 = new ZuulProperties.ZuulRoute();
        route1.setPath("/v1/gateway/**");
        route1.setServiceId("saber-zuul");
        route1.setId("saber-zuul");
        routeMap.put(route1.getPath(), route1);

        if (zuulRouterMap != null) {
            routeMap.putAll(zuulRouterMap);
        }

        return routeMap;
    }

    private volatile Map<String, ZuulProperties.ZuulRoute> zuulRouterMap;

    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void refresh() {
        doRefresh();
    }

    public void initScheduled() {
        SCHEDULED_EXECUTOR_SERVICE.scheduleAtFixedRate(() -> manualRefresh(), 10, 10, TimeUnit.SECONDS);
    }

    public void manualRefresh() {
        lock.lock();
//        zuulRouterMap.hashCode()
        try {
            Map<String, ZuulProperties.ZuulRoute> settingMap = this.getSettingMap();
            if (this.zuulRouterMap == null || !this.zuulRouterMap.equals(settingMap)) {
                this.zuulRouterMap = settingMap;
                doRefresh();
            }
        } catch (Exception e) {
            log.error("路由配置刷新失败", e);
        } finally {
            lock.unlock();
        }

    }

    private Map<String, ZuulProperties.ZuulRoute> getSettingMap() {
        Map<String, ZuulProperties.ZuulRoute> routeMap = Maps.newHashMap();

        JsonResult<List<AppGatewaySettingDTO>> result = appGatewaySettingCloudService.all();
        if (result.getCode() != 0) {
            return routeMap;
        }

        List<AppGatewaySettingDTO> gatewaySettingDTOS = result.getData();
        for (AppGatewaySettingDTO appGatewaySettingDTO : gatewaySettingDTOS) {
            ZuulProperties.ZuulRoute temp = new ZuulProperties.ZuulRoute();
            temp.setPath(appGatewaySettingDTO.getGatewayPath());
            temp.setServiceId(appGatewaySettingDTO.getAppServiceId());
            temp.setId(String.valueOf(appGatewaySettingDTO.getGatewayId()));
            routeMap.put(temp.getPath(), temp);
        }

        return routeMap;
    }
}
