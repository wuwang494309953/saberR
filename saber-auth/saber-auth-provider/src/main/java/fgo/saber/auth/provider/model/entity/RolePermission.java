package fgo.saber.auth.provider.model.entity;

import fgo.saber.common.mybatis.ext.SnowFlakeId;
import lombok.Builder;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import java.util.Date;
import javax.persistence.*;

@Data
@Builder
@Table(name = "`sb_role_permission`")
public class RolePermission {
    @Id
    @KeySql(genId = SnowFlakeId.class)
    @Column(name = "`role_permission_id`")
    private Long rolePermissionId;

    @Column(name = "`role_id`")
    private Long roleId;

    @Column(name = "`permission_id`")
    private Long permissionId;

    @Column(name = "`operate_ip`")
    private String operateIp;

    @Column(name = "`operate_time`")
    private Date operateTime;

    @Column(name = "`operator`")
    private String operator;

}