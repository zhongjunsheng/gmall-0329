package member.provider.rabbitMq;

import com.rabbitmq.client.Channel;
import member.center.com.pojo.Order;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Component
public class DelayMsgConsumer {

    /**
     * 延迟消息消费
     * @param order
     * @param changel
     * @param heads
     * @throws Exception
     * @Payload  Order order 用实体接受信息时需要加上注解@Payload  当然可以直接用map来接
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value ="lazy_queue",durable = "true"),  //表示队列信息
            exchange = @Exchange(value = "lazy_exchange",durable = "ture",//表示交换机名称
                    type = "topic",  //交换机信息 direct，topic，fanout
                    delayed = "true", //延迟发送
                    ignoreDeclarationExceptions = "true"),  //支持过滤
            key = "lazy.*"  //表示路由信息
    ))
    public void  getDelayMsg(@Payload Order order, Channel changel, @Headers Map<String,Object> heads) throws Exception{
        System.out.println("收到的延迟消息的时间:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        System.out.println("收到的延迟信息是:"+ order.toString());
        //消息消费ack -- 表示已经消费了
        Long tag = (Long)heads.get(AmqpHeaders.DELIVERY_TAG);
        changel.basicAck(tag,false); //false 表示手动ack
    }

}
