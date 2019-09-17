package fgo.saber.authr.service.model.vo;

import fgo.saber.authr.service.model.entity.AppShiroSetting;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zq
 * @date 2019/9/17
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AppShiroSettingVO extends AppShiroSetting {

    private String appName;

}
