package member.provider.wxTestDemo;

import com.alibaba.fastjson.JSON;
import member.center.com.wechatPojo.*;
import member.provider.common.HttpUtils;
import member.provider.common.WxServiceUtils;

public class CreateMenu {

    public static void main(String[] args) {
        //菜单对象
        Button btn = new Button();
        //第一个一级菜单
        btn.getButton().add(new ClickButton("一级点击", "http://www.baidu.com"));
        //第二个一级菜单
        btn.getButton().add(new ViewButton("一级跳转", "http://www.baidu.com"));
        //创建第三个一级菜单
        SubButton sb = new SubButton("有子菜单");
        //为第三个一级菜单增加子菜单
        sb.getSub_button().add(new PhotoOrAlbumButton("传图", "31"));
        sb.getSub_button().add(new ClickButton("点击", "32"));
        sb.getSub_button().add(new ViewButton("网易新闻", "http://news.163.com"));
        //加入第三个一级菜单
        btn.getButton().add(sb);
        //转为json
        //JSONObject jsonObject = JSONObject.fromObject(btn);
        String jsonStr = JSON.toJSONString(btn);
        //准备url
        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
        url = url.replace("ACCESS_TOKEN", WxServiceUtils.getAccessToken());
        //发送请求
        String result = HttpUtils.doPost(url, jsonStr);
        System.out.println(result);

    }

}
