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
@Table(name = "`user_role`")
public class UserRole {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Id
    @KeySql(genId = SnowFlakeId.class)
    @Column(name = "`user_role_id`")
    private Long userRoleId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Column(name = "`role_id`")
    private Long roleId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Column(name = "`user_id`")
    private Long userId;

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