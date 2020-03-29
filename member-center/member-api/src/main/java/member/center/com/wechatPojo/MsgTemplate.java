package member.center.com.wechatPojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class MsgTemplate  implements Serializable {

    private String touser;
    private String template_id;
    private String url;
    private MsgData data;



}
