package fgo.saber.authr.service.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import fgo.saber.authr.service.common.AuthResultStatus;
import fgo.saber.authr.service.dao.AppInfoMapper;
import fgo.saber.authr.service.model.entity.AppInfo;
import fgo.saber.authr.service.model.param.AppInfoParam;
import fgo.saber.authr.service.model.param.PageParam;
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
 * @date 2019/8/27
 */
@Service
public class AppInfoServiceImpl extends AbstBaseService<AppInfo> {

    @Autowired
    private AppInfoMapper appInfoMapper;

    @Override
    public Mapper<AppInfo> getDao() {
        return appInfoMapper;
    }

    public PageInfo<AppInfo> findAppInfoList(AppInfoParam appInfoParam, PageParam pageParam) {
        String orderStr = pageParam.sortStr();
        if (StringUtils.isAnyBlank(pageParam.getSortKey(), pageParam.getSortValue())) {
            //默认根据时间排序
            orderStr = "create_time desc";
        }
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), orderStr);

        Example.Builder example = Example.builder(AppInfoParam.class);

        if (StringUtils.isNotBlank(appInfoParam.getAppName())) {
            example.andWhere(Sqls.custom().andLike("appName", "%" + appInfoParam.getAppName() + "%"));
        }
        if (StringUtils.isNotBlank(appInfoParam.getAppDesc())) {
            example.andWhere(Sqls.custom().andLike("appDesc", "%" + appInfoParam.getAppDesc() + "%"));
        }
       if (appInfoParam.getStatus() == null) {
           appInfoParam.setStatus(1);
       }
        example.andWhere(Sqls.custom().andEqualTo("status", appInfoParam.getStatus()));
        return new PageInfo<>(appInfoMapper.selectByExample(example.build()));
    }

    public void save(AppInfoParam appInfoParam) {
        if (appInfoParam.getAppId() == null) {
            AppInfo appInfo = new AppInfo();
            BeanUtil.overWrite(appInfoParam, appInfo);
            appInfo.setCreateTime(new Date());
            appInfo.setUpdateTime(new Date());
            appInfoMapper.insertSelective(appInfo);
        } else {
            AppInfo appInfo = appInfoMapper.selectByPrimaryKey(appInfoParam.getAppId());
            SbPreconditions.checkNotNull(appInfo, AuthResultStatus.APP_NOT_EXIST);
            BeanUtil.overWrite(appInfoParam, appInfo);
            appInfo.setUpdateTime(new Date());
            appInfoMapper.updateByPrimaryKeySelective(appInfo);
        }

    }

}
