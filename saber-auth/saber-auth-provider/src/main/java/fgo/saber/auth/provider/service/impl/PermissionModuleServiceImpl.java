package fgo.saber.auth.provider.service.impl;

import fgo.saber.auth.provider.dao.PermissionModuleMapper;
import fgo.saber.auth.provider.model.entity.PermissionModule;
import fgo.saber.common.abst.AbstBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author zq
 * @date 2018/10/24
 */
@Service
public class PermissionModuleServiceImpl extends AbstBaseService<PermissionModule> {

    @Autowired
    private PermissionModuleMapper permissionModuleMapper;

    @Override
    public Mapper<PermissionModule> getDao() {
        return permissionModuleMapper;
    }

    public List<PermissionModule> findPermissionModuleWithRoleId(Long roleId) {
        return permissionModuleMapper.findPermissionModuleWithRoleId(roleId);
    }

    public List<PermissionModule> findPermissionModuleWithParentId(Long parentId) {
        return permissionModuleMapper.findPermissionModuleWithParentId(parentId);
    }
}
