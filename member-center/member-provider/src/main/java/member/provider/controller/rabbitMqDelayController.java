//package member.provider.controller;
//
//import member.center.com.pojo.Order;
//import member.provider.rabbitMq.DelayMsgProducer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//
//@RestController
//public class rabbitMqDelayController {
//
//    @Autowired
//    private DelayMsgProducer delayMsgProducer;
//
//    @RequestMapping("/send")
//    public String sendMsg(){
//        Order order = new Order(1,"0847998","这是延迟10s消息");
//        System.out.println("开始发送的延迟消息时间:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//        delayMsgProducer.delayMsgSend(order,"lazy_exchange","lazy.msg");
//        return "send success!";
//    }
//}
