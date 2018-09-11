package fgo.saber.util;

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
            BeanUtils.copyProperties(source, entity);
        } catch (Exception e) {
            throw new CommonBeanException("对象转化时发生一个异常", e);
        }
        return entity;

    }

}
