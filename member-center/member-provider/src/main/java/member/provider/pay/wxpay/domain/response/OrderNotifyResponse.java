package member.provider.pay.wxpay.domain.response;

import member.provider.pay.wxpay.domain.anno.WxProperty;

/**
 * 支付结果通用通知-Model
 *
 * @author Administrator
 * @date 2019/9/6
 * @since 1.0.0
 */
public class OrderNotifyResponse extends BaseWxResponse {
    /**
     * [return_code:SUCCESS->必填]公众账号ID
     */
    @WxProperty("appid")
    private String appId;
    /**
     * [return_code:SUCCESS->必填]商户号
     */
    @WxProperty("mch_id")
    private String mchId;
    /**
     * [可选]设备号
     */
    @WxProperty("device_info")
    private String deviceInfo;
    /**
     * [return_code:SUCCESS->必填]随机字符串
     */
    @WxProperty("nonce_str")
    private String nonceStr;
    /**
     * [return_code:SUCCESS->必填]签名
     */
    private String sign;
    /**
     * [return_code:SUCCESS->必填]业务结果
     */
    @WxProperty("result_code")
    private String resultCode;
    /**
     * [可选]错误代码
     */
    @WxProperty("err_code")
    private String errCode;
    /**
     * [可选]错误代码描述
     */
    @WxProperty("err_code_des")
    private String errCodeDes;
    /**
     * [return_code:SUCCESS->必填]用户标识
     */
    @WxProperty("openid")
    private String openId;
    /**
     * [return_code:SUCCESS->必填]是否关注公众账号
     */
    @WxProperty("is_subscribe")
    private String isSubscribe;
    /**
     * [return_code:SUCCESS->必填]交易类型
     */
    @WxProperty("trade_type")
    private String tradeType;
    /**
     * [return_code:SUCCESS->必填]付款银行
     */
    @WxProperty("bank_type")
    private String bankType;
    /**
     * [return_code:SUCCESS->必填]总金额
     */
    @WxProperty("total_fee")
    private Integer totalFee;
    /**
     * [return_code:SUCCESS->必填]
     */
    @WxProperty("fee_type")
    private String feeType;
    /**
     * [可选]货币种类
     */
    @WxProperty("cash_fee")
    private Integer cashFee;
    /**
     * [可选]现金支付货币类型
     */
    @WxProperty("cash_fee_type")
    private String cashFeeType;
    /**
     * [可选]代金券金额
     */
    @WxProperty("coupon_fee")
    private Integer couponFee;
    /**
     * [可选]代金券使用数量
     */
    @WxProperty("coupon_count")
    private Integer couponCount;
    /**
     * [return_code:SUCCESS->必填]微信支付订单号
     */
    @WxProperty("transaction_id")
    private String transactionId;
    /**
     * [return_code:SUCCESS->必填]商户订单号
     */
    @WxProperty("out_trade_no")
    private String outTradeNo;
    /**
     * [可选]商家数据包
     */
    private String attach;
    /**
     * [return_code:SUCCESS->必填]支付完成时间
     */
    @WxProperty("time_end")
    private String timeEnd;

    public String getAppId() {
        return appId;
    }

    public OrderNotifyResponse setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public String getMchId() {
        return mchId;
    }

    public OrderNotifyResponse setMchId(String mchId) {
        this.mchId = mchId;
        return this;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public OrderNotifyResponse setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
        return this;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public OrderNotifyResponse setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public OrderNotifyResponse setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getResultCode() {
        return resultCode;
    }

    public OrderNotifyResponse setResultCode(String resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    public String getErrCode() {
        return errCode;
    }

    public OrderNotifyResponse setErrCode(String errCode) {
        this.errCode = errCode;
        return this;
    }

    public String getErrCodeDes() {
        return errCodeDes;
    }

    public OrderNotifyResponse setErrCodeDes(String errCodeDes) {
        this.errCodeDes = errCodeDes;
        return this;
    }

    public String getOpenId() {
        return openId;
    }

    public OrderNotifyResponse setOpenId(String openId) {
        this.openId = openId;
        return this;
    }

    public String getIsSubscribe() {
        return isSubscribe;
    }

    public OrderNotifyResponse setIsSubscribe(String isSubscribe) {
        this.isSubscribe = isSubscribe;
        return this;
    }

    public String getTradeType() {
        return tradeType;
    }

    public OrderNotifyResponse setTradeType(String tradeType) {
        this.tradeType = tradeType;
        return this;
    }

    public String getBankType() {
        return bankType;
    }

    public OrderNotifyResponse setBankType(String bankType) {
        this.bankType = bankType;
        return this;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public OrderNotifyResponse setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
        return this;
    }

    public String getFeeType() {
        return feeType;
    }

    public OrderNotifyResponse setFeeType(String feeType) {
        this.feeType = feeType;
        return this;
    }

    public Integer getCashFee() {
        return cashFee;
    }

    public OrderNotifyResponse setCashFee(Integer cashFee) {
        this.cashFee = cashFee;
        return this;
    }

    public String getCashFeeType() {
        return cashFeeType;
    }

    public OrderNotifyResponse setCashFeeType(String cashFeeType) {
        this.cashFeeType = cashFeeType;
        return this;
    }

    public Integer getCouponFee() {
        return couponFee;
    }

    public OrderNotifyResponse setCouponFee(Integer couponFee) {
        this.couponFee = couponFee;
        return this;
    }

    public Integer getCouponCount() {
        return couponCount;
    }

    public OrderNotifyResponse setCouponCount(Integer couponCount) {
        this.couponCount = couponCount;
        return this;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public OrderNotifyResponse setTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public OrderNotifyResponse setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
        return this;
    }

    public String getAttach() {
        return attach;
    }

    public OrderNotifyResponse setAttach(String attach) {
        this.attach = attach;
        return this;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public OrderNotifyResponse setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
        return this;
    }
}