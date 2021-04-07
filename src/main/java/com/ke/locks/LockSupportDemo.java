package com.ke.locks;

/**
 * @author zxg_QAQ
 * @date 2021/4/7下午11:22
 */
public class LockSupportDemo {

    static Object objectLock = new Object();

    public static void main(String[] args) {
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
