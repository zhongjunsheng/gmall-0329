package member.provider.middleware.rabbitmq;//package member.provider.rabbitMq;
//
//import com.rabbitmq.client.Channel;
//import member.center.com.pojo.Order;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.amqp.support.AmqpHeaders;
//import org.springframework.messaging.handler.annotation.Headers;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Map;
//
///**
// * 此消费方式为非注解式
// */
//@Component
//public class MsgConsumer {
//
//    //监听消息
//    @RabbitListener(queues = {"direct_queue"})  //监听的队列
//    public void  getDirectMsg(String msg, Channel changel, Message message) throws Exception{
//
//        try {
//            //消息消费确认  --Cack 确认
//            //告诉服务器说明这条消息以及被消费了，否则服务器会以为消息没有被消费 会继续发送
//            //changel.basicQos(1000);;//消费信息限流
//            changel.basicQos(0,3,false); //表示一次接受消息最多3条 消费端确认后broker再推送过来
//            System.out.println("用户1收到的精确匹配消息是："+msg);
//            changel.basicAck(message.getMessageProperties().getDeliveryTag(),false);//表示这条消息已消费，false代表不批量消费
//        } catch (IOException e) {
//            e.printStackTrace();
//            //消费失败 --丢弃消息 --Nack 不确认
//            changel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);
//        }
//    }
//
//
//    @RabbitListener(queues = {"topic_queue"})  //监听的队列
//    public void  getTopicMsg(String msg, Channel changel, Message message) throws Exception{
//        System.out.println("用户1收到的模糊消息是："+msg);
//        try {
//            //消息消费确认  --Cack 确认
//            //告诉服务器说明这条消息以及被消费了，否则服务器会以为消息没有被消费 会继续发送
//            changel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
//        } catch (IOException e) {
//            e.printStackTrace();
//            //消费失败 --丢弃消息 --Nack 不确认
//            changel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);
//        }
//    }
//
//    @RabbitListener(queues = {"fanout_queue"})  //监听的队列
//    public void  getFanoutMsg2(String msg, Channel changel, Message message) throws Exception{
//        System.out.println("用户1收到的广播消息是："+msg);
//        try {
//            //消息消费确认  --Cack 确认
//            //告诉服务器说明这条消息以及被消费了，否则服务器会以为消息没有被消费 会继续发送
//            changel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
//        } catch (IOException e) {
//            e.printStackTrace();
//            //消费失败 --丢弃消息 --Nack 不确认
//            changel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);
//        }
//    }
//
//
//
//}
