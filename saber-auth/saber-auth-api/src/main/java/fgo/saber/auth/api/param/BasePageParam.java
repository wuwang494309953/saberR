package fgo.saber.auth.api.param;

/**
 * @author zq
 * @Date 2018/9/19
 */
public class BasePageParam {

    /**
     * 页码，从1开始
     */
    private int pageNum;

    /**
     * 页面大小
     */
    private int pageSize;

    /**
     * 总数
     */
    private long total;

    private String sortKey;

    private String sortValue;

    private String sortStr() {
        return sortKey + " " + sortValue;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String getSortKey() {
        return sortKey;
    }

    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }

    public String getSortValue() {
        return sortValue;
    }

    public void setSortValue(String sortValue) {
        this.sortValue = sortValue;
    }
}
