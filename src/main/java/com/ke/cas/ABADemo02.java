package com.ke.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author zxg_QAQ
 * @date 2021/2/26下午10:00
 */
public class ABADemo02 {

    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(100,1);

    public static void main(String[] args) {
        // 实现 ABA 问题案例
        System.out.println("=========== ABA问题的产生 ===========");
        new Thread(()->{
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);
        },"t1").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName()+"\t"+atomicReference.compareAndSet(100, 200)+"\t"+atomicReference.get());
            } catch (Exception e){
                e.printStackTrace();
            }
        },"t2").start();
        try {
            TimeUnit.SECONDS.sleep(2);
        }catch (Exception e) {
            e.printStackTrace();
        }
        // 解决 ABA 问题事例
        System.out.println("=========== ABA问题的解决 ===========");
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName() + "\t 第一次版本号：" + stampedReference.getStamp());
                TimeUnit.SECONDS.sleep(1);
                stampedReference.compareAndSet(100,101,stampedReference.getStamp(),stampedReference.getStamp()+1);
                System.out.println(Thread.currentThread().getName() + "\t 第二次版本号：" + stampedReference.getStamp());
                stampedReference.compareAndSet(101,100,stampedReference.getStamp(),stampedReference.getStamp()+1);
                System.out.println(Thread.currentThread().getName() + "\t 第三次版本号：" + stampedReference.getStamp());
            } catch (Exception e){
                e.printStackTrace();
            }
        },"t3").start();
        new Thread(()->{
            try {
                int stamp = stampedReference.getStamp();
                System.out.println(Thread.currentThread().getName() + "\t 第一次版本号：" + stamp);
                TimeUnit.SECONDS.sleep(3);
                boolean result = stampedReference.compareAndSet(100,2019,stamp,stamp);
                System.out.println(Thread.currentThread().getName()+"\t 修改成功否:"+result+"\t 当前版本号:"+stampedReference.getStamp());
                System.out.println(Thread.currentThread().getName()+"\t 当前实际最新值："+stampedReference.getReference());
            } catch (Exception e){
                e.printStackTrace();
            }
        },"t4").start();
    }
}
