package member.provider.common.globalException;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;


/**
 * 统一响应体
 */
@Data
public class ResultBody<T>  implements Serializable {
    /**
     * 响应代码
     */
    private String code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应结果
     */
    private T data;

    public ResultBody() {
    }

    public ResultBody(CommonEnum commonEnum) {
        this.code = commonEnum.getResultCode();
        this.message = commonEnum.getResultMsg();
    }

    public ResultBody(T data) {
        this.code = "200";
        this.message = "OK";
        this.data = data;
    }


    public ResultBody setData(T data) {
        this.data = data;
        return this;
    }

    /**
     * 成功
     *
     * @return
     */
    public static ResultBody success() {
        return success(null);
    }

    /**
     * 成功
     * @param data
     * @return
     */
    public static ResultBody success(Object data) {
        ResultBody rb = new ResultBody();
        rb.setCode(CommonEnum.SUCCESS.getResultCode());
        rb.setMessage(CommonEnum.SUCCESS.getResultMsg());
        rb.setData(data);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultBody error(CommonEnum commonEnum) {
        ResultBody rb = new ResultBody();
        rb.setCode(commonEnum.getResultCode());
        rb.setMessage(commonEnum.getResultMsg());
        rb.setData(null);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultBody error(String code, String message) {
        ResultBody rb = new ResultBody();
        rb.setCode(code);
        rb.setMessage(message);
        rb.setData(null);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultBody error(String message) {
        ResultBody rb = new ResultBody();
        rb.setCode("-1");
        rb.setMessage(message);
        rb.setData(null);
        return rb;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
