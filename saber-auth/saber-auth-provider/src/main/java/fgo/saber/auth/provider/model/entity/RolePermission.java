package fgo.saber.auth.provider.model.entity;

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