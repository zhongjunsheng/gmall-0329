package member.center.com.wechatPojo;

import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

@XStreamAlias("xml")
@Data
public class MusicMessage{

    private Music music;

    @XStreamAlias("ToUserName")
    private String toUserName;
    @XStreamAlias("FromUserName")
    private String fromUserName;
    @XStreamAlias("CreateTime")
    private String createTime;
    @XStreamAlias("MsgType")
    private String msgType;

    public MusicMessage(Map<String, String> requestMap, Music music) {
        this.toUserName=requestMap.get("FromUserName");
        this.fromUserName=requestMap.get("ToUserName");
        this.createTime=System.currentTimeMillis()/1000+"";
        // 设置文本消息的msgtype为text
        this.msgType= "music";
        this.music = music;
    }

}