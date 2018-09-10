package fgo.saber.auth.provider.dao;

import fgo.saber.auth.provider.model.entity.RolePermission;

public interface RolePermissionMapper {
    int deleteByPrimaryKey(Long rolePermissionId);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(Long rolePermissionId);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);
}