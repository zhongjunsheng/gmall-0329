package member.provider.middleware.rabbitmq;//package member.provider.rabbitMq;
//
//import org.springframework.amqp.core.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * 声明式  ---实际生产不推荐  推荐使用注解式消费监听 在消费端用注解式绑定即可 详情见 AnnocationConsumer 这个类
// * 队列与交换机的绑定关系
// */
//@Configuration
//public class RabbitMqConfig {
//
//    /**
//     * 交换机类型 声明
//     * @return
//     */
//
//    //直连交换机 --精确匹配绑定队列
//    @Bean
//    public DirectExchange directExchange(){
//        return new DirectExchange("direct_exchange");
//    }
//
//    //创建直连队列
//    @Bean
//    public Queue  directExchangeQueue() {
//        return QueueBuilder.durable("direct_queue").build();
//    }
//
//    //交换机和队列的绑定--建立关系
//    @Bean
//    public Binding directBind(Queue  directExchangeQueue,DirectExchange directExchange){
//        return BindingBuilder.bind(directExchangeQueue).to(directExchange).with("direct_key");
//
//    }
//
//
//    /**
//     * 模糊交换配置
//     * @return
//     */
//    //模糊绑定队列
//    @Bean
//    public TopicExchange  topicExchange(){
//        return new TopicExchange("topic_exchange");
//    }
//
//    //创建模糊队列
//    @Bean
//    public Queue  topicExchangeQueue() {
//        return QueueBuilder.durable("topic_queue").build();
//    }
//
//    @Bean
//    public Binding topicBind(Queue  topicExchangeQueue,TopicExchange  topicExchange){
//        return BindingBuilder.bind(topicExchangeQueue).to(topicExchange).with("topic_key.#");
//
//    }
//
//
//
//
//    //不需要匹配---广播消息
//    @Bean
//    public FanoutExchange fanoutExchange(){
//        return  new FanoutExchange("fanout_exchange");
//    }
//
//    //创建广播队列
//    @Bean
//    public Queue  fanoutExchangeQueue() {
//        return QueueBuilder.durable("fanout_queue").build();
//    }
//
//    @Bean
//    public Binding fanoutBind(Queue fanoutExchangeQueue,FanoutExchange fanoutExchange){
//        return BindingBuilder.bind(fanoutExchangeQueue).to(fanoutExchange);  //广播不需要路由key
//
//    }
//
//
//
//
//
//    /**
//     * 延时队列与交换机的绑定
//     * @return
//     */
//    @Bean
//    public TopicExchange  lazyExchange(){
//        TopicExchange topicExchange = new TopicExchange("lazy_exchange", true, false);
//        topicExchange.setDelayed(true);  //声明为延时队列
//        return topicExchange;
//    }
//    @Bean
//    public Queue  lazyExchangeQueue() {
//
//        return QueueBuilder.durable("lazy_queue").build();
//    }
//
//    @Bean
//    public Binding lazyBind(Queue  lazyExchangeQueue,TopicExchange  lazyExchange){
//        return BindingBuilder.bind(lazyExchangeQueue).to(lazyExchange).with("lazy.*");
//
//    }
//
//
//}
