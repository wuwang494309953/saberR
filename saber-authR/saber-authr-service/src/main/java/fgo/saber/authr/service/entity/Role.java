package fgo.saber.authr.service.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`role`")
public class Role {
    @Id
    @Column(name = "`role_id`")
    private Long roleId;

    /**
     * appId
     */
    @Column(name = "`app_id`")
    private Long appId;

    /**
     * 角色名
     */
    @Column(name = "`role_name`")
    private String roleName;

    /**
     * 备注
     */
    @Column(name = "`remark`")
    private String remark;

    /**
     * 0-正常，1-删除
     */
    @Column(name = "`status`")
    private Integer status;

    /**
     * 1-普通用户，2-管理员
     */
    @Column(name = "`type`")
    private Integer type;

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
     * @return role_id
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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
     * 获取角色名
     *
     * @return role_name - 角色名
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名
     *
     * @param roleName 角色名
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取0-正常，1-删除
     *
     * @return status - 0-正常，1-删除
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0-正常，1-删除
     *
     * @param status 0-正常，1-删除
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取1-普通用户，2-管理员
     *
     * @return type - 1-普通用户，2-管理员
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置1-普通用户，2-管理员
     *
     * @param type 1-普通用户，2-管理员
     */
    public void setType(Integer type) {
        this.type = type;
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