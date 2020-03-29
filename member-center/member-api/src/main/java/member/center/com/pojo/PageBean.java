package member.center.com.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageBean<T> implements Serializable {

    private Integer totalPage ; //总页数
    private Integer totalElements ; //总条数
    private List<T> list;   //数据列表
}
