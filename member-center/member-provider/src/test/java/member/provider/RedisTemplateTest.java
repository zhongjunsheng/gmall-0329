package member.provider;

import com.alibaba.fastjson.JSON;
import member.provider.Java8Test.User;
import member.provider.common.utils.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTemplateTest {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void stringTest(){
        redisTemplate.opsForValue().set("address","GZ");
        System.out.println(redisTemplate.opsForValue().get("address"));

        redisTemplate.opsForValue().set("love","皮皮");
        System.out.println(redisTemplate.opsForValue().get("love"));

        User user = new User();
        user.setAge(11);
        user.setName("allen");
        user.setSlary(35000d);
        String json = JSON.toJSONString(user);
        redisTemplate.opsForValue().set("json",json);
        redisTemplate.opsForValue().get("json");
        User u = JsonUtils.toPo(User.class, redisTemplate.opsForValue().get("json"));
        System.out.println(u);
    }
    
    
    @Test
    public void stringTest2(){
       redisTemplate.opsForValue().set("test", "100",60*10, TimeUnit.SECONDS);//向redis里存入数据和设置缓存时间

       redisTemplate.boundValueOps("test").increment(-1);//val做-1操作

       redisTemplate.opsForValue().get("test"); //根据key获取缓存中的val

       redisTemplate.boundValueOps("test").increment(1);//val +1

       redisTemplate.getExpire("test");  //根据key获取过期时间

       redisTemplate.getExpire("test",TimeUnit.SECONDS); //根据key获取过期时间并换算成指定单位

       redisTemplate.delete("test");//根据key删除缓存

       redisTemplate.hasKey("546545");//检查key是否存在，返回boolean值 

       redisTemplate.opsForSet().add("red_123", "1","2","3");//向指定key中存放set集合

       redisTemplate.expire("red_123",1000 , TimeUnit.MILLISECONDS);//设置过期时间

       redisTemplate.opsForSet().isMember("red_123", "1"); //根据key查看集合中是否存在指定数据

       redisTemplate.opsForSet().members("red_123");//根据key获取set集合
    }

    @Test
    public void hash(){
        redisTemplate.opsForHash().put("allen","wife","pp");
        String  wifeName = redisTemplate.opsForHash().get("allen", "wife").toString();
        System.out.println(wifeName);
    }

    @Test
    public void  list(){
        //redisTemplate.opsForList().leftPush("parent","myparent");
        //String parent = redisTemplate.opsForList().leftPop("parent");
        //String parent2 = redisTemplate.opsForList().rightPop("parent");
        //System.out.println(parent);  //
        //System.out.println(parent2);  //null
        //leftPush 则右pop取第一个
        redisTemplate.opsForList().rightPush("list","1");
        redisTemplate.opsForList().rightPush("list","2");
        redisTemplate.opsForList().rightPush("list","3");
        redisTemplate.opsForList().rightPush("list","4");
        System.out.println(redisTemplate.opsForList().range("list", 0, -1));
        System.out.println( redisTemplate.opsForList().leftPop("list"));
        System.out.println( redisTemplate.opsForList().leftPop("list"));
        System.out.println( redisTemplate.opsForList().leftPop("list"));
        System.out.println( redisTemplate.opsForList().leftPop("list"));
        System.out.println(redisTemplate.opsForList().range("list", 0, -1));
        //String list1 = redisTemplate.opsForList().rightPop("list");
       // System.out.println(list1);
//        System.out.println(redisTemplate.opsForList().range("list", 0, -1));
//        System.out.println(redisTemplate.opsForList().rightPop("list"));
//        System.out.println(redisTemplate.opsForList().rightPop("list"));
//        System.out.println(redisTemplate.opsForList().rightPop("list"));
//        System.out.println(redisTemplate.opsForList().range("list", 0, -1));

    }
}
