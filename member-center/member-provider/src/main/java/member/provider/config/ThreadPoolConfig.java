package member.provider.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;


/**
 * 自定义线程池
 */
@Configuration
public class ThreadPoolConfig {

    /**
     * 自定义线程池
     * @return
     * ArrayBlockingQueue 是一个有界队列，有界也就意味着，
     * 它不能够存储无限多数量的对象。所以在创建 ArrayBlockingQueue 时，必须要给它指定一个队列的大小。
     *  线程池的核心线程参数如何配置 有什么依据
     *  线程数的配置依据是根据硬件配置有关的
     *  首先先知道自己的服务器是几核的处理器
     *  1.Runtime.getRuntime().availableProcessors()能获取cpu 是几核处理器（cpu核数）
     *  3接着线程数的配置分 cpu 密集型和 IO 密集型
     *  cpu 密集型  的线程数 =  cpu核数 + 1
     *
     *  IO 密集型  一般
     *    =  cpu核数 * 2
     *
     *  大厂经验：
     *  IO 密集型 一般 =  cpu核数/1-阻塞系数    阻塞系数  = 0.8 到0.9 之间
     *  比如8核的 = 8/1-0.9 = 80 个线程数 这就是配置依据
     *
     */
    @Bean
    public ThreadPoolExecutor threadPoolExecutor(){
        return new ThreadPoolExecutor(50,
                                 200,
                                   60,
                                    TimeUnit.SECONDS,
                                    new ArrayBlockingQueue<>(10000),
                                    Executors.defaultThreadFactory(),  //默认线程生成工程
                                    new ThreadPoolExecutor.AbortPolicy());  //默认拒绝处理策略超出即抛异常
    }

    public static void main(String[] args) {

        //获取cpu 是几核处理器
        System.out.println(Runtime.getRuntime().availableProcessors());

        ThreadLocal<Long>  t = new ThreadLocal<>();
    }
}
