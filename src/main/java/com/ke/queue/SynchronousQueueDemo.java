package com.ke.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author zxg_QAQ
 * @date 2021/3/8下午11:58
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"\t put 1");
                blockingQueue.put("put 1");
                System.out.println(Thread.currentThread().getName()+"\t put 2");
                blockingQueue.put("put 2");
                System.out.println(Thread.currentThread().getName()+"\t put 3");
                blockingQueue.put("put 3");
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t1").start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+"\t "+blockingQueue.take());
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+"\t "+blockingQueue.take());
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+"\t "+blockingQueue.take());
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t2").start();
    }
}
