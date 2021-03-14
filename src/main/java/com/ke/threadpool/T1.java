package com.ke.threadpool;

import java.util.concurrent.*;

/**
 * @author zxg_QAQ
 * @date 2021/3/14下午3:21
 */
public class T1 {

    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(2,5,100L
                ,TimeUnit.SECONDS,new LinkedBlockingQueue<>(3),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        try {
            for (int i=1;i<=6;i++) {
                final int tmpI = i;
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"执行任务，"+tmpI);
                    try {
                        TimeUnit.SECONDS.sleep(4);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
