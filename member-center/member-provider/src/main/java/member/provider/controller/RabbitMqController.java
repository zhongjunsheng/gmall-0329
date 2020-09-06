//package member.provider.controller;
//
//import member.provider.biz.middleware.rabbitmq.MsgProducer;
//import member.provider.common.globalException.ResultBody;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class RabbitMqController {
//
//    @Autowired
//    private MsgProducer msgProducer;
//
//    @RequestMapping("mq")
//    public ResultBody mq(){
//        msgProducer.SendMsg("direct_exchange","direct","这是精确匹配测试--------with  confirm ");
//        return ResultBody.success();
//    }
//
//
//}
