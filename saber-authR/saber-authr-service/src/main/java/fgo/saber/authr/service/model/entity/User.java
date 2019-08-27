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
@Table(name = "`user`")
public class User {

    @Id
    @KeySql(genId = SnowFlakeId.class)
    @Column(name = "`user_id`")
    private Long userId;

    @Column(name = "`mail`")
    private String mail;

    @Column(name = "`telephone`")
    private String telephone;

    @Column(name = "`username`")
    private String username;

    @Column(name = "`password`")
    private String password;

    @Column(name = "`remark`")
    private String remark;

    /**
     * 用户状态(0-正常，1-已删除)
     */
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