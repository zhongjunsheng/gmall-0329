package member.provider;

import com.alibaba.fastjson.JSON;
import member.center.com.wechatPojo.MsgData;
import member.center.com.wechatPojo.MsgModel;
import member.center.com.wechatPojo.MsgTemplate;
import member.provider.common.utils.HttpUtils;
import member.provider.common.utils.WxServiceUtils;
import org.junit.Test;

public class WxXinTemplteMessageTestPush {

    /**
     * 设置行业
     */
    @Test
    public void set() {
        String at = WxServiceUtils.getAccessToken();
        String url="https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token="+at;
        String data="{\n" +
                "          \"industry_id1\":\"21\",\n" +
                "          \"industry_id2\":\"19\"\n" +
                "       }";
        String result = HttpUtils.doPost(url, data);
        System.out.println(result);
    }

    /**
     * 获取行业
     */
    @Test
    public void get() {
        String at = WxServiceUtils.getAccessToken();
        String url="https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token="+at;
        String result = HttpUtils.doGet(url);
        System.out.println(result);
    }

    /**
     * 发送模板消息
     */
    @Test
    public void sendTemplateMessageTest() {
        String at = WxServiceUtils.getAccessToken();
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+at;
        String data="{\n" +
                "           \"touser\":\"os2q6uKyqrBPz6_VQ9dLqJU5ps2w\",\n" +
                "           \"template_id\":\"Eq1-O86ErNzAp4Quy26mguc_C2aIWioSqA7k73Va7Sk\", \n" +
                "           \"url\":\"http://www.baidu.com\",\n"+
                "           \"data\":{\n" +
                "                   \"first\": {\n" +
                "                       \"value\":\"您好，有待办事件需处理如下\",\n" +
                "                       \"color\":\"#e4393c\"\n" +
                "                   },\n" +
                "                   \"keyword1\":{\n" +
                "                       \"value\":\"来自allen的用车申请\",\n" +
                "                       \"color\":\"#000\"\n" +
                "                   },\n" +
                "                   \"remark\":{\n" +
                "                       \"value\":\"请您尽快处理！\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   }\n" +
                "           }\n" +
                "       }";


        String result = HttpUtils.doPost(url, data);
        System.out.println(result);
    }



    @Test
    public void sendTemplateMessageProd() {
        String at = WxServiceUtils.getAccessToken();
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+at;
        String data="{\n" +
                "           \"touser\":\"ob1xIwb2VL5E_oLJJVCqHVYVAAqQ\",\n" +
                "           \"template_id\":\"FK5Y_dlb3FpvfV5o8p6S3cXzN0HgRpQGHCyamgPufZ8\", \n" +
                "           \"url\":\"http://www.baidu.com\",\n"+
                "           \"data\":{\n" +
                "                   \"first\": {\n" +
                "                       \"value\":\"您有一份新的待办事项，请到pc端进行办理。\",\n" +
                "                       \"color\":\"#e4393c\"\n" +
                "                   },\n" +
                "                   \"keyword1\":{\n" +
                "                       \"value\":\"来自allen的用车申请\",\n" +
                "                       \"color\":\"#000\"\n" +
                "                   },\n" +
                "                   \"keyword2\":{\n" +
                "                       \"value\":\"待办事项\",\n" +
                "                       \"color\":\"#000\"\n" +
                "                   },\n" +
                "                   \"remark\":{\n" +
                "                       \"value\":\"请您尽快处理！\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   }\n" +
                "           }\n" +
                "       }";


        String result = HttpUtils.doPost(url, data);
        System.out.println(result);
    }




    @Test
    public void sendTemplateMessageProdByObject() {
        String at = WxServiceUtils.getAccessToken();
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+at;
        MsgTemplate mt = new MsgTemplate();
        mt.setTouser("os2q6uKyqrBPz6_VQ9dLqJU5ps2w"); //openId  -测试
        mt.setTemplate_id("Eq1-O86ErNzAp4Quy26mguc_C2aIWioSqA7k73Va7Sk"); //模板id -- 测试
        //获取openId后的回调url
        mt.setUrl("http://www.baidu.com"); //点击详情跳转url
        MsgData msgData = new MsgData();
        msgData.setFirst(new MsgModel("您有一份新的待办事项，请到pc端进行办理。","#e4393c"));
        msgData.setKeyword1(new MsgModel("msg push test顶!","#000"));
        msgData.setRemark(new MsgModel("请您尽快处理","#173177"));
        mt.setData(msgData);
        String data = JSON.toJSONString(mt);
        String result = HttpUtils.doPost(url, data);
        System.out.println(result);
    }
}
