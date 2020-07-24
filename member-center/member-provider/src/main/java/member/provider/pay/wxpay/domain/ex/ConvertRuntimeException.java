package member.provider.pay.wxpay.domain.ex;

/**
 * 转换异常
 *
 * @author Administrator
 * @date 2019/9/9
 * @since 1.0.0
 */
public class ConvertRuntimeException extends RuntimeException {

    public ConvertRuntimeException() {}

    public ConvertRuntimeException(String message) {
        super(message);
    }

    public ConvertRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConvertRuntimeException(Throwable cause) {
        super(cause);
    }

    public ConvertRuntimeException(String message, Throwable cause, boolean enableSuppression,
        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}