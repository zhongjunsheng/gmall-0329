//package member.provider.biz.middleware.redismq;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.listener.PatternTopic;
//import org.springframework.data.redis.listener.RedisMessageListenerContainer;
//import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
//
///**
// * redis 的消息发布/订阅功能配置
// */
//@Configuration
//public class RedisChannelConfig {
//    @Bean
//    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
//                                            MessageListenerAdapter listenerAdapter) {
//        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        //添加监听的消息通道messagepush和messagepush3
//        container.addMessageListener(listenerAdapter, new PatternTopic("messagepush"));
//        container.addMessageListener(listenerAdapter, new PatternTopic("messagepush3"));
//        //这个container 可以添加多个 messageListener
//        return container;
//    }
//
//    @Bean
//    MessageListenerAdapter listenerAdapter(MessageReceive receiver) {
//        //这个地方 是给messageListenerAdapter 传入一个消息接受的处理器，利用反射的方法调用“receiveMessage”
//        //也有好几个重载方法，这边默认调用处理器的方法 叫handleMessage 可以自己到源码里面看
//        return new MessageListenerAdapter(receiver, "receiveMessage");
//    }
//
//    @Bean //注入操作数据的template(这里不需要操作redis数据,和消息队列功能无关)
//    StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
//        return new StringRedisTemplate(connectionFactory);
//    }
//
//}