package fgo.saber.authr.service.dao;

import fgo.saber.authr.service.model.entity.Role;
import fgo.saber.authr.service.model.param.RoleParam;
import fgo.saber.authr.service.model.vo.RoleVO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleMapper extends Mapper<Role> {

    List<RoleVO> getRoleNav(RoleParam param);

    List<Role> findRolesWithAppAndUserId(@Param("appId") Long appId, @Param("userId") Long userId);

}