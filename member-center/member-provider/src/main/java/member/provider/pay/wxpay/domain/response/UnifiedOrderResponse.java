package member.provider.pay.wxpay.domain.response;

import member.provider.pay.wxpay.domain.anno.WxProperty;

/**
 * 统一下单-结果 Model
 *
 * @author Administrator
 */
public class UnifiedOrderResponse extends BaseWxResponse {
    /**
     * [return_code:Success->必填]应用APPID
     */
    @WxProperty("appid")
    private String appId;
    /**
     * [return_code:Success->必填]商户号
     */
    @WxProperty("mch_id")
    private String mchId;
    /**
     * [可选]设备号
     */
    @WxProperty("device_info")
    private String deviceInfo;
    /**
     * 随机字符串
     */
    @WxProperty("nonce_str")
    private String nonceStr;
    /**
     * [return_code:Success->必填]签名
     */
    private String sign;
    /**
     * [return_code:Success->必填]业务结果
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
     * [return_code&result_code:Success->必填]交易类型
     */
    @WxProperty("trade_type")
    private String tradeType;
    /**
     * [return_code&result_code:Success->必填]预支付交易会话标识
     */
    @WxProperty("prepay_id")
    private String prepayId;
    /**
     * [return_code&result_code:Success->必填]二维码链接,trade_type=NATIVE时有返回，此url用于生成支付二维码，然后提供给用户进行扫码支付。
     */
    @WxProperty("code_url")
    private String codeUrl;
    /**
     * [return_code&result_code:Success->必填]二维码链接,trade_type=MWEB时有返回，mweb_url为拉起微信支付收银台的中间页面，可通过访问该url来拉起微信客户端，完成支付,mweb_url的有效期为5分钟。
     */
    @WxProperty("mweb_url")
    private String mwebUrl;

    public String getAppId() {
        return appId;
    }

    public UnifiedOrderResponse setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public String getMchId() {
        return mchId;
    }

    public UnifiedOrderResponse setMchId(String mchId) {
        this.mchId = mchId;
        return this;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public UnifiedOrderResponse setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
        return this;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public UnifiedOrderResponse setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public UnifiedOrderResponse setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getResultCode() {
        return resultCode;
    }

    public UnifiedOrderResponse setResultCode(String resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    public String getErrCode() {
        return errCode;
    }

    public UnifiedOrderResponse setErrCode(String errCode) {
        this.errCode = errCode;
        return this;
    }

    public String getErrCodeDes() {
        return errCodeDes;
    }

    public UnifiedOrderResponse setErrCodeDes(String errCodeDes) {
        this.errCodeDes = errCodeDes;
        return this;
    }

    public String getTradeType() {
        return tradeType;
    }

    public UnifiedOrderResponse setTradeType(String tradeType) {
        this.tradeType = tradeType;
        return this;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public UnifiedOrderResponse setPrepayId(String prepayId) {
        this.prepayId = prepayId;
        return this;
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public UnifiedOrderResponse setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
        return this;
    }

    public String getMwebUrl() {
        return mwebUrl;
    }

    public UnifiedOrderResponse setMwebUrl(String mwebUrl) {
        this.mwebUrl = mwebUrl;
        return this;
    }

    @Override
    public String toString() {
        return "UnifiedOrderResponse{" + "appId='" + appId + '\'' + ", mchId='" + mchId + '\'' + ", deviceInfo='"
            + deviceInfo + '\'' + ", nonceStr='" + nonceStr + '\'' + ", sign='" + sign + '\'' + ", resultCode='"
            + resultCode + '\'' + ", errCode='" + errCode + '\'' + ", errCodeDes='" + errCodeDes + '\''
            + ", tradeType='" + tradeType + '\'' + ", prepayId='" + prepayId + '\'' + ", codeUrl='" + codeUrl + '\''
            + ", mwebUrl='" + mwebUrl + '\'' + ", returnCode='" + returnCode + '\'' + ", returnMsg='" + returnMsg + '\''
            + '}';
    }
}
