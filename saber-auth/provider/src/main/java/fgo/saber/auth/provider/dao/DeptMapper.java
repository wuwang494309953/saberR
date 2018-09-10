package fgo.saber.auth.provider.dao;

import fgo.saber.auth.provider.model.entity.Dept;

public interface DeptMapper {
    int deleteByPrimaryKey(Long deptId);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Long deptId);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
}