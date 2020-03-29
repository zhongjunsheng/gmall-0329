package member.center.com.wechatPojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

@Data
@XStreamAlias("item")
public class Article {

    @XStreamAlias("Title")
    private String title;
    @XStreamAlias("Description")
    private String description;
    @XStreamAlias("PicUrl")
    private String picUrl;
    @XStreamAlias("Url")
    private String url;

    public Article(String title, String description, String picUrl, String url) {
        super();
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
        this.url = url;
    }

}
