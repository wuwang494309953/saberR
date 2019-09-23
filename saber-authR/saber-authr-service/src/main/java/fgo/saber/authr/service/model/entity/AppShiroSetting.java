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
@Table(name = "`app_shiro_setting`")
public class AppShiroSetting {
    /**
     * 配置id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Id
    @KeySql(genId = SnowFlakeId.class)
    @Column(name = "`setting_id`")
    private Long settingId;

    /**
     * appId
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Column(name = "`app_id`")
    private Long appId;

    /**
     * shiro的权限eg.(/test/*,/**)这样的路径
     */
    @Column(name = "`shiro_path`")
    private String shiroPath;

    /**
     * shiro中的权限。eg(authc,anon)
     */
    @Column(name = "`shiro_auth`")
    private String shiroAuth;

    @Column(name = "`orders`")
    private Integer orders;

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