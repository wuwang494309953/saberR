package fgo.saber.auth.provider.dao;

import fgo.saber.auth.provider.model.entity.PermissionModule;

public interface PermissionModuleMapper {
    int deleteByPrimaryKey(Long permissionModuleId);

    int insert(PermissionModule record);

    int insertSelective(PermissionModule record);

    PermissionModule selectByPrimaryKey(Long permissionModuleId);

    int updateByPrimaryKeySelective(PermissionModule record);

    int updateByPrimaryKey(PermissionModule record);
}