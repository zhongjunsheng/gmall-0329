package member.provider.pay.wxpay.domain.model;

import member.provider.pay.wxpay.domain.anno.WxProperty;

/**
 * 微信支付-企业付款至零钱-Model
 *
 * @author Administrator
 * @date 2019/9/24
 * @since 1.0.0
 */
public class PomotionTransfersModel extends BaseWxModel {
    /**
     * [必填]商户账号appid, 申请商户号的appid或商户号绑定的appid
     */
    @WxProperty("mch_appid")
    private String mchAppid;
    /**
     * [必填]商户号,微信支付分配的商户号
     */
    @WxProperty("mch_id")
    private String mchId;
    /**
     * [可选]设备号,微信支付分配的终端设备号
     */
    @WxProperty("device_info")
    private String deviceInfo;
    /**
     * [必填]随机字符串,随机字符串，不长于32位
     */
    @WxProperty("nonce_str")
    private String nonceStr;

    /**
     * [必填]签名
     */
    private String sign;

    /**
     * [必填]商户订单号,商户订单号，需保持唯一性 (只能是字母或者数字，不能包含有其他字符)
     */
    @WxProperty("partner_trade_no")
    private String partnerTradeNo;
    /**
     * [必填]用户openid,商户appid下，某用户的openid
     */
    @WxProperty("openid")
    private String openId;
    /**
     * [必填]校验用户姓名选项,NO_CHECK：不校验真实姓名.FORCE_CHECK：强校验真实姓名
     */
    @WxProperty("check_name")
    private String checkName;
    /**
     * [可选]收款用户姓名，收款用户真实姓名。如果check_name设置为FORCE_CHECK，则必填用户真实姓名
     */
    @WxProperty("re_user_name")
    private String reUserName;
    /**
     * [必填]金额,企业付款金额，单位为分
     */
    private Long amount;
    /**
     * [必填]企业付款备注,企业付款备注，必填。注意：备注中的敏感词会被转成字符*
     */
    private String desc;
    /**
     * [必填]Ip地址， 该IP同在商户平台设置的IP白名单中的IP没有关联，该IP可传用户端或者服务端的IP。
     */
    @WxProperty("spbill_create_ip")
    private String spbillCreateIp;

    public String getMchAppid() {
        return mchAppid;
    }

    public PomotionTransfersModel setMchAppid(String mchAppid) {
        this.mchAppid = mchAppid;
        return this;
    }

    public String getMchId() {
        return mchId;
    }

    public PomotionTransfersModel setMchId(String mchId) {
        this.mchId = mchId;
        return this;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public PomotionTransfersModel setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
        return this;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public PomotionTransfersModel setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public PomotionTransfersModel setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getPartnerTradeNo() {
        return partnerTradeNo;
    }

    public PomotionTransfersModel setPartnerTradeNo(String partnerTradeNo) {
        this.partnerTradeNo = partnerTradeNo;
        return this;
    }

    public String getOpenId() {
        return openId;
    }

    public PomotionTransfersModel setOpenId(String openId) {
        this.openId = openId;
        return this;
    }

    public String getCheckName() {
        return checkName;
    }

    public PomotionTransfersModel setCheckName(String checkName) {
        this.checkName = checkName;
        return this;
    }

    public String getReUserName() {
        return reUserName;
    }

    public PomotionTransfersModel setReUserName(String reUserName) {
        this.reUserName = reUserName;
        return this;
    }

    public Long getAmount() {
        return amount;
    }

    public PomotionTransfersModel setAmount(Long amount) {
        this.amount = amount;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public PomotionTransfersModel setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public PomotionTransfersModel setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
        return this;
    }
}