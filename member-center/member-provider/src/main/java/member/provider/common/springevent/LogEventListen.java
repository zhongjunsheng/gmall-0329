package member.provider.common.springevent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class LogEventListen {

    private static final Logger log  = LoggerFactory.getLogger(LogEventListen.class);

    //事件监听
    //@Async
    @EventListener(LogEvent.class)
    public void listen(LogEvent event){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("gggg=======");
        System.out.println(Thread.currentThread().getName());
        int a = 1/0;
    }
}
