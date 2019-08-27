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
@Table(name = "`user_role`")
public class UserRole {

    @Id
    @KeySql(genId = SnowFlakeId.class)
    @Column(name = "`user_role_id`")
    private Long userRoleId;

    @Column(name = "`role_id`")
    private Long roleId;

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