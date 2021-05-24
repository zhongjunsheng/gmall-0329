package member.provider.common.springevent;

import member.center.com.api.UserService;
import member.center.com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogEventPublishController {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private UserService  userService;

    @RequestMapping("publish")
    @Transactional(rollbackFor = Exception.class)
    public String publish(String name){
        LogEvent event = new LogEvent(name);
        System.out.println(Thread.currentThread().getName());
        User user = new User();
        user.setUsername("pppp888");
        user.setPwd("99999");
        userService.save(user);
        //发布事件-- 默认就是异步事件 不需添加 @Async注解 监听者事务和这个是独立事务  互不影响
        applicationContext.publishEvent(event);
        return "ggggg";
    }


}
