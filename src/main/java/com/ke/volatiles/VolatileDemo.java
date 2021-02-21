package com.ke.volatiles;


import java.util.concurrent.TimeUnit;

/**
 * @author zxg_QAQ
 * @date 2021/2/21下午3:26
 * 1 验证 volatile 的可见性
 *    1.1 假如 KeData int number = 0; number 变量之前根本没有添加 volatile 关键字修饰，没有可见性
 *    1.2 添加了 volatile ，可以解决可见性问题
 * 2 验证 volatile 不保证原子性
 */
public class VolatileDemo {

    public static void main(String[] args) {
        KeData keData = new KeData();
        for (int i =1;i<=20;i++) {
            new Thread(()->{
                for (int j=1;j<=1000;j++) {
                    keData.addPlusPlus();
                    keData.addAtomic();
                }
            },String.valueOf(i)).start();
        }
        // 需要等待上面 20 个线程都全部计算完成后，再用 main 线程取得最终得结果值看是多少？
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"\t finally number value:"+keData.number);
        System.out.println(Thread.currentThread().getName()+"\t finally atomicInteger value:"+keData.atomicInteger);
    }

    // 1 验证 volatile 的可见性
    private static void seeOkByVolatile() {
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
