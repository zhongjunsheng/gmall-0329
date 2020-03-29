package member.center.com.wechatPojo;

import lombok.Data;

/**
 * 微信openId和oa用户的绑定表
 */
@Data
public class WxUser {
   private  String uuid;
    private String userCode;
    private String openId;
}
