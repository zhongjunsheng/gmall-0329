package member.provider.redisConfig;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


//@Configuration
//用@EnableConfigurationProperties注解使@ConfigurationProperties生效，并从IOC容器中获取bean。
//@EnableConfigurationProperties(RedisProperties.class)
public class RedisAutoConfig {
		

    //使用jedis连接池  ，性能更高
 /*	@Bean
 	public  JedisPool jedisPool(RedisProperties redisProperties) {
 	   JedisPoolConfig config = new JedisPoolConfig();
 	   config.setMaxTotal(200);
 	   config.setMaxIdle(50);//设置最大空闲数
 	   config.setMinIdle(8);//设置最小空闲数
 	   config.setMaxWaitMillis(10000);//获取连接对象最大等待时间
		return new JedisPool(config,redisProperties.getHost(), redisProperties.getPort());
 		
 	}*/
	/*@Bean
	public  Jedis jedis(RedisProperties redisProperties) {
		
		return new Jedis(redisProperties.getHost(), redisProperties.getPort());
		
	}*/
}
