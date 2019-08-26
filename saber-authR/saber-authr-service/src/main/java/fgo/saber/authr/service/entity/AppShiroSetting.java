package fgo.saber.authr.service.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`app_shiro_setting`")
public class AppShiroSetting {
    /**
     * 配置id
     */
    @Id
    @Column(name = "`setting_id`")
    private Long settingId;

    /**
     * appId
     */
    @Column(name = "`app_id`")
    private Long appId;

    /**
     * shiro的权限eg.(/test/*,/**)这样的路径
     */
    @Column(name = "`shiro_path`")
    private String shiroPath;

    /**
     * shiro中的权限。eg(authc,anon)
     */
    @Column(name = "`shiro_auth`")
    private String shiroAuth;

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
     * 获取配置id
     *
     * @return setting_id - 配置id
     */
    public Long getSettingId() {
        return settingId;
    }

    /**
     * 设置配置id
     *
     * @param settingId 配置id
     */
    public void setSettingId(Long settingId) {
        this.settingId = settingId;
    }

    /**
     * 获取appId
     *
     * @return app_id - appId
     */
    public Long getAppId() {
        return appId;
    }

    /**
     * 设置appId
     *
     * @param appId appId
     */
    public void setAppId(Long appId) {
        this.appId = appId;
    }

    /**
     * 获取shiro的权限eg.(/test/*,/**)这样的路径
     *
     * @return shiro_path - shiro的权限eg.(/test/*,/**)这样的路径
     */
    public String getShiroPath() {
        return shiroPath;
    }

    /**
     * 设置shiro的权限eg.(/test/*,/**)这样的路径
     *
     * @param shiroPath shiro的权限eg.(/test/*,/**)这样的路径
     */
    public void setShiroPath(String shiroPath) {
        this.shiroPath = shiroPath == null ? null : shiroPath.trim();
    }

    /**
     * 获取shiro中的权限。eg(authc,anon)
     *
     * @return shiro_auth - shiro中的权限。eg(authc,anon)
     */
    public String getShiroAuth() {
        return shiroAuth;
    }

    /**
     * 设置shiro中的权限。eg(authc,anon)
     *
     * @param shiroAuth shiro中的权限。eg(authc,anon)
     */
    public void setShiroAuth(String shiroAuth) {
        this.shiroAuth = shiroAuth == null ? null : shiroAuth.trim();
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