package com.ke.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zxg_QAQ
 * @date 2021/3/10下午9:56
 * 多线程之间按顺序调用，实现 A -> B -> C 三个线程启动，要求如下：
 * t1 打印 5 次，t2 打印 10 次，t3 打印 15 次
 * 打印 10 轮
 */
class ShareResource{

    private int number = 1; // A:5 B:10 C:15
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            // 1 判断
            while (number != 1) {
                c1.await();
            }
            // 2 执行逻辑
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t " + i);
            }
            // 3 通知
            number = 2;
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            // 1 判断
            while (number != 2) {
                c2.await();
            }
            // 2 执行逻辑
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t " + i);
            }
            // 3 通知
            number = 3;
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            // 1 判断
            while (number != 3) {
                c3.await();
            }
            // 2 执行逻辑
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t " + i);
            }
            // 3 通知
            number = 1;
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class SyncAndReentrantLockDemo {
    public static void main(String[] args) {
         ShareResource shareResource = new ShareResource();
         new Thread(()->{
             for (int i=1;i<=10;i++) {
                 shareResource.print5();
             }
         },"t1").start();
        new Thread(()->{
            for (int i=1;i<=10;i++) {
                shareResource.print10();
            }
        },"t2").start();
        new Thread(()->{
            for (int i=1;i<=10;i++) {
                shareResource.print15();
            }
        },"t3").start();
    }
}
