package fgo.saber.auth.provider.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import fgo.saber.auth.api.dto.PermissionDto;
import fgo.saber.auth.api.param.PageParam;
import fgo.saber.auth.api.param.PermissionParam;
import fgo.saber.auth.provider.dao.PermissionMapper;
import fgo.saber.auth.provider.model.entity.Permission;
import fgo.saber.common.abst.AbstBaseService;
import fgo.saber.util.BeanUtil;
import fgo.saber.util.BeanValidator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

/**
 * @author zq
 * @date 2018/10/24
 */
@Service
public class PermissionServiceImpl extends AbstBaseService<Permission> {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public Mapper<Permission> getDao() {
        return permissionMapper;
    }

    public PageInfo<PermissionDto> findPermissionList(PermissionParam permissionParam, PageParam pageParam) {
        String orderStr = pageParam.sortStr("sp");
        if (StringUtils.isAnyBlank(pageParam.getSortKey(), pageParam.getSortValue())) {
            //默认根据时间排序
            orderStr = "sp.operate_time desc";
        }
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), orderStr);
        return new PageInfo<>(permissionMapper.findPermissionList(permissionParam));
    }

    public void save(PermissionParam permissionParam) {
        BeanValidator.check(permissionParam);
        if (permissionParam.getPermissionId() == null) {
            Permission permission = Permission.builder()
                    .permissionModuleId(permissionParam.getPermissionModuleId())
                    .name(permissionParam.getName())
                    .remark(permissionParam.getRemark())
                    .seq(permissionParam.getSeq())
                    .status(permissionParam.getStatus())
                    .type(permissionParam.getType())
                    .url(permissionParam.getUrl())
                    .operateIp("127.0.0.1")
                    .operateTime(new Date())
                    .operator("admin")
                    .build();
            permissionMapper.insertSelective(permission);
        } else {
            Permission permission = permissionMapper.selectByPrimaryKey(permissionParam.getPermissionId());
            Preconditions.checkNotNull(permission, "待更新权限不存在");
            BeanUtil.overWrite(permission, permissionParam);
            permissionMapper.updateByPrimaryKeySelective(permission);
        }
    }

    public List<Permission> findPermissionWithModuleId(Long permissionModuleId) {
        return permissionMapper.findPermissionWithModuleId(permissionModuleId);
    }

    public List<Permission> findPermissionWithUserId(Long userId) {
        return permissionMapper.findPermissionWithUserId(userId);
    }
}
