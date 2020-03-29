package member.center.com.wechatPojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Button extends AbstractButon {
    private List<AbstractButon> button = new ArrayList<>();

}
