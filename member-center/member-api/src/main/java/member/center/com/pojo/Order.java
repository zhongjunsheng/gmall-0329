package member.center.com.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Order implements Serializable {
    private Integer id;
    private String orderCode;
    private String desc;

    public Order(Integer id, String orderCode,String desc) {
        this.id = id;
        this.orderCode = orderCode;
        this.desc = desc;
    }
}
