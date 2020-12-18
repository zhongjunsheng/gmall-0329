package member.provider.Java8Test;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DemoUser {
    private Integer num;
    private BigDecimal price;

    public Integer getNum() {
        return num;
    }

    public DemoUser setNum(Integer num) {
        this.num = num;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public DemoUser setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }


    public DemoUser(Integer num, BigDecimal price) {
        this.num = num;
        this.price = price;
    }
}
