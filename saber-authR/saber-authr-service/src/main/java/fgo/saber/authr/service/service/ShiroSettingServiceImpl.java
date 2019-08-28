package fgo.saber.authr.service.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import fgo.saber.authr.service.common.AuthResultStatus;
import fgo.saber.authr.service.dao.AppShiroSettingMapper;
import fgo.saber.authr.service.model.entity.AppInfo;
import fgo.saber.authr.service.model.entity.AppShiroSetting;
import fgo.saber.authr.service.model.param.PageParam;
import fgo.saber.authr.service.model.param.ShiroSettingParam;
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
public class ShiroSettingServiceImpl extends AbstBaseService<AppShiroSetting> {

    @Autowired
    private AppShiroSettingMapper appShiroSettingMapper;

    @Override
    public Mapper<AppShiroSetting> getDao() {
        return appShiroSettingMapper;
    }

    public PageInfo<AppShiroSetting> findShiroSettingList(ShiroSettingParam settingParam, PageParam pageParam) {
        String orderStr = pageParam.sortStr();
        if (StringUtils.isAnyBlank(pageParam.getSortKey(), pageParam.getSortValue())) {
            //默认根据时间排序
            orderStr = "create_time desc";
        }
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), orderStr);

        Example.Builder example = Example.builder(AppInfo.class);

        if (StringUtils.isNotBlank(settingParam.getShiroPath())) {
            example.andWhere(Sqls.custom().andLike("shiroPath", "%" + settingParam.getShiroPath() + "%"));
        }
        if (StringUtils.isNotBlank(settingParam.getShiroAuth())) {
            example.andWhere(Sqls.custom().andLike("shiroAuth", "%" + settingParam.getShiroAuth() + "%"));
        }

        return new PageInfo<>(appShiroSettingMapper.selectByExample(example.build()));
    }

    public void save(ShiroSettingParam shiroSettingParam) {
        if (shiroSettingParam.getSettingId() == null) {
            AppShiroSetting shiroSetting = new AppShiroSetting();
            BeanUtil.overWrite(shiroSettingParam, shiroSetting);
            shiroSetting.setCreateTime(new Date());
            shiroSetting.setUpdateTime(new Date());
            appShiroSettingMapper.insertSelective(shiroSetting);
        } else {
            AppShiroSetting shiroSetting = appShiroSettingMapper.selectByPrimaryKey(shiroSettingParam.getSettingId());
            SbPreconditions.checkNotNull(shiroSetting, AuthResultStatus.APP_NOT_EXIST);
            BeanUtil.overWrite(shiroSettingParam, shiroSetting);
            shiroSetting.setUpdateTime(new Date());
            appShiroSettingMapper.updateByPrimaryKeySelective(shiroSetting);
        }

    }
}
