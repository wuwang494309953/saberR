package fgo.saber.auth.controller.feign;

import feign.Logger;
import feign.codec.Encoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zq
 * @Date 2018/9/20
 */
@Configuration
public class SbFeignConfiguration {

    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

    @Bean
    public Logger.Level feignLoggerLevel() {
        return  Logger.Level.FULL;
    }

    @Bean
    public Encoder fgoEncoder() {
        return new FgoFormEncoder();
    }
}
