package member.provider.product.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ProductVo implements Serializable {

    @ApiModelProperty(value = "商品名称")
    private String productName;
    @ApiModelProperty(value = "用户名")
    private String userName;
    @ApiModelProperty(value = "收货地址")
    private String address;
    @ApiModelProperty(value = "购买数量")
    private String amount;
    @ApiModelProperty(value = "子商品信息")
    private Product product;

}
