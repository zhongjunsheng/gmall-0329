//package member.provider;
//
//import member.center.com.pojo.Order;
//import member.provider.biz.middleware.rabbitmq.MsgProducer;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class RabbitMqApplicationTest  {
//
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    @Autowired
//    private MsgProducer msgProducer;
//
//
//    /**
//     * 不带回调投递--direct
//     */
//    @Test
//    public void directSendTest(){
//        for (int i = 0; i <20 ; i++) {
//            rabbitTemplate.convertAndSend("direct_exchange","direct","这是精确匹配测试" + i);
//        }
//        System.out.println("success");
//
//    }
//
//
//    /**
//     * 带回调投递--direct
//     */
//    @Test
//    public void directSendWithConfirm(){
//        msgProducer.SendMsg("direct_exchange","direct","这是精确匹配测试--------with  confirm ");
//        System.out.println("success");
//
//    }
//
//
//    @Test
//    public void TopicSendTest(){
//        rabbitTemplate.convertAndSend("topic_exchange","springboot.allen","这是模糊匹配测试");
//        System.out.println("发送完毕");
//
//    }
//
//
//    /**
//     * 带回调投递--topic
//     */
//    @Test
//    public void TopicSendWithConfirm(){
//        msgProducer.SendMsg("topic_exchange","springboot.allen","这是模糊匹配测试");
//        System.out.println("发送完毕");
//
//    }
//
//
//
//
//
//
//    @Test
//    public void fanoutSendTest(){
//        //会投递到所有绑定fanout_exchange交换机的队列 不需要路由
//        for (int i = 0; i <20 ; i++) {
//            rabbitTemplate.convertAndSend("fanout_exchange",null,"这是广播测试不需要路由key" + i);
//        }
//
//        System.out.println("发送完毕");
//
//    }
//
//
//    @Test
//    public void fanoutSendWithConfirm(){
//        //会投递到所有绑定fanout_exchange交换机的队列 不需要路由
//        for (int i = 0; i <20 ; i++) {
//            msgProducer.SendMsg("fanout_exchange",null,"这是广播测试不需要路由key");
//        }
//        System.out.println("发送完毕");
//
//    }
//
//
//
//
//
//
//    @Test
//    public void Send(){
//        Map<String,Object> map = new HashMap<>();
//        map.put("msg","传map测试!");
//        rabbitTemplate.convertAndSend("exchange","allen.pyh",map);
//        System.out.println("发送完毕");
//    }
//
//
//    @Test
//    public void SendOrderMsg(){
//       Order order = new Order(1,"10086","对象传参测试");
//        rabbitTemplate.convertAndSend("order_exchange","order.test",order);
//        System.out.println("发送完毕");
//    }
//
//}
