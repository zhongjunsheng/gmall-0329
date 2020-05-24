package member.center.com.pojo;

import java.io.Serializable;

public class Order implements Serializable {
    private Integer id;
    private String orderCode;
    private String desc;

    public Order(Integer id, String orderCode,String desc) {
        this.id = id;
        this.orderCode = orderCode;
        this.desc = desc;
    }

    public Integer getId() {
        return id;
    }

    public Order setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public Order setOrderCode(String orderCode) {
        this.orderCode = orderCode;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public Order setDesc(String desc) {
        this.desc = desc;
        return this;
    }
}
