package fgo.saber.auth.provider.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import fgo.saber.auth.api.param.PageParam;
import fgo.saber.auth.api.param.PermissionParam;
import fgo.saber.auth.provider.dao.PermissionMapper;
import fgo.saber.auth.provider.model.entity.Permission;
import fgo.saber.common.abst.AbstBaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

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

    public PageInfo<Permission> findPermissionList(PermissionParam permissionParam, PageParam pageParam) {
        String orderStr = pageParam.sortStr();
        if (StringUtils.isAnyBlank(pageParam.getSortKey(), pageParam.getSortValue())) {
            //默认根据时间排序
            orderStr = "operate_time desc";
        }
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), orderStr);
        return new PageInfo<>(permissionMapper.findPermissionList(permissionParam));
    }

    public List<Permission> findPermissionWithModuleId(Long permissionModuleId) {
        return permissionMapper.findPermissionWithModuleId(permissionModuleId);
    }

    public List<Permission> findPermissionWithUserId(Long userId) {
        return permissionMapper.findPermissionWithUserId(userId);
    }
}
