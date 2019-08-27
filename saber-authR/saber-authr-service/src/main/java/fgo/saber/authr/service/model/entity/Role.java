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
@Table(name = "`role`")
public class Role {

    @Id
    @KeySql(genId = SnowFlakeId.class)
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

}