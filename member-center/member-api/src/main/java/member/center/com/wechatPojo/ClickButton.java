package member.center.com.wechatPojo;

import lombok.Data;

@Data
public class ClickButton extends AbstractButon {

    private String type = "click";
    private String key;
    private String name;
     public ClickButton(String name, String key) {
        this.name= name;
        this.key = key;
    }

    public static void main(String[] args) {

        ClickButton cb = new ClickButton("allen","a");
        System.out.println(cb.getType());
    }

}