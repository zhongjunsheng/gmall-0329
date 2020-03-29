package member.provider.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Collections;
import java.util.Random;

//@Component
public class RedisTool {

   /* private  final static int Time_OUT=3;  //过期时间3s
    private  final static String LOCK_SUCCESS="OK";
    private  final static Long UNLOCK_SUCCESS = 1L;
    private static int  reTry= 5;

    @Autowired
    private JedisPool jedisPool;
    
    //加锁，加锁成功就代表获取了锁
    public boolean getLock(String lockKey, String lockValue){
        Jedis jedis = jedisPool.getResource();
        String result = jedis.set(lockKey, lockValue, "NX", "EX", Time_OUT);
	    if(LOCK_SUCCESS.equals(result)){
		    return true;
	    }
	return false;
    }
    
    //解锁

    *//**
     * 释放分布式锁
     * @param
     * @param lockKey
     * @param
     * @return 是否释放成功
     *//*
    public  boolean unLock(String lockKey, String lockValue) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Jedis jedis = jedisPool.getResource();
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(lockValue));
        if (UNLOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;

    }
    



    //获取锁---  阻塞式获取锁，拿不到就一直阻塞
    public  boolean getLockToZusai(String lockKey, String lockValue){
	while(true){
	    if(getLock(lockKey, lockValue)){
		 return true;
	    }
	    try {
            Random rd = new Random();
            int nextInt = rd.nextInt(3);
            Thread.sleep((nextInt + 1)*100); //1-300ms
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
	   }
    }*/

}
