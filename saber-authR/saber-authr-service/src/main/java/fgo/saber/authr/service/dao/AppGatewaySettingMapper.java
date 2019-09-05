package fgo.saber.authr.service.dao;

import fgo.saber.authr.service.model.entity.AppGatewaySetting;
import fgo.saber.authr.service.model.param.GatewaySettingParam;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AppGatewaySettingMapper extends Mapper<AppGatewaySetting> {

    List<AppGatewaySetting> getAppGatewaySettingNav(GatewaySettingParam gatewaySettingParam);

}