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
import java.io.Serializable;
import java.util.Date;

/**
 * @author zq
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "`sb_dept`")
public class Dept implements Serializable {

    private static final long serialVersionUID = -4516548559532413277L;

    @Id
    @KeySql(genId = SnowFlakeId.class)
    @Column(name = "`dept_id`")
    private Long deptId;

    @Column(name = "`name`")
    private String name;

    @Column(name = "`operate_ip`")
    private String operateIp;

    @Column(name = "`operate_time`")
    private Date operateTime;

    @Column(name = "`operator`")
    private String operator;

    @Column(name = "`parent_id`")
    private Long parentId;

    @Column(name = "`remark`")
    private String remark;

    @Column(name = "`seq`")
    private Integer seq;

}