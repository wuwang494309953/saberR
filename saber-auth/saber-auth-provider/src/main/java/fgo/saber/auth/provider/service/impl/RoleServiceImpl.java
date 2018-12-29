package fgo.saber.auth.provider.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import fgo.saber.auth.api.param.PageParam;
import fgo.saber.auth.api.param.RoleParam;
import fgo.saber.auth.provider.dao.RoleMapper;
import fgo.saber.auth.provider.model.entity.Role;
import fgo.saber.common.abst.AbstBaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author zq
 * @date 2018/10/23
 */
@Service
public class RoleServiceImpl extends AbstBaseService<Role>  {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Mapper<Role> getDao() {
        return roleMapper;
    }

    public PageInfo<Role> findRoleList(RoleParam roleParam, PageParam pageParam) {
        String orderStr = pageParam.sortStr();
        if (StringUtils.isAnyBlank(pageParam.getSortKey(), pageParam.getSortValue())) {
            //默认根据时间排序
            orderStr = "operate_time desc";
        }
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), orderStr);
        return new PageInfo<>(roleMapper.findRoleList(roleParam));
    }
}
