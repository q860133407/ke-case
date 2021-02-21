package com.ke.volatiles;


import java.util.concurrent.TimeUnit;

/**
 * @author zxg_QAQ
 * @date 2021/2/21下午3:26
 * 验证 volatile 可见性
 */
public class VolatileDemo {

    public static void main(String[] args) {
        KeData keData = new KeData();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            }
            keData.addTO60();
            System.out.println(Thread.currentThread().getName()+"\t updated number:"+keData.number);
        },"Thread-01").start();
        while (keData.number == 0) {

        }
        System.out.println(Thread.currentThread().getName()+"\t over! main get number:"+keData.number);
    }
}
