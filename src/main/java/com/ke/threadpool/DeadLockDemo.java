package com.ke.threadpool;

import java.util.concurrent.TimeUnit;

class HoldLockThread implements Runnable {

    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA,String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName()+"\t 持有："+lockA+"\t 尝试获得："+lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName()+"\t 持有："+lockB+"\t 尝试获得："+lockA);
            }
        }
    }
}

/**
 * @author zxg_QAQ
 * @date 2021/3/14下午5:26
 */
public class DeadLockDemo {

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new HoldLockThread(lockA,lockB),"t1").start();

        new Thread(new HoldLockThread(lockB,lockA),"t2").start();
    }
}
