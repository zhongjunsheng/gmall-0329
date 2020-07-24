package member.provider.pay.wxpay.domain.response;

import member.provider.pay.wxpay.domain.anno.WxProperty;
import member.provider.pay.wxpay.domain.model.BaseWxModel;

/**
 * @author Administrator
 * @date 2019/9/9
 * @since 1.0.0
 */
public abstract class BaseWxResponse extends BaseWxModel {
    /**
     * [必填]返回状态码
     */
    @WxProperty("return_code")
    protected String returnCode;
    /**
     * [必填]返回信息
     */
    @WxProperty("return_msg")
    protected String returnMsg;

    public String getReturnCode() {
        return returnCode;
    }

    public BaseWxResponse setReturnCode(String returnCode) {
        this.returnCode = returnCode;
        return this;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public BaseWxResponse setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
        return this;
    }
}