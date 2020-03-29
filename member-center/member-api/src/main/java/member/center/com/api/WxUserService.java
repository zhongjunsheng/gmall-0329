package member.center.com.api;

import member.center.com.wechatPojo.WxUser;

public interface WxUserService {

    WxUser getWxUserByOpenId(String openId);
}
