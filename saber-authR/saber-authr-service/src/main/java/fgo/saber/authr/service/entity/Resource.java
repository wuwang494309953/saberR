package fgo.saber.authr.service.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`resource`")
public class Resource {
    @Id
    @Column(name = "`resource_id`")
    private Long resourceId;

    /**
     * 角色id
     */
    @Column(name = "`role_id`")
    private Long roleId;

    /**
     * 资源名
     */
    @Column(name = "`resource_name`")
    private String resourceName;

    /**
     * 资源值
     */
    @Column(name = "`resource_value`")
    private String resourceValue;

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
     * @return resource_id
     */
    public Long getResourceId() {
        return resourceId;
    }

    /**
     * @param resourceId
     */
    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * 获取角色id
     *
     * @return role_id - 角色id
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置角色id
     *
     * @param roleId 角色id
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取资源名
     *
     * @return resource_name - 资源名
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * 设置资源名
     *
     * @param resourceName 资源名
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    /**
     * 获取资源值
     *
     * @return resource_value - 资源值
     */
    public String getResourceValue() {
        return resourceValue;
    }

    /**
     * 设置资源值
     *
     * @param resourceValue 资源值
     */
    public void setResourceValue(String resourceValue) {
        this.resourceValue = resourceValue == null ? null : resourceValue.trim();
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