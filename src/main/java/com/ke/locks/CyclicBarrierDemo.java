package com.ke.locks;

import java.util.concurrent.CyclicBarrier;

/**
 * @author zxg_QAQ
 * @date 2021/3/4上午12:50
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("*** 子线程全部运行完成");
        });
        for (int i=1;i<=7;i++) {
            final int tempInt = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 运行到第"+tempInt+"个子线程");
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
