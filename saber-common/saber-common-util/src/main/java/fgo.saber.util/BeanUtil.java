package fgo.saber.util;

import fgo.saber.util.exception.CommonUtilException;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * @author zq
 * @Date 2018/9/11
 */
public class BeanUtil {

    public static <T> T copy(Object source, Class<T> classType) {
        T entity;
        try {
            entity = classType.getConstructor(new Class[] {}).newInstance();
            PropertyUtils.copyProperties(entity, source);
        } catch (Exception e) {
            throw new CommonUtilException("对象转化时发生一个异常", e);
        }
        return entity;

    }

}
