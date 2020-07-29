//package member.provider.config;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.Queue;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.HashMap;
//import java.util.Map;
//
//
///**
// * 延时队列配置(不装插件的配置)
// * 延时队列消费通过死信交换机转发到死信队列从而实现延时消费
// *
// * ttl   ----   dead
// */
//@Configuration
//public class RabbitMqDelayConfig {
//
//    /**
//     * 1.ttl队列配置转发路由机交换机信息
//     * @return
//     */
//    @Bean("ORDER-TTL-QUEUE")
//    public Queue ttlQueue(){
//        Map<String, Object> map = new HashMap<>(16);
//        //ttl队列绑定的转发死信交换机(可以同一个交互机也可以不同一个)
//        map.put("x-dead-letter-exchange", "GMALL-ORDER-EXCHANGE");
//        //ttl队列绑定的转发死信路由
//        map.put("x-dead-letter-routing-key", "order.dead");
//        //延时时间
//        map.put("x-message-ttl", 120000);
//        return new Queue("ORDER-TTL-QUEUE", true, false, false, map);
//    }
//
//
//    /**
//     * 1.1ttl队列与交换机路由的绑定
//     * @return
//     */
//    @Bean("ORDER-TTL-BINDING")
//    public Binding ttlBinding(){
//
//        return new Binding("ORDER-TTL-QUEUE", Binding.DestinationType.QUEUE, "GMALL-ORDER-EXCHANGE", "order.ttl", null);
//    }
//
//
//
//
//
//    /**
//     * 2.死信队列声明
//     * @return
//     */
//    @Bean("ORDER-DEAD-QUEUE")
//    public Queue dlQueue(){
//        return new Queue("ORDER-DEAD-QUEUE", true, false, false, null);
//    }
//
//
//    /**
//     * 2.1死信队列与交换机 路由的绑定配置
//     * @return
//     */
//    @Bean("ORDER-DEAD-BINDING")
//    public Binding deadBinding(){
//
//        return new Binding("ORDER-DEAD-QUEUE", Binding.DestinationType.QUEUE, "GMALL-ORDER-EXCHANGE", "order.dead", null);
//    }
//
//}
