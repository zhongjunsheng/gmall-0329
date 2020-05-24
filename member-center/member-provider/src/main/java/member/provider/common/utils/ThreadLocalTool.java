package member.provider.common.utils;

import redis.clients.jedis.Jedis;

public class ThreadLocalTool {
    
    ThreadLocal<Jedis> tl = new ThreadLocal<>();
    
    public  void set(Jedis jedis){
	tl.set(jedis);
    }
    
    public  Jedis get(){
	return tl.get();
    }
    public  void remove(){
	tl.remove();
    }
}
