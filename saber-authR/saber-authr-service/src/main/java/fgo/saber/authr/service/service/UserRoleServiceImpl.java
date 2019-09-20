package fgo.saber.authr.service.service;

import fgo.saber.authr.service.dao.UserRoleMapper;
import fgo.saber.authr.service.model.entity.UserRole;
import fgo.saber.authr.service.model.param.UserRoleParam;
import fgo.saber.common.abst.AbstBaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;

/**
 * @author zq
 * @date 2019/9/19
 */
@Service
public class UserRoleServiceImpl extends AbstBaseService<UserRole> {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public Mapper<UserRole> getDao() {
        return userRoleMapper;
    }

    @Transactional(rollbackFor = Exception.class)
    public void save(UserRoleParam userRoleParam) {
        //删除之前的关系
        userRoleMapper.delete(UserRole.builder()
                .userId(userRoleParam.getUserId())
                .build());
        if (StringUtils.isBlank(userRoleParam.getRoleIds())) {
            return;
        }
        String[] roleIds = userRoleParam.getRoleIds().split(",");
        for (String roleId : roleIds) {
            UserRole userRole = UserRole.builder()
                    .userId(userRoleParam.getUserId())
                    .roleId(Long.valueOf(roleId))
                    .createTime(new Date())
                    .updateTime(new Date())
                    .build();
            userRoleMapper.insertSelective(userRole);
        }
    }
}
