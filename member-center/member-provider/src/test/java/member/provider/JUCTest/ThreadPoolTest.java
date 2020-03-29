package member.provider.JUCTest;


import java.util.concurrent.*;

/**
 * 自定义线程池
 * 最大线程数满了 队列也满了则会执行贤臣池的拒绝策略
 */
public class ThreadPoolTest {

    public static void main(String[] args) {


        ExecutorService service = new ThreadPoolExecutor(
                2,
                5,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                //new ThreadPoolExecutor.AbortPolicy()   //立马抛出异常
                //new ThreadPoolExecutor.CallerRunsPolicy() //把请求返回给调用者 比如或者是main线程调用的 则会返回给main线程处理
                new ThreadPoolExecutor.DiscardOldestPolicy()  //抛弃等待最久的线程  执行最新的线程请求
                //new ThreadPoolExecutor.DiscardPolicy()       //不处理也不抛出异常

        );


        try {
            for (int i = 0; i < 11 ; i++) {
                service.execute(() -> System.out.println(Thread.currentThread().getName() + " 办理业务"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }

    }
}
