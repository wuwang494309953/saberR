package fgo.saber.authr.service.model.vo;

import fgo.saber.authr.service.model.entity.AppGatewaySetting;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zq
 * @date 2019/9/5
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AppGatewaySettingVO extends AppGatewaySetting {

    private String appName;

}
