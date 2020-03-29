package member.provider.JUCTest;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3); //模拟3个车位,里面表示可用资源数量


        //6部车抢3个车位
        for (int i = 0; i <6 ; i++) {   //模拟6部车

            new Thread(() ->{
                try {
                    semaphore.acquire(); //抢到许可证,相当与拿到了车位
                    System.out.println(Thread.currentThread().getName() +"抢到了车位");
                    TimeUnit.SECONDS.sleep(3);  //表示3s后又离开了 --释放车位
                    System.out.println(Thread.currentThread().getName() +"离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            }).start();

        }
    }
}
