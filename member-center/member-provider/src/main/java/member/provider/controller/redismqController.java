//package member.provider.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class redismqController {
//
//    @Autowired
//    private StringRedisTemplate redisTemplate;
//
//    @RequestMapping("redis")
//    public String redis(){
//        redisTemplate.convertAndSend("messagepush", "Hello message !");
//        redisTemplate.convertAndSend("messagepush3", "Hello message3 !");
//        return "redis";
//    }
//}
