package fgo.saber.authr.service.model.entity;

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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "`permission`")
public class Permission {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Id
    @KeySql(genId = SnowFlakeId.class)
    @Column(name = "`permission_id`")
    private Long permissionId;

    /**
     * appId
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Column(name = "`app_id`")
    private Long appId;

    @Column(name = "`permission_name`")
    private String permissionName;

    @Column(name = "`permission_value`")
    private String permissionValue;

    @Column(name = "`remark`")
    private String remark;

    @Column(name = "`status`")
    private Integer status;

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