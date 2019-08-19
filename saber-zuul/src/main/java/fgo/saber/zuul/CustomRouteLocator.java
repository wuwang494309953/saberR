package fgo.saber.zuul;

import com.google.common.collect.Maps;
import org.springframework.cloud.netflix.zuul.filters.RefreshableRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

import java.util.Map;

/**
 * @author zq
 * @date 2019/8/16
 */
public class CustomRouteLocator extends SimpleRouteLocator implements RefreshableRouteLocator {

    public CustomRouteLocator(String servletPath, ZuulProperties properties) {
        super(servletPath, properties);
    }

    @Override
    protected Map<String, ZuulProperties.ZuulRoute> locateRoutes() {
        Map<String, ZuulProperties.ZuulRoute> routeMap = Maps.newHashMap();

        ZuulProperties.ZuulRoute route = new ZuulProperties.ZuulRoute();
        route.setPath("/saber-auth/**");
        route.setServiceId("saber-auth-provider");
        route.setId("saber-auth");
        routeMap.put(route.getPath(), route);

        return routeMap;
    }

    @Override
    public void refresh() {
        doRefresh();
    }
}
