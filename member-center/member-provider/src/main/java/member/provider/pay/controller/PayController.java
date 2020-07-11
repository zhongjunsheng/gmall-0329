package member.provider.pay.controller;


import com.alipay.api.AlipayApiException;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import member.provider.common.globalException.ResultBody;
import member.provider.pay.AlipayTemplate;
import member.provider.pay.PayAsyncVo;
import member.provider.pay.PayVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayController {

    @Autowired
    private AlipayTemplate alipayTemplate;


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
        payVo.setTotal_amount("200");
        payVo.setSubject("谷粒商城支付测试");
        payVo.setBody("支付平台");
        //提交订单的同时会跳到支付页面 此接口 页面都是阿里的，调用之后会回调支付成功接口(pay/success)
        String form = this.alipayTemplate.aliPcPay(payVo);
        System.out.println("支付页面=============================================");
        System.out.println(form);
    }


    /**
     * 支付成功后支付宝的回调路径
     * @param payAsyncVo 回传的参数以表单的形式?xxx 注意不要加@RequestBody
     * @return
     */
    @PostMapping("pay/success")
    public ResultBody paySuccess(PayAsyncVo payAsyncVo){

        System.out.println(payAsyncVo.toString());

        //成功支付后的操作
        //真正的减库存
        //加积分
        //修改订单状态
        return ResultBody.success(payAsyncVo);
    }


}
