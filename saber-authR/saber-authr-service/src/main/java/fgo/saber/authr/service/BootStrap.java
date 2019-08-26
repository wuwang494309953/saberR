package fgo.saber.authr.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author zq
 * @date 2019/8/17
 */
@SpringBootApplication
@MapperScan("fgo.saber.authr.service.dao")
public class BootStrap {

    public static void main(String[] args) {
        SpringApplication.run(BootStrap.class, args);
    }

}
