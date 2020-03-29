package member.center.com.wechatPojo;

import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

@XStreamAlias("xml")
@Data
public class VideoMessage {
    @XStreamAlias("MediaId")
    private String mediaId;
    @XStreamAlias("Title")
    private String title;
    @XStreamAlias("Description")
    private String description;

    @XStreamAlias("ToUserName")
    private String toUserName;
    @XStreamAlias("FromUserName")
    private String fromUserName;
    @XStreamAlias("CreateTime")
    private String createTime;
    @XStreamAlias("MsgType")
    private String msgType;

    public VideoMessage(Map<String, String> requestMap, String mediaId, String title, String description) {
        this.toUserName=requestMap.get("FromUserName");
        this.fromUserName=requestMap.get("ToUserName");
        this.createTime=System.currentTimeMillis()/1000+"";
        // 设置文本消息的msgtype为text
        this.msgType= "video";
        this.mediaId = mediaId;
        this.title = title;
        this.description = description;
    }

}