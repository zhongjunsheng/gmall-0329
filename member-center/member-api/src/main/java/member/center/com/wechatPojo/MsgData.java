package member.center.com.wechatPojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class MsgData  implements Serializable {

    private MsgModel first;
    private MsgModel keyword1;
    private MsgModel keyword2;
    private MsgModel remark;

}
