package member.provider.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

    public static void main(String[] args) {


        /**wait 和 notify的升级版  LockSupport
         * LockSupport.park() 阻塞 LockSupport.unpark() 唤醒
         * park() 和 unpark()
         * LockSupport 不要同步代码块 使用非常方便  wait 和 notify必须在同步代码块里执行使用
         * wait 和 notify 是先阻塞等待通知在执行 但是LockSupport可以先通知 此时阻塞可以忽略
         * unpark发放许可证只能是一次 不能多次  所以多次的park 和unppark无效  只一次
         */
        Thread a = new Thread(() -> {
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) {e.printStackTrace(); }
            System.out.println(Thread.currentThread().getName() + "----" + "come in");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName()+ "-----" + "被唤醒");
        }, "a");
        a.start();



        Thread b = new Thread(() -> {
            LockSupport.unpark(a);
            System.out.println(Thread.currentThread().getName() + "----" + "已经发起了通知");
        }, "b");
        b.start();

    }


}
