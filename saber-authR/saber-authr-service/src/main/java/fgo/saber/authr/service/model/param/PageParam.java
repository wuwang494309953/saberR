package fgo.saber.authr.service.model.param;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @author zq
 * @Date 2018/9/19
 */

@Data
public class PageParam {

    /**
     * 页码，从1开始
     */
    private int pageNum = 1;

    /**
     * 页面大小
     */
    private int pageSize = 10;


    private String sortKey;

    private String sortValue;

    public String sortStr() {
        return sortStr(null);
    }

    public String sortStr(String tableAlias) {
        if (StringUtils.isBlank(tableAlias)) {
            return sortKey + " " + sortValue;
        }
        return tableAlias + "." + sortKey + " " + sortValue;
    }

}
