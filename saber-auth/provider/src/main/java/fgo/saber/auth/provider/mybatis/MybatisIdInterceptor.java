package fgo.saber.auth.provider.mybatis;

import fgo.saber.common.snowflake.SnowFlakeUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.lang.reflect.Field;
import java.util.Properties;

/**
 * @author zq
 * @Date 2018/9/10
 */
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class })
})
@Slf4j
public class MybatisIdInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        log.info("接收参数: {}", args);
        Object obj = args[1];
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            //设置属性为可以访问
            field.setAccessible(true);
            if (field.getType().equals(Long.class) && field.get(obj) == null) {
                MyId myId = field.getAnnotation(MyId.class);
                if (myId != null) {
                    field.set(obj, SnowFlakeUtil.nextId());
                }
            }
            log.info("key = {}, value = {}",field.getName(), field.get(obj));
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
