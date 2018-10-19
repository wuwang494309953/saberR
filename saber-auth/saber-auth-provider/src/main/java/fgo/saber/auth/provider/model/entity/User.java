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
@Table(name = "`sb_user`")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @KeySql(genId = SnowFlakeId.class)
    @Column(name = "`user_id`")
    private Long userId;

    @Column(name = "`dept_id`")
    private Long deptId;

    @Column(name = "`mail`")
    private String mail;

    @Column(name = "`operate_ip`")
    private String operateIp;

    @Column(name = "`operate_time`")
    private Date operateTime;

    @Column(name = "`operator`")
    private String operator;

    @Column(name = "`username`")
    private String username;

    @Column(name = "`password`")
    private String password;

    @Column(name = "`remark`")
    private String remark;

    @Column(name = "`status`")
    private Integer status;

    @Column(name = "`telephone`")
    private String telephone;

}