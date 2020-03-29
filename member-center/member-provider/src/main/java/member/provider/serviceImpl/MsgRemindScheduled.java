package member.provider.serviceImpl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import member.center.com.api.CornService;
import member.center.com.api.ScheduledApi;
import member.center.com.pojo.Corn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;


/**
 * 通过controller掉此接口来实现定时任务的动态 添加跟新和停止
 */
//@EnableScheduling
@Service
public class MsgRemindScheduled implements ScheduledApi, SchedulingConfigurer {

    private final static Logger logger = LoggerFactory.getLogger(MsgRemindScheduled.class);
    private Map<String,ScheduledFuture<?>> futureMap = new HashMap<String,ScheduledFuture<?>>();
    private ScheduledFuture<?> future;

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;
    @Autowired(required = false)
    CornService cornApi;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        //项目启动时初始化定时任务
        //startTask();
    }

    //启动定时器
    @Override
    public String startTask(){

        //获取数据库所有corn表达式
        List<Corn> allCorns = cornApi.getAllCorn();
        if(CollectionUtils.isNotEmpty(allCorns)) {
            for (Corn corn : allCorns) {
                futureSet(corn);
            }
        }

        logger.info("startTask success!");
        return "startTask";
    }


    //停止指定定时任务
    @Override
    public String endTask(Corn corn){
        logger.info("长度是：" + futureMap.size());
        if(futureMap.size() > 0){
            if(futureMap.containsKey(corn.getUserCode())){
                //map.keySet()返回的是所有key的值
                ScheduledFuture<?> f = futureMap.get(corn.getUserCode());//得到每个key多对用value的值
                if(!f.isCancelled()){
                    f.cancel(true); //剔除执行定时任务线程--终止线程
                    logger.info("Canceled result is :{}",f.isCancelled());
                    futureMap.remove(corn.getUserCode());
                }
            }
        }
        logger.info("endTask success!");
        return "endTask";
    }

    //更新或添加定时任务
    @Override
    public String changeOrAddTask(Corn corn){
        //停止定时器再更新或添加
        endTask(corn);
        if( corn != null) {
            futureSet(corn);
        }
        logger.info("changeOrAddTask success!");
        return "changeOrAddTask";
    }

    public void futureSet(Corn corn){
        logger.info(corn.getCornCode());
        future = threadPoolTaskScheduler.schedule(todo(corn), getTrigger(corn)); //相当于一条定时任务
        //用type当key，定时器当value，相同key会覆盖
        logger.info("key为："+corn.getUserCode()+"的value改为"+future);
        futureMap.put(corn.getUserCode(),future);
    }


    //业务执行逻辑
    private Runnable todo(Corn corn){
        return () -> {
            if (corn.getUserCode().equals("allen")) {
                System.out.println(Thread.currentThread().getName() + "任务执行时间:"
                        + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) +
                        "这是任务的userCode:" + corn.getUserCode() + "====" + corn.getCornCode());
            }
        };
    }

    //动态corn表达式获取
    private Trigger getTrigger(Corn corn){
        return triggerContext -> {
            // 任务触发,获取任务动态的执行时间
            CronTrigger trigger = new CronTrigger(corn.getCornCode());
            Date nextExec = trigger.nextExecutionTime(triggerContext);
            return nextExec;
        };
    }


}
