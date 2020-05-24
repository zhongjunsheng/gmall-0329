package member.provider.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.thoughtworks.xstream.XStream;
import member.center.com.wechatPojo.*;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 微信事件处理工具类
 */
public class WxServiceUtils {

    private static final String TOKEN = "myToken";
    private static final String GET_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=" +
            "client_credential&appid=APPID&secret=APPSECRET";

    //柳州正式微信公众号
    //private static final String APPID="wxddc261a7953b6085";
    //private static final String APPSECRET="775e28cef555648ef3591c3574a86b57";

    //测试微信公众号
    private static final String APPID="wxf3210e76e0d187a9";
    private static final String APPSECRET="1a3c2c27bc3088ad53ad25fe021d93c6";

    //百度AI
    private static final String APPKEY="1fec136dbd19f44743803f89bd55ca62";

    //用于存储token
    private static AccessToken at;

    /**
     * 获取token
     *  dubbo服务的话不允许已getxxx()方法 返回类型为void
     */
    private static void getToken() {
        String url = GET_TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
        //String url = GET_TOKEN_URL.replace("APPID", APPID_TEST).replace("APPSECRET", APPSECRET_TEST);
        String tokenStr = HttpUtils.doGet(url);
        //JSONObject jsonObject = JSONObject.fromObject(tokenStr);
        JSONObject jsonObject = JSONObject.parseObject(tokenStr);
        String token = jsonObject.getString("access_token");
        String expireIn = jsonObject.getString("expires_in");
        //创建token对象,并存起来。
        at = new AccessToken(token, expireIn);
    }

    /**
     * 向处暴露的获取token的方法
     * @return
     * by 罗召勇 Q群193557337
     */
    public static String getAccessToken() {
        if(at==null||at.isExpired()) {
            getToken();
        }
        return at.getAccessToken();
    }

    /**
     * 验证签名
     * @param timestamp
     * @param nonce
     * @param signature
     * @return
     * by 罗召勇 Q群193557337
     */
    public static boolean check(String timestamp, String nonce, String signature) {
        //1）将token、timestamp、nonce三个参数进行字典序排序
        String[] strs = new String[] {TOKEN,timestamp,nonce};
        Arrays.sort(strs);
        //2）将三个参数字符串拼接成一个字符串进行sha1加密
        String str = strs[0]+strs[1]+strs[2];
        String mysig = sha1(str);
        //3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        return mysig.equalsIgnoreCase(signature);
    }

    /**
     * 进行sha1加密
     * @param src
     * @return
     * by 罗召勇 Q群193557337
     */
    private static String sha1(String src) {
        try {
            //获取一个加密对象
            MessageDigest md = MessageDigest.getInstance("sha1");
            //加密
            byte[] digest = md.digest(src.getBytes());
            char[] chars= {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
            StringBuilder sb = new StringBuilder();
            //处理加密结果
            for(byte b:digest) {
                sb.append(chars[(b>>4)&15]);
                sb.append(chars[b&15]);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解析xml数据包
     * @param is
     * @return
     * by 罗召勇 Q群193557337
     */
    public static Map<String, String> parseRequest(InputStream is) {
        Map<String, String> map = new HashMap<>();
        SAXReader reader = new SAXReader();
        try {
            //读取输入流，获取文档对象
            Document document = reader.read(is);
            //根据文档对象获取根节点
            Element root = document.getRootElement();
            //获取根节点的所有的子节点
            List<Element> elements = root.elements();
            for(Element e:elements) {
                map.put(e.getName(), e.getStringValue());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 用于处理所有的事件和消息的回复
     * @param requestMap
     * @return 返回的是xml数据包
     * by 罗召勇 Q群193557337
     */
    public static String getRespose(Map<String, String> requestMap) {
        Object msg=null;
        String msgType = requestMap.get("MsgType");
        switch (msgType) {
            //处理文本消息
            case "text":
                msg=dealTextMessage(requestMap);
                System.out.println("msg:"+msg);
                break;
            //图片消息
            case "image":
                //msg=dealImage(requestMap);
                msg=null;
                break;
            case "voice":

                break;
            case "video":

                break;
            case "shortvideo":

                break;
            case "location":

                break;
            case "link":

                break;

             //事件处理
            case "event":
                msg = dealEvent(requestMap);
                break;
            default:
                break;
        }
        //把消息对象处理为xml数据包
        if(msg!=null) {
            return beanToXml(msg);
        }
        return null;
    }

    /**
     * 进行图片识别
     * @param requestMap
     * @return
     * by 罗召勇 Q群193557337
     */
   /* private static BaseMessage dealImage(Map<String, String> requestMap) {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        // 调用接口
        String path = requestMap.get("PicUrl");

        //进行网络图片的识别
        org.json.JSONObject res = client.generalUrl(path, new HashMap<String,String>());
        String json = res.toString();
        //转为jsonObject
        //JSONObject jsonObject = JSONObject.fromObject(json);
        JSONObject jsonObject = JSONObject.parseObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray("words_result");
        Iterator<JSONObject> it = jsonArray.iterator();
        StringBuilder sb = new StringBuilder();
        while(it.hasNext()) {
            JSONObject next = it.next();
            sb.append(next.getString("words"));
        }
        return new TextMessage(requestMap, sb.toString());
    }
*/
    /**
     * 处理事件推送
     * @param requestMap
     * @return
     * by 罗召勇 Q群193557337
     */
    private static Object dealEvent(Map<String, String> requestMap) {
        String event = requestMap.get("Event");
        switch (event) {
            case "CLICK":
                return dealClick(requestMap);
            case "VIEW":
                return dealView(requestMap);
            case "subscribe":
                return dealSubscribe(requestMap);
            case "unsubscribe":
                return dealUnSubscribe(requestMap);
            default:
                break;
        }
        return null;
    }

    /**
     * 处理用户取消关注时的推送
     * @param requestMap
     * @return
     * by 罗召勇 Q群193557337
     */
    private static Object dealUnSubscribe(Map<String, String> requestMap) {
        System.out.println("用户:+"+requestMap.get("FromUserName")+"取消了关注");
        //return new TextMessage(requestMap, "用户:+"+requestMap.get("FromUserName")+"取消了关注");
        return new TextMessage(requestMap, "用户:+"+requestMap.get("FromUserName")+"取消了关注");
    }

    /**
     * 处理用户关注时的推送
     * @param requestMap
     * @return
     * by 罗召勇 Q群193557337
     */
    private static Object dealSubscribe(Map<String, String> requestMap) {
        System.out.println("用户:+"+requestMap.get("FromUserName")+"关注了该公众号");
        //获取该用户的相关信息
        String openId = requestMap.get("FromUserName");
        String accessToken = WxServiceUtils.getAccessToken();
        String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
        url = url.replace("ACCESS_TOKEN",accessToken).replace("OPENID",openId);
        String jsonUser = HttpUtils.doGet(url);
        System.out.println("用户的详细信息:"+jsonUser);
        //插入数据库
        //return new TextMessage(requestMap, "用户:+"+requestMap.get("FromUserName")+"关注了该公众号");
        return new TextMessage(requestMap, "Hi-欢迎使用编办内部系统,请到个人中心绑定账号,绑定后可查看代办信息和接收到代办通知");
    }

    /**
     * 处理view类型的按钮的菜单
     * @param requestMap
     * @return
     * by 罗召勇 Q群193557337
     */
    private static BaseMessage dealView(Map<String, String> requestMap) {

        return null;
    }

    /**
     * 处理click菜单
     * @param requestMap
     * @return
     * by 罗召勇 Q群193557337
     */
    private static TextMessage dealClick(Map<String, String> requestMap) {
        String key = requestMap.get("EventKey");
        switch (key) {
            //点击一菜单点
            case "1":
                //处理点击了第一个一级菜单
                return new TextMessage(requestMap, "你点了一点第一个一级菜单");
            case "32":
                //处理点击了第三个一级菜单的第二个子菜单
                break;
            default:
                break;
        }
        return null;
    }

    /**
     * 把消息对象处理为xml数据包
     * @param msg
     * @return
     * by 罗召勇 Q群193557337
     */
    private static String beanToXml(Object msg) {
        XStream stream = new XStream();
        //设置需要处理XStreamAlias("xml")注释的类
        stream.processAnnotations(TextMessage.class);
        stream.processAnnotations(ImageMessage.class);
        stream.processAnnotations(MusicMessage.class);
        stream.processAnnotations(NewsMessage.class);
        stream.processAnnotations(VideoMessage.class);
        stream.processAnnotations(VoiceMessage.class);
        String xml = stream.toXML(msg);
        return xml;
    }

    /**
     * 处理文本消息
     * @param requestMap
     * @return
     * by 罗召勇 Q群193557337
     */
    private static TextMessage dealTextMessage(Map<String, String> requestMap) {
/*
        //用户发来的内容
        String msg = requestMap.get("Content");
        if(msg.equals("图文")) {
            List<Article> articles = new ArrayList<>();
            articles.add(new Article("这是图文消息的标题", "这是图文消息的详细介绍", "http://mmbiz.qpic.cn/mmbiz_jpg/dtRJz5K066YczqeHmWFZSPINM5evWoEvW21VZcLzAtkCjGQunCicDubN3v9JCgaibKaK0qGrZp3nXKMYgLQq3M6g/0", "http://www.baidu.com"));
            NewsMessage nm = new NewsMessage(requestMap, articles);
            return nm;
        }
        if(msg.equals("登录")) {
            String url="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxb6777fffdf5b64a4&redirect_uri=http://www.6sdd.com/weixin/GetUserInfo&response_type=code&scope=snsapi_userinfo#wechat_redirect";
            TextMessage tm = new TextMessage(requestMap, "点击<a href=\""+url+"\">这里</a>登录");
            return tm;
        }
        //调用方法返回聊天的内容
        String resp = chat(msg);
        TextMessage tm = new TextMessage(requestMap, resp);
        return tm;
*/


        //文本信息同一回应success
        TextMessage tm = new TextMessage(requestMap, "success");
        return tm;
    }

    /**
     * 调用图灵机器人聊天
     * @param msg 	发送的消息
     * @return
     * by 罗召勇 Q群193557337
     */
    private static String chat(String msg) {
        String result =null;
        String url ="http://op.juhe.cn/robot/index";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("key",APPKEY);//您申请到的本接口专用的APPKEY
        params.put("info",msg);//要发送给机器人的内容，不要超过30个字符
        params.put("dtype","");//返回的数据的格式，json或xml，默认为json
        params.put("loc","");//地点，如北京中关村
        params.put("lon","");//经度，东经116.234632（小数点后保留6位），需要写为116234632
        params.put("lat","");//纬度，北纬40.234632（小数点后保留6位），需要写为40234632
        params.put("userid","");//1~32位，此userid针对您自己的每一个用户，用于上下文的关联
        try {
            result = HttpUtils.getWithParms(url, params, "GET");
            //解析json
            //JSONObject jsonObject = JSONObject.fromObject(result);
            JSONObject jsonObject = JSONObject.parseObject(result);
            //取出error_code
            //int code = jsonObject.getInt("error_code");
            int code = jsonObject.getInteger("error_code");
            if(code!=0) {
                return null;
            }
            //取出返回的消息的内容
            String resp = jsonObject.getJSONObject("result").getString("text");
            return resp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 上传临时素材
     * @param path	上传的文件的路径
     * @param type	上传的文件类型
     * @return
     * by 罗召勇 Q群193557337
     */
    public static String upload(String path,String type) {
        File file = new File(path);
        //地址
        String url="https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
        url = url.replace("ACCESS_TOKEN", getAccessToken()).replace("TYPE", type);
        try {
            URL urlObj = new URL(url);
            //强转为案例连接
            HttpsURLConnection conn = (HttpsURLConnection) urlObj.openConnection();
            //设置连接的信息
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            //设置请求头信息
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Charset", "utf8");
            //数据的边界
            String boundary = "-----"+System.currentTimeMillis();
            conn.setRequestProperty("Content-Type", "multipart/form-data;boundary="+boundary);
            //获取输出流
            OutputStream out = conn.getOutputStream();
            //创建文件的输入流
            InputStream is = new FileInputStream(file);
            //第一部分：头部信息
            //准备头部信息
            StringBuilder sb = new StringBuilder();
            sb.append("--");
            sb.append(boundary);
            sb.append("\r\n");
            sb.append("Content-Disposition:form-data;name=\"media\";filename=\""+file.getName()+"\"\r\n");
            sb.append("Content-Type:application/octet-stream\r\n\r\n");
            out.write(sb.toString().getBytes());
            System.out.println(sb.toString());
            //第二部分：文件内容
            byte[] b = new byte[1024];
            int len;
            while((len=is.read(b))!=-1) {
                out.write(b, 0, len);
            }
            is.close();
            //第三部分：尾部信息
            String foot = "\r\n--"+boundary+"--\r\n";
            out.write(foot.getBytes());
            out.flush();
            out.close();
            //读取数据
            InputStream is2 = conn.getInputStream();
            StringBuilder resp = new StringBuilder();
            while((len=is2.read(b))!=-1) {
                resp.append(new String(b,0,len));
            }
            return resp.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取带参数二维码的ticket
     * @return
     * by 罗召勇 Q群193557337
     */
    public static String getQrCodeTicket() {
        String at = getAccessToken();
        String url="https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="+at;
        //生成临时字符二维码
        String data="{\"expire_seconds\": 600, \"action_name\": \"QR_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": \"llzs\"}}}";
        String result = HttpUtils.doPost(url, data);
        //String ticket = JSONObject.fromObject(result).getString("ticket");
        String ticket = JSONObject.parseObject(result).getString("ticket");
        return ticket;
    }

    /**
     * 获取用户的基本信息
     * @return
     */
    public static String getUserInfo(String openid) {
        String url="https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
        url = url.replace("ACCESS_TOKEN", getAccessToken()).replace("OPENID", openid);
        String result = HttpUtils.doGet(url);
        return result;
    }

    public static String getOpenId(HttpServletRequest request) {
        //获取回调url返回的code
        String code = request.getParameter("code");
        //获取微信授权accessToken的请求路径
        String tokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?" +
                "appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
        tokenUrl = tokenUrl.replace("APPID",APPID).replace("SECRET",APPSECRET).replace("CODE",code);

        //获取accessToken和用户OpenId
        String result = HttpUtils.doGet(tokenUrl);
        System.out.println("查到的信息:"+result);
        //获取accessToken
        String access_token = JSONObject.parseObject(result).getString("access_token");
        String openId = JSONObject.parseObject(result).getString("openid");
        System.out.println("获取到的openId是:"+openId);

        //第四步：拉取用户信息(需scope为 snsapi_userinfo)
        //获取用户信息 昵称 位置 地址等 --如果只需要openiD的话这一步不需要了
        //String getUserInfoUrl = " https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
        //getUserInfoUrl = getUserInfoUrl.replace("ACCESS_TOKEN",access_token).replace("OPENID",openId);
        //String result2 = HttpUtils.doGet(getUserInfoUrl);
        //String nickname = JSONObject.parseObject(result2).getString("nickname");
        return openId;

    }
}
