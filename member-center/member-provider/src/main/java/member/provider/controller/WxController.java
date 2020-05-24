package member.provider.controller;

import member.center.com.api.WxUserService;
import member.center.com.wechatPojo.WxUser;
import member.provider.common.utils.CheckTokenUtil;
import member.provider.common.utils.WxServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 微信公众后核心逻辑代码
 */
@RestController
public class WxController {

    @Autowired(required = false)
    private WxUserService wxUserService;

    //微信公众号
    private static final String APPID = "wxf3210e76e0d187a9";
    private static final String APPSECRET = "1a3c2c27bc3088ad53ad25fe021d93c6";

    @RequestMapping("/wx")
    public String test() {
        return "wx-test88888888";
    }

    /**
     * 微信token验证
     *
     * @param request
     * @param
     * @throws IOException
     */
    @GetMapping("/wxService")
    public String weChatToCheckTocken(HttpServletRequest request) throws IOException {
        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");

        if (echostr == null || echostr.isEmpty()) {
            return nonce;
        }
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (signature != null && CheckTokenUtil.checkSignature(signature, timestamp, nonce)) {
            return echostr;
        }
        return nonce;
    }

    /**
     * 微信事件处理和消息推送
     *
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping("/wxService")
    public String weChatToDo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取微信端发送过来的数据包封装在map里
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("utf8");
        //获取微信发过来的消息
        Map<String, String> reciMap = WxServiceUtils.parseRequest(request.getInputStream());
        System.out.println(reciMap);
        //回应消息及处理
        String respXml = WxServiceUtils.getRespose(reciMap);
        return respXml;
    }


    /**
     * 代办列表按钮处理逻辑-页面跳转
     *
     * @return
     */

    @RequestMapping("/toDoList")
    public ModelAndView toDoList(HttpServletRequest request, HttpServletResponse resp) {

        ModelAndView mav = new ModelAndView();
        //1.auth2.o授权技术获取用户openId
        Map<String, String> map = new HashMap<>();
        map.put("code", request.getParameter("code"));
        String openId = WxServiceUtils.getOpenId(request);
        //String openId = WxServiceUtils.getOpenId(map);
        //2.通过用户openId去用户与微信绑定信息表查询用户是否已经绑定
        WxUser wu = wxUserService.getWxUserByOpenId(openId);
        if (null != wu) {
            //说明已经绑定过了
            String userCode = wu.getUserCode();
            mav.addObject("userCode", userCode);
            mav.setViewName("代办列表的前端展示");  //重定向到该url
            return mav;
        }

        //mav.addObject("openId", openId);//参数
        mav.setViewName("绑定个人信息页面url");  //重定向到改url
        return mav;


        //柳州公众后的写法
       /*Map<String, Object> map = getOpenIdAndBindFlag(request);  //此方法会把用户是否绑定的bindFlag一起返回
        Integer bindFlag = (Boolean) map.get("bindFlag")  == true ? 1 :0;
        String openId = (String) map.get("openId");
        String userCode  = (String) map.get("userCode");
        String applicationCode = (String) map.get("applicationCode");
        try {
            resp.sendRedirect("http://x24nu2.natappfree.cc/chioce?bindFlag="+bindFlag+"&openId="+openId+"&userCode="+userCode+"&applicationCode"+applicationCode+"&flag=1");
            //前端大的页面中请求后端 是否绑定Oa账户接口来选择跳转登录还是代办列表页面(已办也一样的逻辑)
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }


    /**
     * 已办列表按钮处理逻辑-页面跳转
     *
     * @return
     */

    @RequestMapping("/hasedDoList")
    public ModelAndView hasedDoList(HttpServletRequest request, HttpServletResponse resp) {

        //1.auth2.o授权技术获取用户openId
        Map<String, String> map = new HashMap<>();
        map.put("code", request.getParameter("code"));
        //String openId = WxServiceUtils.getOpenId(request);
        //String openId = WxServiceUtils.getOpenId(map);
        //2.通过用户openId去用户与微信绑定信息表查询用户是否已经绑定
        //3.绑定则跳到已办列表展示页面 否则跳到绑定中心
        //JSONObject jsonObject = JSONObject.parseObject(result);
        //mav.setViewName("http://bvz79y.natappfree.cc/test.html"); //跳转页面url要把openId传过去
        // mav.setViewName("/test.html"); //跳转页面url
        return null;

    }


    /**
     * 个人中心按钮点击处理逻辑--页面跳转
     */

    @RequestMapping("/userInfo")
    public void userInfo(HttpServletRequest request, HttpServletResponse resp) {
        //1.auth2.o授权技术获取用户openId
        Map<String, String> map = new HashMap<>();
        map.put("code", request.getParameter("code"));
        //String openId = WxServiceUtils.getOpenId(request);
        //String openId = WxServiceUtils.getOpenId(map);
        //2.通过用户openId去用户与微信绑定信息表查询用户是否已经绑定
        //3.绑定则跳到用户信息展示页面 否则跳到绑定中心

    }


    /**
     * 点击绑定的请求路劲
     *
     * @param wu
     */
    @RequestMapping("/bindUser")
    public void bindUser(WxUser wu) {
        //关键数据检验
        //数据入库
    }


    /**
     * auth 授权
     *
     * @param
     */
    @RequestMapping("/auth")
    public void getCode(HttpServletRequest request, HttpServletResponse response) throws Exception {


        Map<String, String> map = new HashMap<>();
        String msgUrl = request.getParameter("msgUrl");
        //String secondRedictUrl = "http://yipfax.natappfree.cc/getOpenId?redict_url="+msgUrl;
        String secondRedictUrl = "http://5m845n.natappfree.cc/getOpenId";
        System.out.println(msgUrl);
        //搜权方式2种：
        //以snsapi_base为scope发起的网页授权，是用来获取进入页面的用户的openid的，并且是静默授权并自动跳转到回调页的。用户感知的就是直接进入了回调页（往往是业务页面）
        //以snsapi_userinfo为scope发起的网页授权，是用来获取用户的基本信息的。但这种授权需要用户手动同意，并且由于用户同意过，所以无须关注，就可在授权后获取该用户的基本信息。
        String getWxCodeUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?" +
                "appid=APPID&redirect_uri=REDIRECT&response_type=code&scope=snsapi_base#wechat_redirect";
        getWxCodeUrl = getWxCodeUrl.replace("APPID", "wxf3210e76e0d187a9").replace("REDIRECT", secondRedictUrl);
        response.sendRedirect(getWxCodeUrl);
    }

    /**
     * 通过code 获取 openID
     * @param request
     * @param response
     * @throws Exception
     */

    @RequestMapping("/getOpenId")
    public void getOpenId(HttpServletRequest request, HttpServletResponse response)  throws  Exception{
        //String code = request.getParameter("code");//微信会返回code值，用code获取openid
        String currentOpenId = WxServiceUtils.getOpenId(request);
        response.sendRedirect("http://www.baidu.com");
        //mysql执行顺序
        //from  ---- join on   where  group by having ----select   ----order by  ===limit
    }


    public static void main(String[] args) {


    }
}

