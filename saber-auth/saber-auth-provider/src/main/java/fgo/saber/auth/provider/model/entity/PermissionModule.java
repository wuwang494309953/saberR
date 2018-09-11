package fgo.saber.auth.provider.model.entity;

import fgo.saber.common.mybatis.ext.SnowFlakeId;
import lombok.Builder;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import java.util.Date;
import javax.persistence.*;

@Data
@Builder
@Table(name = "`sb_permission_module`")
public class PermissionModule {
    @Id
    @KeySql(genId = SnowFlakeId.class)
    @Column(name = "`permission_module_id`")
    private Long permissionModuleId;

    @Column(name = "`parent_id`")
    private Long parentId;

    @Column(name = "`name`")
    private String name;

    @Column(name = "`operate_ip`")
    private String operateIp;

    @Column(name = "`operate_time`")
    private Date operateTime;

    @Column(name = "`operator`")
    private String operator;

    @Column(name = "`remark`")
    private String remark;

    @Column(name = "`seq`")
    private Integer seq;

    @Column(name = "`status`")
    private Integer status;

}