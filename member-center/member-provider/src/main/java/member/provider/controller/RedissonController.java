package member.provider.controller;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RScheduledExecutorService;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedissonController {

   /* @Autowired(required = false)
    private RedissonClient redissonClient; //已经封装redis分布式锁的操作对象
    @RequestMapping("/addNum")
    public void add(){

        RLock lock = redissonClient.getLock("GG");
        //如果锁不可用，则当前线程变为休眠状态,直到拿到锁
        lock.lock();

        lock.unlock();
        RScheduledExecutorService service = redissonClient.getExecutorService("ss");
    }*/
}
