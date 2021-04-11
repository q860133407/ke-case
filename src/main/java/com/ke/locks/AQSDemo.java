package com.ke.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zxg_QAQ
 * @date 2021/4/11下午1:38
 */
public class AQSDemo {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        new Thread(()->{
            lock.lock();
            try {
                System.out.println("---- A thread come in");
                TimeUnit.MINUTES.sleep(20);
            } catch (Exception e) {
                lock.unlock();
            }
        },"A").start();

        new Thread(()->{
            lock.lock();
            try {
                System.out.println("---- B thread come in");
            } catch (Exception e) {
                lock.unlock();
            }
        },"B").start();

        new Thread(()->{
            lock.lock();
            try {
                System.out.println("---- C thread come in");
            } catch (Exception e) {
                lock.unlock();
            }
        },"C").start();
    }
}
