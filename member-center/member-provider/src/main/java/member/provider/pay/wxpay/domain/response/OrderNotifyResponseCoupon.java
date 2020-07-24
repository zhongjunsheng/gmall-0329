package member.provider.pay.wxpay.domain.response;

import member.provider.pay.wxpay.domain.model.BaseWxModel;

/**
 * 支付结果通用通知-Model
 *
 * @author Administrator
 * @date 2019/9/6
 * @since 1.0.0
 */
public class OrderNotifyResponseCoupon extends BaseWxModel {

    private String couponId;

    private Integer couponFee;

    public String getCouponId() {
        return couponId;
    }

    public OrderNotifyResponseCoupon setCouponId(String couponId) {
        this.couponId = couponId;
        return this;
    }

    public Integer getCouponFee() {
        return couponFee;
    }

    public OrderNotifyResponseCoupon setCouponFee(Integer couponFee) {
        this.couponFee = couponFee;
        return this;
    }
}