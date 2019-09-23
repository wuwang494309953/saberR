package fgo.saber.authr.cloud.service.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class AppGatewaySettingDTO {
    /**
     * 网关id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)

    private Long gatewayId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long appId;

    /**
     * SpringCloud的serviceId,网关转发需要
     */
    private String appServiceId;

    /**
     * 网关path
     */
    private String gatewayPath;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}