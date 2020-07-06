package member.provider;

import com.alibaba.fastjson.JSON;
import member.center.com.wechatPojo.Button;
import member.center.com.wechatPojo.ClickButton;
import member.center.com.wechatPojo.ViewButton;
import member.provider.common.utils.HttpUtils;
import member.provider.common.utils.WxServiceUtils;
import org.junit.Test;

public class WxXinMenuPro {


    @Test
    public void creatMenuPro(){
        //菜单对象
        Button btn = new Button();
        //第一个一级菜单--代办列表

        //获取openId后的回调url
        String redirect_url_toDoList = "http://dtw5tp.natappfree.cc/BasicDataWeb/toDoList"; //回调接口 会把用户的信息返回

        //调用腾讯的url获取返回的code 从而去拿到openId
        String tarurl_01 = "https://open.weixin.qq.com/connect/oauth2/authorize?" +
                "appid=APPID&redirect_uri=REDIRECT&response_type=code&scope=snsapi_base#wechat_redirect";
        tarurl_01=tarurl_01.replace("APPID","wxddc261a7953b6085").replace("REDIRECT",redirect_url_toDoList);
        btn.getButton().add(new ViewButton("代办列表", tarurl_01));



        //第二个一级菜单 --已办列表
        String redirect_url_hasedDoList = "http://dtw5tp.natappfree.cc/BasicDataWeb/hasedDoList";
        String tarurl_02 = "https://open.weixin.qq.com/connect/oauth2/authorize?" +
                "appid=APPID&redirect_uri=REDIRECT&response_type=code&scope=snsapi_base#wechat_redirect";
        tarurl_02=tarurl_02.replace("APPID","wxddc261a7953b6085").replace("REDIRECT",redirect_url_hasedDoList);


        btn.getButton().add(new ViewButton("已办列表", tarurl_02));


        //加入第三个一级菜单-个人中心
        String redirect_url_userIfo = "http://dtw5tp.natappfree.cc/BasicDataWeb/userInfo";
        String tarurl_03 = "https://open.weixin.qq.com/connect/oauth2/authorize?" +
                "appid=APPID&redirect_uri=REDIRECT&response_type=code&scope=snsapi_base#wechat_redirect";
        tarurl_03=tarurl_03.replace("APPID","wxddc261a7953b6085").replace("REDIRECT",redirect_url_userIfo);
        btn.getButton().add(new ViewButton("个人中心", tarurl_03));


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


    @Test
    public void delMenu(){

        String url =" https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
        url = url.replace("ACCESS_TOKEN", WxServiceUtils.getAccessToken());
        String result = HttpUtils.doGet(url);
        System.out.println(result);
    }


    @Test
    public void creatMenuTest(){
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
