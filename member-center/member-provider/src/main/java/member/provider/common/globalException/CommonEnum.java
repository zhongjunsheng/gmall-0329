package member.provider.common.globalException;


/**
 * 全局错误参数定义
 */
public enum CommonEnum  {
    // 数据操作错误定义
    SUCCESS("200", "成功!"),
    BODY_NOT_MATCH("400","请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH("401","请求的数字签名不匹配!"),
    NOT_FOUND("404", "未找到该资源!"),
    INTERNAL_SERVER_ERROR("500", "服务器内部错误!"),
    SERVER_BUSY("503","服务器正忙，请稍后再试!"),
    BAD_PARM("504","参数不全!");

    /** 错误码 */
    private String resultCode;

    /** 错误描述 */
    private String resultMsg;

    CommonEnum(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public String getResultCode() {
        return resultCode;
    }

    public CommonEnum setResultCode(String resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public CommonEnum setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
        return this;
    }
}