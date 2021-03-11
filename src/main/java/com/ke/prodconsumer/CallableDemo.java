package com.ke.prodconsumer;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class MyThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("******** call");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1024;
    }
}

/**
 * @author zxg_QAQ
 * @date 2021/3/11下午10:46
 */
public class CallableDemo {

    public static void main(String[] args) throws Exception {
        FutureTask<Integer> futureTask01 = new FutureTask<>(new MyThread());
        FutureTask<Integer> futureTask02 = new FutureTask<>(new MyThread());
        new Thread(futureTask01,"t1").start();
        new Thread(futureTask02,"t2").start(); // 如果想获取两个结果，那就得创建两个 FutureTask
        //new Thread(futureTask,"t2").start(); // 就算创建两个线程，也只会计算一次
        //int result02 = futureTask.get(); // 要求获得 Callable 线程到计算结果，如果没有计算完成就会导致堵塞，直到完成计算
        int result01 = 100;
        while (!futureTask01.isDone()) { // Callable 计算完成后，该方法返回 true

        }
        System.out.println(Thread.currentThread().getName() + "****");
        System.out.println("******** result:" + (result01 + futureTask01.get()));
    }
}
