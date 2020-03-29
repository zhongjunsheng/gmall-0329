package member.provider.wxTestDemo;

import com.alibaba.fastjson.JSON;
import member.center.com.wechatPojo.*;
import member.provider.common.HttpUtils;
import member.provider.common.WxServiceUtils;

public class CreateMenuLZ {

    public static void main(String[] args) {
        //菜单对象
        Button btn = new Button();
        //第一个一级菜单
        btn.getButton().add(new ClickButton("代办列表", "http://www.baidu.com"));
        //第二个一级菜单
        btn.getButton().add(new ViewButton("已办列表", "http://www.baidu.com"));
        //创建第三个一级菜单
        btn.getButton().add(new ViewButton("个人中心", "http://news.163.com"));
        //转为json
        String jsonStr = JSON.toJSONString(btn);
        //准备url
        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
        url = url.replace("ACCESS_TOKEN", WxServiceUtils.getAccessToken());
        //发送请求
        String result = HttpUtils.doPost(url, jsonStr);
        System.out.println(result);

    }

}
