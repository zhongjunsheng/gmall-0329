package member.provider.biz.pay.wxpay.domain.enums;

/**
 * <p>
 * 签名方式
 * </p>
 *
 * @author Administrator
 */
public enum SignType {
    /**
     * HMAC-SHA256 加密
     */
    HMAC_SHA256("HMAC-SHA256"),
    /**
     * MD5 加密
     */
    MD5("MD5");

    SignType(String type) {
        this.type = type;
    }

    private final String type;

    public String getType() {
        return type;
    }
}
