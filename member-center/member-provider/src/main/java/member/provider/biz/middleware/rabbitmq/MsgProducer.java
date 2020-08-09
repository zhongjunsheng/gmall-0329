package member.provider.biz.middleware.rabbitmq;//package member.provider.rabbitMq;
//
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.connection.CorrelationData;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//
///**
// * 普通常用的消息发送类型
// */
//@Component
//public class MsgProducer implements RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnCallback  {
//
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    public void SendTest(Object context, String exchange, String key) {
//        System.out.println("发送内容 : " + context);
//        rabbitTemplate.setReturnCallback(this);
//        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
//            if (!ack) {
//                //消息重发或者---处理丢失 --异常处理
//                //放入数据库 用定时任务轮询再次发送
//                System.out.println("消息发送失败" + cause + correlationData.toString());
//                //System.out.println("消息发送失败");
//                System.out.println("ack:" + ack);
//            } else {
//                System.out.println("消息发送成功" + cause + correlationData.toString());
//                System.out.println("ack:" + ack);
//
//            }
//        });
//        CorrelationData data = new CorrelationData("123456");
//        //data.setId("123456");  //消息的唯一标识
//        rabbitTemplate.convertAndSend(exchange, key,context,data); //队列名 和消息
//    }
//
//    //处理消息不可路由的异常情况
//    @Override
//    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
//
//        System.out.println("sender return success" + message.toString()+"==="+i+"==="+s1+"==="+s2);
//    }
//
//    @Override
//    public void confirm(CorrelationData correlationData, boolean b, String s) {
//
//        System.out.println("confire:" + b);
//    }
//
//}
