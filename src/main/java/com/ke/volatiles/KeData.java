package com.ke.volatiles;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zxg_QAQ
 * @date 2021/2/21下午3:27
 */
public class KeData {

    public volatile int number = 0;
    // int number = 0; 字段没有被 volatile 修饰，修改没有被其他线程发现，所以程序运行会一直卡住

    public void addTO60() {
        this.number = 60;
    }

    public synchronized void addPlusPlus() {
        number ++;
    }

    public AtomicInteger atomicInteger = new AtomicInteger();

    public void addAtomic() {
        atomicInteger.getAndIncrement();
    }
}
