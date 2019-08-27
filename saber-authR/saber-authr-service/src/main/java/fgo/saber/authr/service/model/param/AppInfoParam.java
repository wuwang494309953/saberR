package fgo.saber.authr.service.model.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author zq
 * @date 2019/8/27
 */
@Data
public class AppInfoParam {

    private Long appId;

    @NotBlank(message = "appName不能为空")
    private String appName;

    private String appDesc;

    @NotNull(message = "status不能为空")
    private Integer status;

}
