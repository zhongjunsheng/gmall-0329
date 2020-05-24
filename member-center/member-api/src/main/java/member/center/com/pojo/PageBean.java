package member.center.com.pojo;


import java.io.Serializable;
import java.util.List;

public class PageBean<T> implements Serializable {

    private Integer totalPage ; //总页数
    private Integer totalElements ; //总条数
    private List<T> list;   //数据列表

    public Integer getTotalPage() {
        return totalPage;
    }

    public PageBean<T> setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
        return this;
    }

    public Integer getTotalElements() {
        return totalElements;
    }

    public PageBean<T> setTotalElements(Integer totalElements) {
        this.totalElements = totalElements;
        return this;
    }

    public List<T> getList() {
        return list;
    }

    public PageBean<T> setList(List<T> list) {
        this.list = list;
        return this;
    }
}
