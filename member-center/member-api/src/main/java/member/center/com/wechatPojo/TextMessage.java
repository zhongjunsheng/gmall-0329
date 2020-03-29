package member.center.com.wechatPojo;

import java.util.Map;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

@Data
@XStreamAlias("xml")
public class TextMessage {

    @XStreamAlias("Content")
    private String content;

    @XStreamAlias("ToUserName")
    private String toUserName;
    @XStreamAlias("FromUserName")
    private String fromUserName;
    @XStreamAlias("CreateTime")
    private String createTime;
    @XStreamAlias("MsgType")
    private String msgType;

    public TextMessage(Map<String, String> requestMap, String content) {
        this.toUserName=requestMap.get("FromUserName");
        this.fromUserName=requestMap.get("ToUserName");
        this.createTime=System.currentTimeMillis()/1000+"";
        // 设置文本消息的msgtype为text
        this.msgType= "text";
        this.content = content;
    }

}

