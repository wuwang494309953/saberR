package fgo.saber.zuul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"fgo.saber.zuul", "fgo.saber.shiro"})
@EnableZuulProxy
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "fgo.saber.authr.cloud.service")
public class ZuulApplication {

    @Autowired
    private ZuulProperties zuulProperties;

    @Autowired
    private ServerProperties server;

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

    @Bean(initMethod = "init")
    public CustomRouteLocator routeLocator() {
        return new CustomRouteLocator("", this.zuulProperties);
    }
}
