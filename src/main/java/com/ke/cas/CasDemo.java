package com.ke.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zxg_QAQ
 * @date 2021/2/23下午11:24
 */
public class CasDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2019)+"\t current data:"+atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 1024)+"\t current data:"+atomicInteger.get());
    }
}
