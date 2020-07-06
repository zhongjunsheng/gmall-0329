package member.provider.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;


/**
 * 监听事件异步配置
 */
@Configuration
public class AsycEventConfig {

    @Bean
    public ApplicationEventMulticaster applicationEventMulticaster() {
        SimpleApplicationEventMulticaster event = new SimpleApplicationEventMulticaster();
        event.setTaskExecutor(new SimpleAsyncTaskExecutor());
        return event;
    }
}
