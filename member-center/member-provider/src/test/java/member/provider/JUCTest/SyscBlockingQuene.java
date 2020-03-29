package member.provider.JUCTest;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * 同步队列
 * 不存储元素  消费一个才能添加下一个
 * 队列中有且只有一个元素
 */
public class SyscBlockingQuene {

    public static void main(String[] args) throws  Exception {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

        new Thread(() ->{

            try {
                System.out.println("添加1");
                blockingQueue.put("1");
                System.out.println("添加2");
                blockingQueue.put("2");
                System.out.println("添加3");
                blockingQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AA").start();




        new Thread(() ->{

            try {
                Thread.sleep(3000);
                System.out.println("消费:"+blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            try {
                Thread.sleep(3000);
                System.out.println("消费:"+blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            try {
                Thread.sleep(3000);
                System.out.println("消费:"+blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



        },"BB").start();

    }
}
