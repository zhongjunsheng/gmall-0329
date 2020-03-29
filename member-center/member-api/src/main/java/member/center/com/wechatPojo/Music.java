package member.center.com.wechatPojo;

import lombok.Data;

@Data
public class Music {
    private String title;
    private String description;
    private String musicURL;
    private String hQMusicUrl;
    private String thumbMediaId;

    public Music(String title, String description, String musicURL, String hQMusicUrl, String thumbMediaId) {
        super();
        this.title = title;
        this.description = description;
        this.musicURL = musicURL;
        this.hQMusicUrl = hQMusicUrl;
        this.thumbMediaId = thumbMediaId;
    }

}