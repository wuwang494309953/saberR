package fgo.saber.auth.controller.feign;

import feign.Feign;
import feign.Logger;
import feign.Retryer;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import feign.querymap.BeanQueryMapEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author zq
 * @Date 2018/9/20
 */
@Configuration
public class SbFeignConfiguration {

    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

//
//    @PostConstruct
//    public void initFeign() {
////        messageConverters.getObject().getConverters().add(0, new FormHttpMessageConverter());
//    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        return  Logger.Level.FULL;
    }

    /*@Bean
    public Decoder feignDecoder() {
        return new OptionalDecoder(new ResponseEntityDecoder(new SpringDecoder(this.messageConverters)));
    }*/

    /*@Bean
    public Encoder feignEncoder() {
        return new SaberEncoder(this.messageConverters);
    }*/

    @Bean
    @Primary
    public Encoder feignFormEncoder() {
        return new SpringFormEncoder(new SpringEncoder(messageConverters));
    }

    @Bean
    public Feign.Builder feignBuilder() {
        return Feign.builder()
                .queryMapEncoder(new BeanQueryMapEncoder())
                .retryer(Retryer.NEVER_RETRY);
    }

    /*@Bean
    public Encoder fgoEncoder() {
        return new FgoFormEncoder();
    }*/

}
