package member.provider.JUCTest;


import java.util.concurrent.TimeUnit;

class HoldLock implements  Runnable{

    private  String lockA = "lockA";
    private  String lockB ="lockB";

    public HoldLock(String lockA,String lockB){
        this.lockA=lockA;
        this.lockB=lockB;
    }


    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+ "持有lockA尝试获取lockB");
            try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }

            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+ "持有lockB尝试获取lockA");
                try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }

    }
}
public class DeadLockDemoTest {

    public static void main(String[] args) {

        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new HoldLock(lockA,lockB),"ThreadA").start();
        new Thread(new HoldLock(lockB,lockA),"ThreadB").start();
    }

}
