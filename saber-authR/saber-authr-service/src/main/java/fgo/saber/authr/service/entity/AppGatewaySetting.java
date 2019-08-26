package fgo.saber.authr.service.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "`app_gateway_setting`")
public class AppGatewaySetting {
    /**
     * 网关id
     */
    @Id
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

    /**
     * 获取网关id
     *
     * @return gateway_id - 网关id
     */
    public Long getGatewayId() {
        return gatewayId;
    }

    /**
     * 设置网关id
     *
     * @param gatewayId 网关id
     */
    public void setGatewayId(Long gatewayId) {
        this.gatewayId = gatewayId;
    }

    /**
     * @return app_id
     */
    public Long getAppId() {
        return appId;
    }

    /**
     * @param appId
     */
    public void setAppId(Long appId) {
        this.appId = appId;
    }

    /**
     * 获取SpringCloud的serviceId,网关转发需要
     *
     * @return app_service_id - SpringCloud的serviceId,网关转发需要
     */
    public String getAppServiceId() {
        return appServiceId;
    }

    /**
     * 设置SpringCloud的serviceId,网关转发需要
     *
     * @param appServiceId SpringCloud的serviceId,网关转发需要
     */
    public void setAppServiceId(String appServiceId) {
        this.appServiceId = appServiceId == null ? null : appServiceId.trim();
    }

    /**
     * 获取网关path
     *
     * @return gateway_path - 网关path
     */
    public String getGatewayPath() {
        return gatewayPath;
    }

    /**
     * 设置网关path
     *
     * @param gatewayPath 网关path
     */
    public void setGatewayPath(String gatewayPath) {
        this.gatewayPath = gatewayPath == null ? null : gatewayPath.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}