package fgo.saber.auth.controller.feign;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.form.spring.SpringFormEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

/**
 * @author zq
 * @date 2019/2/20
 */
@Slf4j
public class SaberEncoder extends SpringFormEncoder {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public SaberEncoder(ObjectFactory<HttpMessageConverters> messageConverters) {
        super(new SpringEncoder(messageConverters));
    }

    @Override
    public void encode(Object requestBody, Type bodyType, RequestTemplate request) throws EncodeException {
        log.info(bodyType.getTypeName());
        if ("GET".equals(request.method()) && request.getClass().getName().startsWith("fgo.saber")) {
            JsonNode jsonNode = null;
            try {
                jsonNode = objectMapper.readTree(objectMapper.writeValueAsBytes(requestBody));
            } catch (IOException e) {
                e.printStackTrace();
            }
            //template.body(null);
            Map<String, Collection<String>> queries = new HashMap<>();
            //feign 不支持 GET 方法传 POJO, json body转query
            buildQuery(jsonNode, "", queries);
            request.queries(queries);
        }
        super.encode(requestBody, bodyType, request);
    }

    private void buildQuery(JsonNode jsonNode, String path, Map<String, Collection<String>> queries) {
        if (!jsonNode.isContainerNode()) { //叶子节点
            if (jsonNode.isNull()) {
                return;
            }
            Collection<String> values = queries.get(path);
            if (null == values) {
                values = new ArrayList<>();
                queries.put(path, values);
            }
            values.add(jsonNode.asText());
            return;
        }
        if (jsonNode.isArray()) { //数组节点
            Iterator<JsonNode> it = jsonNode.elements();
            while (it.hasNext()) {
                buildQuery(it.next(), path, queries);
            }
        } else {
            Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
            while (it.hasNext()) {
                Map.Entry<String, JsonNode> entry = it.next();
                if (StringUtils.hasText(path)) {
                    buildQuery(entry.getValue(), path + "." + entry.getKey(), queries);
                } else { //根节点
                    buildQuery(entry.getValue(), entry.getKey(), queries);
                }
            }
        }
    }
}
