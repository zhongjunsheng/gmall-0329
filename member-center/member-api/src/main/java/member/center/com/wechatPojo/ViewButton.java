package member.center.com.wechatPojo;

import lombok.Data;
@Data
public class ViewButton extends AbstractButon {

    private String type = "view";
    private String url;
    private String name;

    public ViewButton(String name, String url) {
        this.name= name;
        this.url = url;
    }

}