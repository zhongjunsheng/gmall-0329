package member.provider.JUCTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockQuene {

    public static void main(String[] args) throws Exception {

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3); //阈值为3 的有界队列

//        //暴力型 超出阈值立马报错  --不能加或者取不了 直接报错
//        blockingQueue.add("a");
//        blockingQueue.add("b");
//        blockingQueue.add("c");
//        blockingQueue.add("d");  //队列已满 不能加进去
//
//
//        //温油型 --不能加或者取不了不会报错
//        blockingQueue.offer("1");
//        blockingQueue.offer("2");
//        blockingQueue.offer("3");
//        blockingQueue.offer("4");  //返回false 表示加入错误 不报错
       // blockingQueue.offer("3",2l, TimeUnit.SECONDS); //2s中如果添加不进去则撤
//
//        blockingQueue.poll();   //FIFO 取出队列第一个
//        blockingQueue.poll();
//        blockingQueue.poll();
//        blockingQueue.poll();    //无元素可取是返回null




        //阻塞型加入--不能加或者取不到元素时都会等着直到能操作
        blockingQueue.put("g");
        blockingQueue.put("g");
        blockingQueue.put("X");
        blockingQueue.put("X2");  //阻塞等着 直到能添加

        blockingQueue.take(); //没有时阻塞等着 直到有元素可取
        }
}
