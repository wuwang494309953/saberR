package fgo.saber.auth.provider.service.impl;

import fgo.saber.auth.provider.dao.AppInfoMapper;
import fgo.saber.auth.provider.model.entity.AppInfo;
import fgo.saber.common.abst.AbstBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author zq
 * @date 2019/8/2
 */
@Service
public class AppInfoServiceImpl extends AbstBaseService<AppInfo> {

    @Autowired
    private AppInfoMapper appInfoMapper;

    @Override
    public Mapper<AppInfo> getDao() {
        return appInfoMapper;
    }

}
