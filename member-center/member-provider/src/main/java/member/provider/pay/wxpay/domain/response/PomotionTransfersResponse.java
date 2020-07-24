package member.provider.pay.wxpay.domain.response;

import member.provider.pay.wxpay.domain.anno.WxProperty;

/**
 * 微信支付-企业付款至零钱-Model
 *
 * @author Administrator
 * @date 2019/9/24
 * @since 1.0.0
 */
public class PomotionTransfersResponse extends BaseWxResponse {

    /**
     * [必填]商户appid,申请商户号的appid或商户号绑定的appid（企业号corpid即为此appId）
     */
    @WxProperty("mch_appid")
    private String mchAppId;
    /**
     * [必填]商户号,微信支付分配的商户号
     */
    @WxProperty("mchid")
    private String mchId;
    /**
     * [可选]设备号,微信支付分配的终端设备号，
     */
    @WxProperty("device_info")
    private String deviceInfo;
    /**
     * [必填]随机字符串，随机字符串，不长于32位
     */
    @WxProperty("nonce_str")
    private String nonceStr;
    /**
     * [必填]业务结果，SUCCESS/FAIL，注意：当状态为FAIL时，存在业务结果未明确的情况。 如果如果状态为FAIL，请务必关注错误代码（err_code字段），通过查询查询接口确认此次付款的结果。
     */
    @WxProperty("result_code")
    private String resultCode;
    /**
     * [可选]错误代码，注意：出现未明确的错误码时（SYSTEMERROR等），请务必用原商户订单号重试，或通过查询接口确认此次付款的结果。
     */
    @WxProperty("err_code")
    private String errCode;
    /**
     * [可选]错误代码描述,结果信息描述
     */
    @WxProperty("err_code_des")
    private String errCodeDes;

    /**
     * <p>
     * 以下字段在return_code 和result_code都为SUCCESS的时候有返回
     * </p>
     * [必填]商户订单号,商户订单号，需保持历史全局唯一性(只能是字母或者数字，不能包含有其他字符)
     */
    @WxProperty("partner_trade_no")
    private String partnerTradeNo;
    /**
     * <p>
     * 以下字段在return_code 和result_code都为SUCCESS的时候有返回
     * </p>
     * [必填]微信付款单号,企业付款成功，返回的微信付款单号
     */
    @WxProperty("payment_no")
    private String paymentNo;
    /**
     * <p>
     * 以下字段在return_code 和result_code都为SUCCESS的时候有返回
     * </p>
     * [必填]付款成功时间,企业付款成功时间
     */
    @WxProperty("payment_time")
    private String paymentTime;

    public String getMchAppId() {
        return mchAppId;
    }

    public PomotionTransfersResponse setMchAppId(String mchAppId) {
        this.mchAppId = mchAppId;
        return this;
    }

    public String getMchId() {
        return mchId;
    }

    public PomotionTransfersResponse setMchId(String mchId) {
        this.mchId = mchId;
        return this;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public PomotionTransfersResponse setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
        return this;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public PomotionTransfersResponse setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
        return this;
    }

    public String getResultCode() {
        return resultCode;
    }

    public PomotionTransfersResponse setResultCode(String resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    public String getErrCode() {
        return errCode;
    }

    public PomotionTransfersResponse setErrCode(String errCode) {
        this.errCode = errCode;
        return this;
    }

    public String getErrCodeDes() {
        return errCodeDes;
    }

    public PomotionTransfersResponse setErrCodeDes(String errCodeDes) {
        this.errCodeDes = errCodeDes;
        return this;
    }

    public String getPartnerTradeNo() {
        return partnerTradeNo;
    }

    public PomotionTransfersResponse setPartnerTradeNo(String partnerTradeNo) {
        this.partnerTradeNo = partnerTradeNo;
        return this;
    }

    public String getPaymentNo() {
        return paymentNo;
    }

    public PomotionTransfersResponse setPaymentNo(String paymentNo) {
        this.paymentNo = paymentNo;
        return this;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public PomotionTransfersResponse setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
        return this;
    }
}