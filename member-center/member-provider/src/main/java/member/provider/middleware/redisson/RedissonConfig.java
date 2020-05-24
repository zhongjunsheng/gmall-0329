package member.provider.middleware.redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Redisson配置
 * redisson分布式操作框架
 */
//@Configuration
public class RedissonConfig {

    /*@Bean
    public RedissonClient redissonClient(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.127.130:6379");
        return Redisson.create(config);
    }*/
}
