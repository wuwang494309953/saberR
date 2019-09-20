package fgo.saber.authr.service.dao;

import fgo.saber.authr.service.model.entity.Permission;
import fgo.saber.authr.service.model.param.PermissionParam;
import fgo.saber.authr.service.model.vo.PermissionVO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PermissionMapper extends Mapper<Permission> {

    List<PermissionVO> getPermissionNav(PermissionParam permissionParam);

    List<Permission> findRolesWithAppAndUserId(@Param("appId") Long appId, @Param("roleId") Long roleId);

}