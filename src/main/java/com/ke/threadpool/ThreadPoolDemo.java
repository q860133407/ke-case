package com.ke.threadpool;

import java.util.concurrent.*;

/**
 * @author zxg_QAQ
 * @date 2021/3/12下午11:59
 * 第 4 种获得/使用 java 多线程的方式，线程池
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
        //ExecutorService threadPool = Executors.newFixedThreadPool(5); // 可处理 5 个线程
        //ExecutorService threadPool = Executors.newSingleThreadExecutor(); // 只处理一个线程
        // ExecutorService threadPool = Executors.newCachedThreadPool(); // 可处理 N 个线程，动态调整
        ExecutorService threadPool = new ThreadPoolExecutor(2,5,100L
                ,TimeUnit.SECONDS,new LinkedBlockingQueue<>(3), Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardPolicy());
        try {
            for (int i=1;i<=20;i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+"\t 线程执行");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
