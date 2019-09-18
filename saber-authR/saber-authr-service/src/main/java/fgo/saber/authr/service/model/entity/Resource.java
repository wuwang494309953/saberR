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
@Table(name = "`resource`")
public class Resource {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Id
    @KeySql(genId = SnowFlakeId.class)
    @Column(name = "`resource_id`")
    private Long resourceId;

    /**
     * appId
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Column(name = "`app_id`")
    private Long appId;


    /**
     * 资源名
     */
    @Column(name = "`resource_name`")
    private String resourceName;

    /**
     * 资源值
     */
    @Column(name = "`resource_value`")
    private String resourceValue;

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