package cn.itcast.utilsBean;

import java.io.Serializable;
import java.util.List;

//简化pagehelper 封装内容，减少传输压力
public class PageInfo<T> implements Serializable {
    private Long total;
    private List<T> list;

    public PageInfo(Long total, List<T> list) {
        this.total = total;
        this.list = list;
    }

    public PageInfo() {
    }

    public Long getTotal() {

        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }


}
