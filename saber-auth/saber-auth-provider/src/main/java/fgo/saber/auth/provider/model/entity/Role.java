package fgo.saber.auth.provider.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "`sb_role`")
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @KeySql(genId = SnowFlakeId.class)
    @Column(name = "`role_id`")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long roleId;

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

    @Column(name = "`status`")
    private Integer status;

    @Column(name = "`type`")
    private Integer type;

}