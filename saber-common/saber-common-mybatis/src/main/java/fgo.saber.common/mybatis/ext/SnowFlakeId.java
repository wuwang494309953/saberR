package fgo.saber.common.mybatis.ext;

import fgo.saber.common.snowflake.SnowFlakeUtil;
import tk.mybatis.mapper.genid.GenId;

/**
 * @author zq
 * @Date 2018/9/11
 */
public class SnowFlakeId implements GenId<Long> {

    @Override
    public Long genId(String s, String s1) {
        return SnowFlakeUtil.nextId();
    }
}
