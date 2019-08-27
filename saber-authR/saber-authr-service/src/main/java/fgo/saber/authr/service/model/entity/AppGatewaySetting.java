package fgo.saber.authr.service.model.entity;

import fgo.saber.common.mybatis.ext.SnowFlakeId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "`app_gateway_setting`")
public class AppGatewaySetting {
    /**
     * 网关id
     */
    @Id
    @KeySql(genId = SnowFlakeId.class)
    @Column(name = "`gateway_id`")
    private Long gatewayId;

    @Column(name = "`app_id`")
    private Long appId;

    /**
     * SpringCloud的serviceId,网关转发需要
     */
    @Column(name = "`app_service_id`")
    private String appServiceId;

    /**
     * 网关path
     */
    @Column(name = "`gateway_path`")
    private String gatewayPath;

    /**
     * 创建时间
     */
    @Column(name = "`create_time`")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "`update_time`")
    private Date updateTime;

}