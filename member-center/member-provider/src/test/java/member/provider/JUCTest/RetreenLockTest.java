package member.provider.JUCTest;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RetreenLockTest {

    public static void main(String[] args) {
        Demo demo = new Demo();

        for (int i = 0; i < 5; i++) {
            final  int a =i;
            new Thread(() ->{
                demo.set(a+"",a+"");
            },"线程"+i).start();
        }



        for (int i = 0; i < 5; i++) {
            final  int a =i;
            new Thread(() ->{
                demo.get(a+"");
            },i+"").start();
        }

    }

}


class  Demo{

    private volatile HashMap<String,Object> map = new HashMap<>();
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();


    public void set(String key,Object value){

        try {
            rwLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "正在写入:" + key);
            TimeUnit.MILLISECONDS.sleep(300);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName() + "写入完成:");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            rwLock.writeLock().unlock();
        }


    }


    public void get(String key){
        rwLock.readLock().lock();
        try {   System.out.println(Thread.currentThread().getName() + "正在读取:" + key);
            TimeUnit.MILLISECONDS.sleep(300);
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取完成:" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            rwLock.readLock().unlock();
        }


    }
}