package member.provider.biz.middleware.rabbitmq;//package member.provider.rabbitMq;


import com.rabbitmq.client.Channel;
import member.center.com.pojo.Order;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


/**
 * 注解式消费,不用写一堆代码将队列和交换机绑定配置- --推荐使用
 */
@Component
public class MsgAnnocationConsumer {




    //直连 --direct 类型
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value ="direct_queue",durable = "true"),  //表示队列信息
            exchange = @Exchange(value = "direct_exchange",durable = "ture",//绑定的交换机名称
                    type = ExchangeTypes.DIRECT,//交换机类型 direct，topic，fanout
                    ignoreDeclarationExceptions = "true"),  //支持过滤
            key = "direct"  //表示路由信息
    ))
    @RabbitHandler
    public void  getDirectMsg(Message message, Channel changel) throws Exception{
        System.out.println("收到的信息是:"+ message.getPayload());
        //消息消费ack -- 表示已经消费了
        Long tag = (Long)message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        //告诉服务器说明这条消息以及被消费了，否则服务器会以为消息没有被消费 会继续发送
        //消息ack  ---- 确认已经消费
        changel.basicAck(tag,false); //mulyiple 表示批量
        //不ack  --最后一个参数 true 表示消息重回队列 一直重试消费,假如一直没有消费成功则会一直刷会导致cpu急剧上升
        //changel.basicNack(tag,false,true);
    }



    //topic 类型
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value ="topic_queue",durable = "true"),  //表示队列信息
            exchange = @Exchange(value = "topic_exchange",durable = "ture",//绑定的交换机名称
                    type = ExchangeTypes.TOPIC,//交换机类型 direct，topic，fanout
                    ignoreDeclarationExceptions = "true"),  //支持过滤
            key = "springboot.*"  //表示路由信息  * hi匹配一个单词  # 匹配多个
    ))
    @RabbitHandler
    public void  getTopicMsg(Message message, Channel changel) throws Exception{
        System.out.println("收到的信息是:"+ message.getPayload());
        //消息消费ack -- 表示已经消费了
        Long tag = (Long)message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        //告诉服务器说明这条消息以及被消费了，否则服务器会以为消息没有被消费 会继续发送
        changel.basicAck(tag,false); //false 表示手动ack
    }


    //fanout 广播 类型
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value ="fan_queue",durable = "true"),  //表示队列信息
            exchange = @Exchange(value = "fanout_exchange",durable = "ture",//绑定的交换机名称
                    type = ExchangeTypes.FANOUT,//交换机类型 direct，topic，fanout
                    ignoreDeclarationExceptions = "true") //支持过滤
    ))
    //@RabbitHandler
    public void  getfanoutMsg(Message message, Channel changel) throws Exception{
        System.out.println("收到的信息是:"+ message.getPayload()+"消费者1");
        //消息消费ack -- 表示已经消费了
        Long tag = (Long)message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        //告诉服务器说明这条消息以及被消费了，否则服务器会以为消息没有被消费 会继续发送
        changel.basicAck(tag,false); //false 表示手动ack
    }


    /**
     * map接受数据
     * @param map
     * @param message
     * @param changel
     * @throws Exception
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value ="queue",durable = "true"),  //表示队列信息
            exchange = @Exchange(value = "exchange",durable = "ture",//绑定的交换机名称
                    type = ExchangeTypes.TOPIC,//交换机类型 direct，topic，fanout
                    ignoreDeclarationExceptions = "true"),  //支持过滤
            key = "allen.*"  //表示路由信息
    ))
    public void  getMsg(Map<String, Object> map,Message message, Channel changel) throws Exception{
        System.out.println("用户1收到的信息是:"+ map.get("msg"));
        //消息消费ack -- 表示已经消费了
        Long tag = (Long)message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        changel.basicAck(tag,false); //false 表示手动ack
    }




    /**
     * 以对象的信息传信息
     * @param order
     * @param changel
     * @throws Exception
     */

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value ="order_queue",durable = "true"),  //表示队列信息
            exchange = @Exchange(value = "order_exchange",durable = "ture",//表示交换机名称
                    type = "topic",  //交换机信息 direct，topic，fanout
                    ignoreDeclarationExceptions = "true"),  //支持过滤
            key = "order.*"  //表示路由信息
    ))
    public void  getOrderMsg(@Payload Order order, Channel changel, @Headers Map<String,Object> heads) throws Exception{
        System.out.println("收到消息的时间:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        System.out.println("收到的信息是:"+ order.toString());
        //消息消费ack -- 表示已经消费了
        //Long tag = (Long)message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        Long tag = (Long)heads.get(AmqpHeaders.DELIVERY_TAG);
        changel.basicAck(tag,false); //false 表示手动ack
    }

}
