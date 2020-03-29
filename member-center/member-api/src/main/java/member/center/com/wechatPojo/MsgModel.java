package member.center.com.wechatPojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class MsgModel implements Serializable {
    private String value;
    private String color;

    public MsgModel(String value, String color) {
        this.value = value;
        this.color = color;
    }
}
