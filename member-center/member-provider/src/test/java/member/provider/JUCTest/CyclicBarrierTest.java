package member.provider.JUCTest;


import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

//计数器+ 到某个值才会去做某件事  --计数器可以用多次
public class CyclicBarrierTest {

    public static void main(String[] args) throws  Exception {

        CyclicBarrier  cyclicBarrier = new CyclicBarrier(7,() ->{
            System.out.println("7个龙珠已集齐--- 开始召唤神龙"); // 准备要做的事
        });
        for (int i = 1; i <=21 ; i++) {
            final int a = i;
            TimeUnit.SECONDS.sleep(1);
            new Thread(() ->{
                try {
                    System.out.println("集到第"+ a +"个龙珠");
                    cyclicBarrier.await(); //
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
