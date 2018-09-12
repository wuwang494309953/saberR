package fgo.saber.util;

import fgo.saber.util.exception.CommonUtilException;
import org.apache.commons.beanutils.PropertyUtils;

import java.util.LinkedList;
import java.util.List;

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

    public static <T> List<T> copyList(List<Object> sources, Class<T> classType) {
        List<T> result = new LinkedList<>();
        try {
            for (Object object : sources) {
                T entity = classType.getConstructor(new Class[]{}).newInstance();
                PropertyUtils.copyProperties(entity, object);
                result.add(entity);
            }
        }
        catch (Exception e) {
            throw new CommonUtilException("对象转化时发生一个异常", e);
        }
        return result;
    }

}
