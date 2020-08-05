package member.provider.pay.wxpay.domain.enums;

/**
 * 微信-支付的方式
 *
 * @author Administrator
 * @date 2019/9/6
 * @since 1.0.0
 */
public enum TradeType {
    /**
     * JSAPI支付（或小程序支付）
     */
    JS_API("JSAPI"),
    /**
     * Native支付
     */
    NATIVE("NATIVE"),
    /**
     * app支付
     */
    APP("APP"),
    /**
     * H5支付
     */
    M_WEB("MWEB");

    private final String type;

    TradeType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}