package fgo.saber.auth.provider.dao;

import fgo.saber.auth.provider.model.entity.UserRole;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Long userRoleId);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Long userRoleId);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}