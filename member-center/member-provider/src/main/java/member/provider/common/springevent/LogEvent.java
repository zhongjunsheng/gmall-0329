package member.provider.common.springevent;

import org.springframework.context.ApplicationEvent;

public class LogEvent  extends ApplicationEvent {

    private String name;

    public String getName() {
        return name;
    }

    public LogEvent setName(String name) {
        this.name = name;
        return this;
    }
    public LogEvent(String name) {
        super(name);
        this.name = name;
    }
}
