package fgo.saber.auth.provider.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import fgo.saber.auth.api.dto.DeptDto;
import fgo.saber.auth.api.param.DeptParam;
import fgo.saber.auth.provider.dao.DeptMapper;
import fgo.saber.auth.provider.model.entity.Dept;
import fgo.saber.common.abst.AbstBaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author zq
 * @Date 2018/9/11
 */
@Service
public class DeptServiceImpl extends AbstBaseService<Dept> {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public Mapper<Dept> getDao() {
        return deptMapper;
    }

    public PageInfo<DeptDto> findDeptList(DeptParam deptParam) {
        String orderStr = deptParam.sortStr("sd");
        if (StringUtils.isAnyBlank(deptParam.getSortKey(), deptParam.getSortValue())) {
            //默认根据时间排序
            orderStr = "sd.operate_time desc";
        }
        PageHelper.startPage(deptParam.getPageNum(), deptParam.getPageSize(), orderStr);
//        Example example = Example.builder(Dept.class).build();
//        Optional.ofNullable(deptParam.getName()).ifPresent(deptName -> example.and().andLike("name", "%" + deptName + "%"));
        return new PageInfo<>(deptMapper.findDeptDtoList(deptParam));
    }

    public List<DeptDto> getDeptsWithParentId(Long parentId) {
        return deptMapper.findDeptsWithParentId(parentId);
    }

    public List<Dept> getDeptFootWithDeptName(String deptName) {
        return deptMapper.getDeptFootWithDeptName(deptName);
    }

}
