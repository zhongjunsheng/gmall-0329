package member.center.com.api;

import member.center.com.pojo.Corn;

public interface ScheduledApi {
    String startTask();
    String changeOrAddTask(Corn corn);
    String endTask(Corn corn);
}
