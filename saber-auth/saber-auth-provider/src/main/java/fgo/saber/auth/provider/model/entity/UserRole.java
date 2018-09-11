package fgo.saber.auth.provider.model.entity;

import fgo.saber.common.mybatis.ext.SnowFlakeId;
import lombok.Builder;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import java.util.Date;
import javax.persistence.*;

@Data
@Builder
@Table(name = "`sb_user_role`")
public class UserRole {
    @Id
    @KeySql(genId = SnowFlakeId.class)
    @Column(name = "`user_role_id`")
    private Long userRoleId;

    @Column(name = "`role_id`")
    private Long roleId;

    @Column(name = "`user_id`")
    private Long userId;

    @Column(name = "`operate_ip`")
    private String operateIp;

    @Column(name = "`operate_time`")
    private Date operateTime;

    @Column(name = "`operator`")
    private String operator;

}