package fgo.saber.authr.service.service;

import fgo.saber.authr.service.dao.RolePermissionMapper;
import fgo.saber.authr.service.model.entity.RolePermission;
import fgo.saber.authr.service.model.param.RolePermissionParam;
import fgo.saber.common.abst.AbstBaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;

/**
 * @author zq
 * @date 2019/9/20
 */
@Service
public class RolePermissionServiceImpl extends AbstBaseService<RolePermission> {

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public Mapper<RolePermission> getDao() {
        return rolePermissionMapper;
    }

    @Transactional(rollbackFor = Exception.class)
    public void save(RolePermissionParam param) {
        //删除之前的关系
        rolePermissionMapper.delete(RolePermission.builder()
                .roleId(param.getRoleId())
                .build());
        if (StringUtils.isBlank(param.getPermissionIds())) {
            return;
        }
        String[] permissionIds = param.getPermissionIds().split(",");
        for (String permissionId : permissionIds) {
            RolePermission rolePermission = RolePermission.builder()
                    .roleId(param.getRoleId())
                    .permissionId(Long.valueOf(permissionId))
                    .createTime(new Date())
                    .updateTime(new Date())
                    .build();
            rolePermissionMapper.insertSelective(rolePermission);
        }
    }

}
