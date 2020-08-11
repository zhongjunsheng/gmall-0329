package member.provider.biz.middleware.rabbitmq;//package member.provider.rabbitMq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 普通常用的消息发送类型
 */
@Component
@Slf4j
public class MsgProducer implements RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnCallback  {


    /**
     * RabbitMQ的消息确认有两种。
     *
     * 第一种: 消息发送确认。这种是用来确认生产者将消息发送给交换器，交换器传递给队列的过程中，消息是否成功投递。发送确认分为两步，一是确认是否到达交换器，二是确认是否到达队列。
     *
     * 第二种: 消费接收确认。这种是确认消费者是否成功消费了队列中的消息。
     *
     * 1、ConfirmCallback
     *
     * 　确认消息发送成功: 通过实现ConfirmCallBack接口，消息发送到交换器Exchange后触发回调，使用该功能需要开启确认，
     *   spring-boot中配置如下：
     * 　　旧：spring.rabbitmq.publisher-confirms = true
     *    新：spring.rabbitmq.publisher-confirm-type: correlated
     *
     * 2、ReturnCallback
     *
     * 　通过实现ReturnCallback接口,如果消息从交换器发送到对应队列时触发（比如根据发送消息时指定的routingKey找不到队列时会触发），
     *  使用该功能需要开启确认，spring-boot中配置如下：spring.rabbitmq.publisher-returns = true
     *
     *
     *
     * 消息消费确认
     * 　　消费确认模式有三种：NONE、AUTO、MANUAL。
     *
     * 　　开启手动确认需要在配置中加入：spring.rabbitmq.listener.direct.acknowledge-mode=manual
     *
     * 　　消息在处理失败后将再次返回队列，重新尝试消费，如果再次失败则直接拒绝。
     *
     */


    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void SendMsg(String exchange, String rountkey,Object context) {
        rabbitTemplate.setReturnCallback(this);
        rabbitTemplate.setConfirmCallback(this);
        CorrelationData data = new CorrelationData();
        //data.setId("123456");  //消息的唯一标识
        rabbitTemplate.convertAndSend(exchange, rountkey,context,data); //队列名 和消息
    }


    /**
     *  消息入队顺序是  ----先入exchange再到queue
     *   所以 confirm  和return 的顺序是 : 先confim(投递到exchange) 再到returnMessage
     */

    /**
     *  消息投递到交换机时的回调---成功与否都会回调. 另外 只要交换机存在 这ACK一定是true
     *  因此想用ack的值来进行相关消息发送异常处理时务必用广播模式(避免了交换机和路由key没有绑定关系)
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("====================  confirm回调 ========================");
        //基于广播的方式才正确
        if (!ack) {
            //消息重发或者---处理丢失 --异常处理
            //放入数据库 用定时任务轮询再次发送
            System.out.println("消息投递失败ack:" + ack +"============消息发送失败原因:" + cause );
            System.out.println("消息投递失败ack:" + ack);
        } else {
            System.out.println("消息发送成功-----消息投递成功ack:" + ack);
        }
    }


    //消息从交换器发送到对应队列失败时触发--注意是失败才会回调
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {

        System.out.println("====================  return回调 ========================");
        System.out.println("消息主体message: " + message);
        System.out.println("消息replyCode: " + replyCode);
        System.out.println("消息replyMsg: " + replyText);
        System.out.println("消息使用的交换器: " + exchange);
        System.out.println("消息使用的路由键: " + routingKey);
        System.out.println("\t");
        System.out.println("##########################################################");
        System.out.println("\t");
    }




}
