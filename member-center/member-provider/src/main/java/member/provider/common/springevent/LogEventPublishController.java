package member.provider.common.springevent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogEventPublishController {

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping("publish")
    public void publish(String name){
        LogEvent event = new LogEvent(name);
        //发布事件
        applicationContext.publishEvent(event);
    }


}
