package cn.itcast.utilsBean;

import java.io.Serializable;
import java.util.List;

//简化pagehelper 封装内容，减少传输压力
public class PageInfo<T> implements Serializable {
    private Long total;
    private List<T> rows;

    public PageInfo(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public PageInfo() {
    }

    public Long getTotal() {

        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }


}
