package fgo.saber.util;

import com.google.common.collect.Lists;
import fgo.saber.util.exception.CommonUtilException;
import org.apache.commons.beanutils.PropertyUtils;

import java.util.List;

/**
 * @author zq
 * @Date 2018/9/11
 */
public class BeanUtil {

    public static <D, E> D copy(E source, Class<D> clazz) {
        if (source == null) {
            return null;
        }
        D dto;
        try {
            dto = clazz.getConstructor(new Class[] {}).newInstance();
            PropertyUtils.copyProperties(dto, source);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CommonUtilException("对象转化时发生一个异常", e);
        }
        return dto;
    }

    public static <D, E> List<D> copyList(List<E> sources, Class<D> clazz) {
        List<D> result = Lists.newLinkedList();
        sources.forEach(item -> result.add(BeanUtil.copy(item, clazz)));
        return result;
    }

    /*public static <T> T copy(Object source, Class<T> classType) {
        if (source == null) {
            return null;
        }
        T entity;
        try {
            entity = classType.getConstructor(new Class[] {}).newInstance();
            PropertyUtils.copyProperties(entity, source);
        } catch (Exception e) {
            throw new CommonUtilException("对象转化时发生一个异常", e);
        }
        return entity;

    }*/

    /*public static <T> List<T> copyList(List sources, Class<T> classType) {
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
    }*/

}
