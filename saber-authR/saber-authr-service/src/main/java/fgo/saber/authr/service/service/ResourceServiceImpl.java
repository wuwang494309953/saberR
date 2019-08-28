package fgo.saber.authr.service.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import fgo.saber.authr.service.common.AuthResultStatus;
import fgo.saber.authr.service.dao.ResourceMapper;
import fgo.saber.authr.service.model.entity.Resource;
import fgo.saber.authr.service.model.param.PageParam;
import fgo.saber.authr.service.model.param.ResourceParam;
import fgo.saber.common.abst.AbstBaseService;
import fgo.saber.util.BeanUtil;
import fgo.saber.util.SbPreconditions;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.Date;

/**
 * @author zq
 * @date 2019/8/28
 */
@Service
public class ResourceServiceImpl extends AbstBaseService<Resource> {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public Mapper<Resource> getDao() {
        return resourceMapper;
    }

    public PageInfo<Resource> findResourceList(ResourceParam resourceParam, PageParam pageParam) {
        String orderStr = pageParam.sortStr();
        if (StringUtils.isAnyBlank(pageParam.getSortKey(), pageParam.getSortValue())) {
            //默认根据时间排序
            orderStr = "create_time desc";
        }
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), orderStr);

        Example.Builder example = Example.builder(Resource.class);

        if (StringUtils.isNotBlank(resourceParam.getResourceName())) {
            example.andWhere(Sqls.custom().andLike("resourceName", "%" + resourceParam.getResourceName() + "%"));
        }

        if (StringUtils.isNotBlank(resourceParam.getResourceValue())) {
            example.andWhere(Sqls.custom().andLike("resourceValue", "%" + resourceParam.getResourceValue() + "%"));
        }

        if (resourceParam.getRoleId() != null) {
            example.andWhere(Sqls.custom().andEqualTo("roleId", resourceParam.getRoleId()));
        }

        return new PageInfo<>(resourceMapper.selectByExample(example.build()));
    }

    public void save(ResourceParam resourceParam) {
        if (resourceParam.getResourceId() == null) {
            Resource resource = new Resource();
            BeanUtil.overWrite(resourceParam, resource);
            resource.setCreateTime(new Date());
            resource.setUpdateTime(new Date());
            resourceMapper.insertSelective(resource);
        } else {
            Resource resource = resourceMapper.selectByPrimaryKey(resourceParam.getResourceId());
            SbPreconditions.checkNotNull(resource, AuthResultStatus.RESOURCE_NOT_EXIST);
            BeanUtil.overWrite(resourceParam, resource);
            resource.setUpdateTime(new Date());
            resourceMapper.updateByPrimaryKeySelective(resource);
        }

    }

}
