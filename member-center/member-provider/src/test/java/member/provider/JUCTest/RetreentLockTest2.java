package member.provider.JUCTest;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RetreentLockTest2 {

    public static void main(String[] args) {
      Lock lock = new ReentrantLock();


      new Thread(() -> {
          lock.lock();
          System.out.println(Thread.currentThread().getName() + " 获取了锁");
          try { TimeUnit.SECONDS.sleep(10); } catch (InterruptedException e) { e.printStackTrace(); }
          lock.unlock();
      },"a").start();


        new Thread(() -> {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "线程B 进来了");
            lock.unlock();
            System.out.println("dffgg");
        },"b").start();
    }
}
