package member.provider.common.globalException;

import lombok.Data;

/**
 * 自定义异常类
 */
@Data
public class CustomException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    protected String errorCode;
    /**
     * 错误信息
     */
    protected String errorMsg;

    public CustomException(CommonEnum commonEnum) {
        super(commonEnum.getResultCode());
        this.errorCode = commonEnum.getResultCode();
        this.errorMsg = commonEnum.getResultMsg();
    }


    public CustomException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public CustomException(String errorCode, String errorMsg) {
        super(errorCode);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }


}
