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
@Table(name = "`app_info`")
public class AppInfo {

    @Id
    @KeySql(genId = SnowFlakeId.class)
    @Column(name = "`app_id`")
    private Long appId;

    /**
     * app名字
     */
    @Column(name = "`app_name`")
    private String appName;

    /**
     * app秘钥
     */
    @Column(name = "`app_secret`")
    private String appSecret;

    /**
     * 描述
     */
    @Column(name = "`app_desc`")
    private String appDesc;

    /**
     * 0-无效，1-有效
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