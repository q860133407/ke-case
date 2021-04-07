package com.ke.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zxg_QAQ
 * @date 2021/4/7下午11:22
 */
public class LockSupportDemo {

    static Object objectLock = new Object();
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t ----- come in");
            try {
                condition.await();
            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        },"t1").start();

    }

    private static void synchronizedWaitNotify() {
        new Thread(()->{
            synchronized (objectLock) {
                System.out.println(Thread.currentThread().getName()+"\t-----come in");
                try {
                    objectLock.wait();
                } catch(Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"\t----- notify");
            }
        },"t1").start();

        new Thread(()->{
            synchronized (objectLock) {
                objectLock.notify();
                System.out.println(Thread.currentThread().getName()+"\t----- 通知");
            }
        },"t2").start();
    }
}
