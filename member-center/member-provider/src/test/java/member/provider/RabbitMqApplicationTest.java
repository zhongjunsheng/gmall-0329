package member.provider;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.misc.Hash;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqApplicationTest  {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    public void directSendTest(){
        rabbitTemplate.convertAndSend("direct_exchange","direct","这是精确匹配测试");
        System.out.println("success");


    }

    @Test
    public void TopicSendTest(){
        rabbitTemplate.convertAndSend("topic_exchange","springboot.allen","这是模糊匹配测试");
        System.out.println("发送完毕");

    }

    @Test
    public void fanoutSendTest(){
        //会投递到所有绑定fanout_exchange交换机的队列 不需要路由
        rabbitTemplate.convertAndSend("fanout_exchange",null,"这是广播测试不需要路由key");
        System.out.println("发送完毕");

    }

    @Test
    public void Send(){
        Map<String,Object> map = new HashMap<>();
        map.put("msg","传map测试!");
        rabbitTemplate.convertAndSend("exchange","allen.pyh",map);
        System.out.println("发送完毕");
    }

}
