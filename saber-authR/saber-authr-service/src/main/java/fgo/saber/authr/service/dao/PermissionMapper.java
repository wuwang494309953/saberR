package fgo.saber.authr.service.dao;

import fgo.saber.authr.service.model.entity.Permission;
import fgo.saber.authr.service.model.param.PermissionParam;
import fgo.saber.authr.service.model.vo.PermissionVO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PermissionMapper extends Mapper<Permission> {

    List<PermissionVO> getPermissionNav(PermissionParam permissionParam);

    List<Permission> findRolesWithAppAndRoleId(@Param("appId") Long appId, @Param("roleId") Long roleId);

    List<Permission> findRolesWithAppAndRoleIds(@Param("appId") Long appId, @Param("roleIds") List<Long> roleIds);
}