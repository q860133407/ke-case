package com.ke.locks;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author zxg_QAQ
 * @date 2021/3/4下午11:25
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i=1;i<=6;i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t 线程抢到执行权");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"\t 执行3s后释放资源");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
