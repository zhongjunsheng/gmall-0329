
package member.provider.pay.wxpay.domain.model;

import member.provider.pay.wxpay.domain.anno.WxProperty;

/**
 * 查询订单 Model- 支持: 普通订单查询、刷脸支付订单、查询分账结果、回退结果查询
 *
 * @author Administrator
 */
public class OrderQueryWxModel extends BaseWxModel {
    /**
     * [必填]应用APPID
     */
    @WxProperty("appid")
    private String appId;
    /**
     * [必填]商户号
     */
    @WxProperty("mch_id")
    private String mchId;
    /**
     * [二选一]微信订单号-微信的订单号，优先使用
     */
    @WxProperty("transaction_id")
    private String transactionId;
    /**
     * [二选一]商户订单号-商户系统内部订单号
     */
    @WxProperty("out_trade_no")
    private String outTradeNo;
    /**
     * [必填]随机字符串
     */
    @WxProperty("nonce_str")
    private String nonceStr;
    /**
     * [必填]签名
     */
    private String sign;

    public String getAppId() {
        return appId;
    }

    public OrderQueryWxModel setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public String getMchId() {
        return mchId;
    }

    public OrderQueryWxModel setMchId(String mchId) {
        this.mchId = mchId;
        return this;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public OrderQueryWxModel setTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public OrderQueryWxModel setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
        return this;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public OrderQueryWxModel setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public OrderQueryWxModel setSign(String sign) {
        this.sign = sign;
        return this;
    }
}
