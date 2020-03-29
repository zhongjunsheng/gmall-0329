package member.provider.JUCTest;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareSource{


    //Condition必须配合重入锁使用
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    //线程1打印5次
    public void print5(){
        lock.lock();
        try {
            //判断
            while (number != 1){
                c1.await();
            }
            //干活--打印
            for (int i = 1; i <=5 ; i++) {
                System.out.println(Thread.currentThread().getName() + "===" + i);
            }
            //通知 线程2
            number =2;
            c2.signal();  //通知线程2
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    //接着线程2打印10次
    public void print10(){
        lock.lock();
        try {
            //判断
            while (number != 2){
                c2.await();
            }
            //干活--打印
            for (int i = 1; i <=10 ; i++) {
                System.out.println(Thread.currentThread().getName() + "===" + i);
            }
            //通知线程3
            number =3;
            c3.signal();  //通知线程3
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //再接着线程3打印15次
    public void print15(){
        lock.lock();
        try {
            //判断
            while (number != 3){
                c3.await();
            }
            //干活--打印
            for (int i = 1; i <=15 ; i++) {
                System.out.println(Thread.currentThread().getName() + "===" + i);
            }
            number =1;
            c1.signal();  //通知线程1
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}



public class ConditionTest {

    public static void main(String[] args) {
        ShareSource shareSource = new ShareSource();
        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                shareSource.print5();
            }
        },"AA").start();

        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                shareSource.print10();
            }
        },"BB").start();
        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                shareSource.print15();
            }
        },"CC").start();



    }








}


