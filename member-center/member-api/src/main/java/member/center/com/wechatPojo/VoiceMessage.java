package member.center.com.wechatPojo;
import java.util.Map;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

@Data
@XStreamAlias("xml")
public class VoiceMessage {
    @XStreamAlias("MediaId")
    private String mediaId;

    @XStreamAlias("ToUserName")
    private String toUserName;
    @XStreamAlias("FromUserName")
    private String fromUserName;
    @XStreamAlias("CreateTime")
    private String createTime;
    @XStreamAlias("MsgType")
    private String msgType;

    public VoiceMessage(Map<String, String> requestMap, String mediaId) {
        this.toUserName=requestMap.get("FromUserName");
        this.fromUserName=requestMap.get("ToUserName");
        this.createTime=System.currentTimeMillis()/1000+"";
        this.msgType= "voice";
        this.mediaId = mediaId;
    }


}