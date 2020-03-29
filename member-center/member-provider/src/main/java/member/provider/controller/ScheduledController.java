package member.provider.controller;

import member.center.com.api.ScheduledApi;
import member.center.com.pojo.Corn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduledController {

   /* @Autowired
    private ScheduledApi scheduledApi;

    @RequestMapping("START")
    public String startTask(){

       return scheduledApi.startTask();
    }
    @RequestMapping("UPDATE")
    public String updateTask(){

        return scheduledApi.changeOrAddTask(new Corn());
    }
    @RequestMapping("START")
    public String endTask(){

        return scheduledApi.endTask(new Corn());
    }*/
}