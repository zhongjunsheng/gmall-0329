package member.center.com.wechatPojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SubButton extends AbstractButon {

    private List<AbstractButon> sub_button = new ArrayList<>();
    private String name;

    public SubButton(String name) {
        this.name= name;
    }



}