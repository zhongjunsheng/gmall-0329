
package member.provider.pay.wxpay.domain.model;

import member.provider.pay.wxpay.domain.anno.WxProperty;

/**
 * 统一下单 Model
 *
 * @author Administrator
 */
public class UnifiedOrderWxModel extends BaseWxModel {

    /**
     * [必填]应用ID
     */
    @WxProperty("appid")
    private String appId;
    /**
     * [必填]商户号
     */
    @WxProperty("mch_id")
    private String mchId;
    /**
     * [可选]设备号
     */
    @WxProperty("device_info")
    private String deviceInfo;
    /**
     * [必填]随机字符串
     */
    @WxProperty("nonce_str")
    private String nonceStr;
    /**
     * [必填]签名
     */
    private String sign;
    /**
     * [可选]签名类型-签名类型，目前支持HMAC-SHA256和MD5，默认为MD5
     */
    @WxProperty("sign_type")
    private String signType;
    /**
     * [必填]商品描述
     */
    private String body;
    /**
     * [可选]商品详情
     */
    private String detail;
    /**
     * [可选]附加数据
     */
    private String attach;
    /**
     * [必填]商户订单号
     */
    @WxProperty("out_trade_no")
    private String outTradeNo;
    /**
     * [可选]货币类型-默认人民币：CNY
     */
    @WxProperty("fee_type")
    private String feeType;
    /**
     * [必填]订单总金额，单位为分
     */
    @WxProperty("total_fee")
    private Integer totalFee;
    /**
     * [必填]终端IP-支持IPV4和IPV6两种格式的IP地址。调用微信支付API的机器IP
     */
    @WxProperty("spbill_create_ip")
    private String spbillCreateIp;
    /**
     * [可选]交易起始时间
     */
    @WxProperty("time_start")
    private String timeStart;
    /**
     * [可选]交易结束时间
     */
    @WxProperty("time_expire")
    private String timeExpire;
    /**
     * [可选]订单优惠标记
     */
    @WxProperty("goods_tag")
    private String goodsTag;

    /**
     * [必填]通知地址
     */
    @WxProperty("notify_url")
    private String notifyUrl;

    /**
     * [必填]交易类型-支付类型
     */
    @WxProperty("trade_type")
    private String tradeType;

    /**
     * [可选]指定支付方式-no_credit--指定不能使用信用卡支付
     */
    @WxProperty("limit_pay")
    private String limitPay;

    /**
     * [可选]用户标识
     */
    @WxProperty("openid")
    private String openId;
    /**
     * [可选]开发票入口开放标识
     */
    private String receipt;

    public String getAppId() {
        return appId;
    }

    public UnifiedOrderWxModel setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public String getMchId() {
        return mchId;
    }

    public UnifiedOrderWxModel setMchId(String mchId) {
        this.mchId = mchId;
        return this;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public UnifiedOrderWxModel setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
        return this;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public UnifiedOrderWxModel setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public UnifiedOrderWxModel setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getSignType() {
        return signType;
    }

    public UnifiedOrderWxModel setSignType(String signType) {
        this.signType = signType;
        return this;
    }

    public String getBody() {
        return body;
    }

    public UnifiedOrderWxModel setBody(String body) {
        this.body = body;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public UnifiedOrderWxModel setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    public String getAttach() {
        return attach;
    }

    public UnifiedOrderWxModel setAttach(String attach) {
        this.attach = attach;
        return this;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public UnifiedOrderWxModel setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
        return this;
    }

    public String getFeeType() {
        return feeType;
    }

    public UnifiedOrderWxModel setFeeType(String feeType) {
        this.feeType = feeType;
        return this;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public UnifiedOrderWxModel setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
        return this;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public UnifiedOrderWxModel setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
        return this;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public UnifiedOrderWxModel setTimeStart(String timeStart) {
        this.timeStart = timeStart;
        return this;
    }

    public String getTimeExpire() {
        return timeExpire;
    }

    public UnifiedOrderWxModel setTimeExpire(String timeExpire) {
        this.timeExpire = timeExpire;
        return this;
    }

    public String getGoodsTag() {
        return goodsTag;
    }

    public UnifiedOrderWxModel setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
        return this;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public UnifiedOrderWxModel setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
        return this;
    }

    public String getTradeType() {
        return tradeType;
    }

    public UnifiedOrderWxModel setTradeType(String tradeType) {
        this.tradeType = tradeType;
        return this;
    }

    public String getLimitPay() {
        return limitPay;
    }

    public UnifiedOrderWxModel setLimitPay(String limitPay) {
        this.limitPay = limitPay;
        return this;
    }

    public String getOpenId() {
        return openId;
    }

    public UnifiedOrderWxModel setOpenId(String openId) {
        this.openId = openId;
        return this;
    }

    public String getReceipt() {
        return receipt;
    }

    public UnifiedOrderWxModel setReceipt(String receipt) {
        this.receipt = receipt;
        return this;
    }

    @Override
    public String toString() {
        return "UnifiedOrderWxModel{" + "appId='" + appId + '\'' + ", mchId='" + mchId + '\'' + ", deviceInfo='"
            + deviceInfo + '\'' + ", nonceStr='" + nonceStr + '\'' + ", sign='" + sign + '\'' + ", signType='"
            + signType + '\'' + ", body='" + body + '\'' + ", detail='" + detail + '\'' + ", attach='" + attach + '\''
            + ", outTradeNo='" + outTradeNo + '\'' + ", feeType='" + feeType + '\'' + ", totalFee=" + totalFee
            + ", spbillCreateIp='" + spbillCreateIp + '\'' + ", timeStart='" + timeStart + '\'' + ", timeExpire='"
            + timeExpire + '\'' + ", goodsTag='" + goodsTag + '\'' + ", notifyUrl='" + notifyUrl + '\''
            + ", tradeType='" + tradeType + '\'' + ", limitPay='" + limitPay + '\'' + ", openId='" + openId + '\''
            + ", receipt='" + receipt + '\'' + '}';
    }
}
