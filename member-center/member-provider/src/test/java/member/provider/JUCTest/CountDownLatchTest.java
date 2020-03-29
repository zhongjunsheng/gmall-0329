package member.provider.JUCTest;

import java.util.concurrent.CountDownLatch;

//计数器 减到0  到某个值才会去做某件事
public class CountDownLatchTest {
    public static void main(String[] args)  throws  Exception{

        CountDownLatch cdl = new CountDownLatch(10);
        for (int i = 1; i <=10 ; i++) {
            new Thread(() ->{
                System.out.println(Thread.currentThread().getName() + "离开了教室");
                cdl.countDown();
            }).start();

        }
            cdl.await();//阻塞等待 计数器为0 后才往下走
            System.out.println("班长离开了教室");



    }

}
