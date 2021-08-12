package member.provider.JUCTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 线程之前的等待/唤醒机制有3个
 *   1.Object的 wait 、notify 特点只能在sync同步代码块中执行才有效果、只能先等待再通知  顺序不能乱
 *   2.juc 包的  await和single
 *
 */
public class LockSupportTest {
    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
    }
}
