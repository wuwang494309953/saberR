package fgo.saber.auth.controller.feign;

import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.codec.Encoder;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;

/**
 * @author zq
 * @date 2018/10/24
 */
@Slf4j
public class FgoFormEncoder implements Encoder {

    /*public FgoFormEncoder(ObjectFactory<HttpMessageConverters> messageConverters) {
        super(messageConverters);
    }*/

    @Override
    public void encode(Object o, Type type, RequestTemplate requestTemplate) throws EncodeException {
        log.info(o.toString());
    }

}
