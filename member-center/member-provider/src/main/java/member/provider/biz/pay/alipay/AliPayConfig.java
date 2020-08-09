package member.provider.biz.pay.alipay;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "alipay")
public class AliPayConfig {

    /**
     * 在支付宝创建的应用的id
     */
    private   String app_id ;
    /**
     * 商户私钥，您的PKCS8格式RSA2私钥
     */
    private  String merchant_private_key;

    /**
     * 支付宝公钥(商户生产私钥时也会有公钥,商户拿着这个公钥去获取阿里提供的公钥)
     * 查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
     */
    private  String alipay_public_key;

    /**
     * 服务器[异步通知]页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     * 支付宝会悄悄的给我们发送一个请求，告诉我们支付成功的信息
     */
    private  String notify_url;

    /**
     * 页面跳转同步通知页面路径,同步通知，支付成功，一般跳转到成功页
     * 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    private  String return_url;

    /**
     * 签名方式"RSA2"
     */
    private  String sign_type;

    /**
     * 字符编码格式utf-8
     */
    private  String charset;

    /**
     * 支付宝网关:https://openapi.alipaydev.com/gateway.do
     */
    private  String gatewayUrl;
}
