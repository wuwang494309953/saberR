package fgo.saber.authr.service.dao;

import fgo.saber.authr.service.model.entity.AppShiroSetting;
import fgo.saber.authr.service.model.param.ShiroSettingParam;
import fgo.saber.authr.service.model.vo.AppShiroSettingVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AppShiroSettingMapper extends Mapper<AppShiroSetting> {

    List<AppShiroSettingVO> getAppShiroSettingNav(ShiroSettingParam param);

}