package fgo.saber.auth.provider.dao;

import fgo.saber.auth.api.param.RoleParam;
import fgo.saber.auth.provider.model.entity.Role;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleMapper extends Mapper<Role> {

    List<Role> findRoleList(RoleParam roleParam);

}