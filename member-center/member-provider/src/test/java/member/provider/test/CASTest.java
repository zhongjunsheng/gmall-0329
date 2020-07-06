package member.provider.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class CASTest {

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(100);

        boolean flag = atomicInteger.compareAndSet(100, 1000);
        System.out.println(flag);

        boolean flag2 = atomicInteger.compareAndSet(100, 10001);
        System.out.println(false);


        System.out.println(atomicInteger.intValue());
        atomicInteger.addAndGet(1);

        ExecutorService service = Executors.newFixedThreadPool(10);
        ExecutorService service2= Executors.newCachedThreadPool();
        ExecutorService service23 = Executors.newSingleThreadExecutor();
        service.execute( () -> System.out.println("dd"));
    }
}
