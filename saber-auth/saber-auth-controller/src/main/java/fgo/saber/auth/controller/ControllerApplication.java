package fgo.saber.auth.controller;

import fgo.saber.auth.controller.feign.SbFeignConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@SpringBootApplication(scanBasePackages = {"fgo.saber.auth.controller", "fgo.saber.commom.shiro"})
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "fgo.saber.auth.api.cloudservice", defaultConfiguration = SbFeignConfiguration.class)
public class ControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControllerApplication.class, args);
    }
}
