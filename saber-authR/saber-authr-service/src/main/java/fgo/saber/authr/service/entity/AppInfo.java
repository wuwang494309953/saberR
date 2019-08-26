package fgo.saber.authr.service.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`app_info`")
public class AppInfo {
    @Id
    @Column(name = "`app_id`")
    private Long appId;

    /**
     * app名字
     */
    @Column(name = "`app_name`")
    private String appName;

    /**
     * SpringCloud的serviceId,网关转发需要
     */
    @Column(name = "`app_service_id`")
    private String appServiceId;

    /**
     * app秘钥
     */
    @Column(name = "`app_secret`")
    private String appSecret;

    /**
     * 描述
     */
    @Column(name = "`app_desc`")
    private String appDesc;

    /**
     * 0-无效，1-有效
     */
    @Column(name = "`status`")
    private Byte status;

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
     * 获取app名字
     *
     * @return app_name - app名字
     */
    public String getAppName() {
        return appName;
    }

    /**
     * 设置app名字
     *
     * @param appName app名字
     */
    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
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
     * 获取app秘钥
     *
     * @return app_secret - app秘钥
     */
    public String getAppSecret() {
        return appSecret;
    }

    /**
     * 设置app秘钥
     *
     * @param appSecret app秘钥
     */
    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret == null ? null : appSecret.trim();
    }

    /**
     * 获取描述
     *
     * @return app_desc - 描述
     */
    public String getAppDesc() {
        return appDesc;
    }

    /**
     * 设置描述
     *
     * @param appDesc 描述
     */
    public void setAppDesc(String appDesc) {
        this.appDesc = appDesc == null ? null : appDesc.trim();
    }

    /**
     * 获取0-无效，1-有效
     *
     * @return status - 0-无效，1-有效
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置0-无效，1-有效
     *
     * @param status 0-无效，1-有效
     */
    public void setStatus(Byte status) {
        this.status = status;
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