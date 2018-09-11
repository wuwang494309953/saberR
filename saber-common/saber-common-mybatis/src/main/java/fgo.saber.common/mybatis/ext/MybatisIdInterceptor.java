package fgo.saber.common.mybatis.ext;

import fgo.saber.common.snowflake.SnowFlakeUtil;
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
public class MybatisIdInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        Object obj = args[1];
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            //设置属性为可以访问
            field.setAccessible(true);
            if (this.checkIsPrimaryKey(field) && field.get(obj) == null) {
                field.set(obj, SnowFlakeUtil.nextId());
            }
        }
        return invocation.proceed();
    }

    /**
     * 判断字段是否为主键
     * @param field
     * @return
     */
    private boolean checkIsPrimaryKey(Field field) {
        if (field.getType().equals(Long.class) && field.getAnnotation(MyId.class) != null) {
            return true;
        }
        return false;
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
