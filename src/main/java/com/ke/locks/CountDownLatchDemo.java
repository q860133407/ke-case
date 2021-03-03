package com.ke.locks;

import com.ke.enums.DemoEnum;

import java.util.concurrent.CountDownLatch;

/**
 * @author zxg_QAQ
 * @date 2021/3/4上午12:17
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws Exception {
        countDownLatch01();
    }

    private static void countDownLatch01() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i=1;i<=6;i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 线程执行，退出");
                countDownLatch.countDown();
            },DemoEnum.getDemoEnum(i).getName()).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t 结束程序退出");
    }
}
