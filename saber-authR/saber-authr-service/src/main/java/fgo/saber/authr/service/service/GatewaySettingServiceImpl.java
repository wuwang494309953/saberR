package fgo.saber.authr.service.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import fgo.saber.authr.service.common.AuthResultStatus;
import fgo.saber.authr.service.dao.AppGatewaySettingMapper;
import fgo.saber.authr.service.model.entity.AppGatewaySetting;
import fgo.saber.authr.service.model.param.GatewaySettingParam;
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
public class GatewaySettingServiceImpl extends AbstBaseService<AppGatewaySetting> {

    @Autowired
    private AppGatewaySettingMapper appGatewaySettingMapper;

    @Override
    public Mapper getDao() {
        return appGatewaySettingMapper;
    }

    public PageInfo<AppGatewaySetting> findSettingList(GatewaySettingParam gatewaySettingParam, PageParam pageParam) {
        String orderStr = pageParam.sortStr();
        if (StringUtils.isAnyBlank(pageParam.getSortKey(), pageParam.getSortValue())) {
            //默认根据时间排序
            orderStr = "create_time desc";
        }
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), orderStr);

        Example.Builder example = Example.builder(AppGatewaySetting.class);

        if (StringUtils.isNotBlank(gatewaySettingParam.getAppServiceId())) {
            example.andWhere(Sqls.custom().andLike("appServiceId", "%" + gatewaySettingParam.getAppServiceId() + "%"));
        }
        if (StringUtils.isNotBlank(gatewaySettingParam.getGatewayPath())) {
            example.andWhere(Sqls.custom().andLike("gatewayPath", "%" + gatewaySettingParam.getGatewayPath() + "%"));
        }
        if (gatewaySettingParam.getAppId() != null) {
            example.andWhere(Sqls.custom().andEqualTo("appId", gatewaySettingParam.getAppId()));
        }

        return new PageInfo<>(appGatewaySettingMapper.selectByExample(example.build()));
    }

    public void save(GatewaySettingParam gatewaySettingParam) {
        if (gatewaySettingParam.getGatewayId() == null) {
            AppGatewaySetting appGatewaySetting = new AppGatewaySetting();
            BeanUtil.overWrite(gatewaySettingParam, appGatewaySetting);
            appGatewaySetting.setCreateTime(new Date());
            appGatewaySetting.setUpdateTime(new Date());

            appGatewaySettingMapper.insertSelective(appGatewaySetting);
        } else {
            AppGatewaySetting appGatewaySetting = appGatewaySettingMapper.selectByPrimaryKey(gatewaySettingParam.getGatewayId());
            SbPreconditions.checkNotNull(appGatewaySetting, AuthResultStatus.GATEWAY_NOT_EXIST);
            BeanUtil.overWrite(gatewaySettingParam, appGatewaySetting);
            appGatewaySetting.setUpdateTime(new Date());
            appGatewaySettingMapper.updateByPrimaryKeySelective(appGatewaySetting);
        }

    }
}
