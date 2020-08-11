package member.provider.biz.middleware.rabbitmq;//package member.provider.rabbitMq;
//
//import member.center.com.pojo.Order;
//import org.springframework.amqp.AmqpException;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.core.MessageDeliveryMode;
//import org.springframework.amqp.core.MessagePostProcessor;
//import org.springframework.amqp.rabbit.connection.CorrelationData;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
///**
// * 延迟消息发送---代码
// */
//@Component
//public class DelayMsgProducer implements RabbitTemplate.ReturnCallback,RabbitTemplate.ConfirmCallback {
//
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    public void delayMsgSend(Order order, String exchange, String rount_key) {
//
//        /**
//         *  消息的可靠发送步骤
//         *
//         *  1.调用Mq api 发 送消息前 先把消息本地入库(mysql) 并打上未发送的标识
//         *  2.判断roker server的消息ack情况
//         *  3.如果 成功 ack则把数据库的标识改为发送成功/定时任务轮询发送
//         */
//        System.out.println("发送内容 : " + order);
//        rabbitTemplate.setReturnCallback(this);
//        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
//            if (!ack) {
//                //消息发送失败  重发或者---处理丢失 --异常处理
//                System.out.println("延迟消息发送失败" + cause + correlationData.toString());
//                //System.out.println("消息发送失败");
//                System.out.println("ack:" + ack);
//            } else {
//                //消息成功发送且broker成功收到
//                System.out.println("延迟消息发送成功" + cause + correlationData.toString());
//                System.out.println("ack:" + ack);
//
//            }
//        });
//
//        //id + 时间戳 全局唯一
//        CorrelationData correlationData = new CorrelationData("12345678909"+new Date());
//        //发送消息时指定 header 延迟时间
//        rabbitTemplate.convertAndSend(exchange, rount_key, order,
//                message -> {
//                    //设置消息持久化
//                    message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
//                    //message.getMessageProperties().setHeader("x-delay", "6000");
//                    message.getMessageProperties().setDelay(10000);  //延迟10秒后发送
//                    return message;
//                }, correlationData);
//    }
//
//
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
//}
