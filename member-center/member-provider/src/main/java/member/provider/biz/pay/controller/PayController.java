package member.provider.biz.pay.controller;


import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import member.provider.common.globalException.ResultBody;
import member.provider.biz.pay.alipay.AliPayConfig;
import member.provider.biz.pay.alipay.AlipayTemplate;
import member.provider.biz.pay.alipay.PayAsyncVo;
import member.provider.biz.pay.alipay.PayVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PayController {

    @Autowired
    private AlipayTemplate alipayTemplate;
    @Autowired
    private AliPayConfig aliPayConfig;


    /**
     * 订单确认
     * @return
     */
    @RequestMapping("confirm")
    public Object confirm(){
        return ResultBody.success();
    }



    /**
     * 订单提交
     * @return
     */
    @RequestMapping("submit")
    public Object submit(){

        //1.订单提交
        //submit();

        try {
            //2.提交后掉支付第三方支付接口(阿里支付或者微信支付)
            //掉阿里接口跳到支付页面--电脑pc端支付
            doAliPcPay();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return ResultBody.success();
    }

    private void doAliPcPay() throws AlipayApiException {
        PayVo payVo = new PayVo();
        payVo.setOut_trade_no(IdWorker.getIdStr());
        payVo.setTotal_amount("100");
        payVo.setSubject("谷粒商城h5支付测试");
        payVo.setBody("支付平台");
        //提交订单的同时会跳到支付页面 此接口 页面都是阿里的，调用之后会回调支付成功接口(pay/success)
         String form = this.alipayTemplate.aliPcPay(payVo);
        //String form = this.alipayTemplate.aliAppPay(payVo);
        //String form = this.alipayTemplate.aliH5ay(payVo);
        System.out.println("支付页面=============================================");
        System.out.println(form);
    }


    /**
     * 支付成功后支付宝的回调路径
     * @param payAsyncVo 回传的参数以表单的形式?xxx 注意不要加@RequestBody
     * @return
     */
    @PostMapping("pay/success")
    public ResultBody paySuccess(HttpServletRequest request,PayAsyncVo payAsyncVo){
        System.out.println("支付回调的回传数据:"+payAsyncVo.toString());
        //1.参数装到map中
        Enumeration<String> names = request.getParameterNames();
        Map<String, String> map = new HashMap<>();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String value = request.getParameter(name);
            map.put(name, value);
        }

        //2.异步通知验签及数据校验
        boolean flag = psyIsSuccess(map,payAsyncVo);

        //3.TODO 成功支付后的操作(异步处理)
        if(flag) {
            //3.1.真正的减库存
            //3.2.加积分
            //3.3.修改订单状态为支付成功
        }

        return ResultBody.success();
    }



    private boolean psyIsSuccess(Map<String, String> map, PayAsyncVo payAsyncVo) {
        //2.1异步通知验签
        boolean isSuccess = false; //调用SDK验证签名
        try {
            isSuccess = AlipaySignature.rsaCheckV1(map, aliPayConfig.getAlipay_public_key(), aliPayConfig.getCharset(), aliPayConfig.getSign_type());
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        if(!isSuccess){
            System.out.println("支付宝-验证签名失败");
            return false;

        }

        //2.2验证 app_id 是否为该商户本身。
        if (!aliPayConfig.getApp_id().equals(payAsyncVo.getApp_id())){
            System.out.println("appId不一致");
            return  false;

        }
        //2.3商户需要验证该通知数据中的 out_trade_no 是否为商户系统中创建的订单号；

        //2.4判断 total_amount 是否确实为该订单的实际金额（即商户订单创建时的金额）；

        //2.5校验通知中的 seller_id 是否为 out_trade_no 这笔单据的对应的操作方（有的时候，一个商户可能有多个 seller_id)
        return true ;

    }



}
