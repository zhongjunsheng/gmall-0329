package member.provider.biz.pay.wxpay.config;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * 微信支付配置
 *
 * @author Administrator
 */
@Validated
public class WxPayApiConfig implements Serializable {
    private static final long serialVersionUID = -9044503427692786302L;
    /**
     * 应用ID
     */
    @NotEmpty
    private String appId;
    /**
     * 商户号
     */
    @NotEmpty
    private String mchId;
    /**
     * 微信支付KEY
     */
    @NotEmpty
    private String paySignKey;
    /**
     * 证书路径
     */
    private String certPath;
    /**
     * 微信支付-回调URL
     */
    @NotEmpty
    private String notifyUrl;
    /**
     * 微信支付-统一下单-URL
     */
    @NotEmpty
    private String uniformOrderUrl;
    /**
     * 微信支付-企业付款到零钱-URL
     */
    @NotEmpty
    private String promotionTransfersUrl;
    /**
     * 微信支付-查询订单URL
     */
    @NotEmpty
    private String orderQueryUrl;
    /**
     * 微信支付-账单创建IP地址
     */
    @NotEmpty
    private String wxPayBillCreateIp;

    public String getAppId() {
        return appId;
    }

    public WxPayApiConfig setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public String getMchId() {
        return mchId;
    }

    public WxPayApiConfig setMchId(String mchId) {
        this.mchId = mchId;
        return this;
    }

    public String getPaySignKey() {
        return paySignKey;
    }

    public WxPayApiConfig setPaySignKey(String paySignKey) {
        this.paySignKey = paySignKey;
        return this;
    }

    public String getCertPath() {
        return certPath;
    }

    public WxPayApiConfig setCertPath(String certPath) {
        this.certPath = certPath;
        return this;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public WxPayApiConfig setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
        return this;
    }

    public String getUniformOrderUrl() {
        return uniformOrderUrl;
    }

    public WxPayApiConfig setUniformOrderUrl(String uniformOrderUrl) {
        this.uniformOrderUrl = uniformOrderUrl;
        return this;
    }

    public String getPromotionTransfersUrl() {
        return promotionTransfersUrl;
    }

    public WxPayApiConfig setPromotionTransfersUrl(String promotionTransfersUrl) {
        this.promotionTransfersUrl = promotionTransfersUrl;
        return this;
    }

    public String getWxPayBillCreateIp() {
        return wxPayBillCreateIp;
    }

    public WxPayApiConfig setWxPayBillCreateIp(String wxPayBillCreateIp) {
        this.wxPayBillCreateIp = wxPayBillCreateIp;
        return this;
    }

    public String getOrderQueryUrl() {
        return orderQueryUrl;
    }

    public WxPayApiConfig setOrderQueryUrl(String orderQueryUrl) {
        this.orderQueryUrl = orderQueryUrl;
        return this;
    }
}