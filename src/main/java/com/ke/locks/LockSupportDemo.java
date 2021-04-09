package com.ke.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zxg_QAQ
 * @date 2021/4/7下午11:22
 */
public class LockSupportDemo {

    static Object objectLock = new Object();
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t ---- come in");
            // 被阻塞
            LockSupport.park();
            System.out.println(Thread.currentThread().getName()+"\t ---- 被唤醒");
        },"t1");
        t1.start();
        Thread t2= new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t ---- 唤醒 t1");
            // 唤醒
            LockSupport.unpark(t1);
        },"t2");
        t2.start();
    }

    private static void lockAwaitSignal() {
        new Thread(()->{
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"\t ----- come in await");
            try {
                condition.await();
                System.out.println();
            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        },"t1").start();
        new Thread(()->{
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"\t ----- signal");
            try {
                condition.signal();
            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        },"t2").start();
    }

    private static void synchronizedWaitNotify() {
        new Thread(()->{
            synchronized (objectLock) {
                System.out.println(Thread.currentThread().getName()+"\t-----come in wait");
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
