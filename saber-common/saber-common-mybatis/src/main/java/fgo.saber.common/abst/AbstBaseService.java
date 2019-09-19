package fgo.saber.common.abst;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author zq
 * @Date 2018/9/11
 */
public abstract class AbstBaseService<T> {

    /**
     * 抽象方法，必须实现，返回DAO实例
     *
     * @return DAO实例
     */
    public abstract Mapper<T> getDao();

    public int insert(T t) {
        return getDao().insert(t);
    }

    public int insertSelective(T t) {
        return getDao().insertSelective(t);
    }

    public T selectByPrimaryKey(Object id) {
        return getDao().selectByPrimaryKey(id);
    }

    public List<T> select(T t) {
        return getDao().select(t);
    }

    public List<T> selectAll() {
        return getDao().selectAll();
    }

    public int delete(T t) {
        return getDao().delete(t);
    }

    public int deleteByPrimaryKey(Object id) {
        return getDao().deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKey(T t) {
        return getDao().updateByPrimaryKey(t);
    }

    public int updateByPrimaryKeySelective(T t) {
        return getDao().updateByPrimaryKeySelective(t);
    }

}
