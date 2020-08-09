package member.provider.biz.pay.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConstants;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 电脑pc端支付
 */
@Data
@Component
public class AlipayTemplate {

    @Autowired
    private AliPayConfig aliPayConfig;


    /**
     * 电脑网站Pc端支付
     * @param vo
     * @return
     * @throws AlipayApiException
     */
    public String aliPcPay(PayVo vo) throws AlipayApiException {
        //1、根据支付宝的配置生成一个支付客户端
        AlipayClient alipayClient = new DefaultAlipayClient(aliPayConfig.getGatewayUrl(),
                aliPayConfig.getApp_id(), aliPayConfig.getMerchant_private_key(), AlipayConstants.FORMAT_JSON,
                aliPayConfig.getCharset(), aliPayConfig.getAlipay_public_key(), aliPayConfig.getSign_type());
        //2、创建一个支付请求-- 设置请求参数
        AlipayTradePagePayModel model = new   AlipayTradePagePayModel();
        //商品描述，可空
        model.setBody(vo.getBody());
        //订单名称，必填
        model.setSubject(vo.getSubject());
        //商户订单号，商户网站订单系统中唯一订单号，必填
        model.setOutTradeNo(vo.getOut_trade_no());
        model.setProductCode("FAST_INSTANT_TRADE_PAY");
        //付款金额，必填
        model.setTotalAmount(vo.getTotal_amount());
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(aliPayConfig.getReturn_url());
        alipayRequest.setNotifyUrl(aliPayConfig.getNotify_url());
        alipayRequest.setBizModel(model);
        String form = alipayClient.pageExecute(alipayRequest).getBody();
        //会收到支付宝的响应，响应的是一个页面，只要浏览器显示这个页面，就会自动来到支付宝的收银台页面(和前台对接时把这哥页面给前台返回即可)
        System.out.println("=====================pc端支付===============");
        System.out.println("支付宝的响应："+form);
        return form;
    }


    /**
     * app支付
     * @param vo
     * @return
     */
    public String aliAppPay(PayVo vo) {

        //1、实例化客户端,根据支付宝的配置生成一个支付客户端
        AlipayClient alipayClient = new DefaultAlipayClient(aliPayConfig.getGatewayUrl(),
                aliPayConfig.getApp_id(), aliPayConfig.getMerchant_private_key(), AlipayConstants.FORMAT_JSON,
                aliPayConfig.getCharset(), aliPayConfig.getAlipay_public_key(), aliPayConfig.getSign_type());
        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setBody(vo.getBody());
        model.setSubject(vo.getSubject());
        model.setOutTradeNo(vo.getOut_trade_no());
        model.setTimeoutExpress("30m");
        model.setTotalAmount(vo.getTotal_amount());
        model.setProductCode("QUICK_MSECURITY_PAY");
        request.setBizModel(model);
        request.setNotifyUrl(aliPayConfig.getNotify_url());
        String form="";
        try {
            //这里和普通的接口调用不同，app支付使用的是sdkExecute
            form = alipayClient.sdkExecute(request).getBody();
            System.out.println("=================app端支付=====================");
            //就是orderString 可以直接给客户端请求，无需再做处理。
            System.out.println(form);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return form;
    }


    /**
     * 手机网站支付 ---H5支付
     * @param vo
     * @return
     */
    public String aliH5Pay(PayVo vo) {
        //实例化客户端
        //1、根据支付宝的配置生成一个支付客户端
        AlipayClient alipayClient = new DefaultAlipayClient(aliPayConfig.getGatewayUrl(),
                aliPayConfig.getApp_id(), aliPayConfig.getMerchant_private_key(), AlipayConstants.FORMAT_JSON,
                aliPayConfig.getCharset(), aliPayConfig.getAlipay_public_key(), aliPayConfig.getSign_type());
        //2、创建一个支付请求-- 设置请求参数
        AlipayTradePagePayModel model = new  AlipayTradePagePayModel();
        //商品描述，可空
        model.setBody(vo.getBody());
        //订单名称，必填
        model.setSubject(vo.getSubject());
        //商户订单号，商户网站订单系统中唯一订单号，必填
        model.setOutTradeNo(vo.getOut_trade_no());
        model.setProductCode("QUICK_WAP_PAY");
        //付款金额，必填
        model.setTotalAmount(vo.getTotal_amount());
        AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();//创建API对应的request
        alipayRequest.setReturnUrl(aliPayConfig.getReturn_url());
        alipayRequest.setNotifyUrl(aliPayConfig.getNotify_url());
        alipayRequest.setBizModel(model);
        String form="";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
            System.out.println("==================H5支付===================");
            System.out.println(form);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
       return  form;

    }
}
