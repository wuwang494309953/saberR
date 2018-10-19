package fgo.saber.auth.api.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zq
 * @Date 2018/9/19
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
        return sortKey + " " + sortValue;
    }

}
