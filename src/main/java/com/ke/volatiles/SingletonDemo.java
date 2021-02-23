package com.ke.volatiles;

/**
 * @author zxg_QAQ
 * @date 2021/2/23下午10:22
 */
public class SingletonDemo {

    // 加 volatile 禁止指令重排序，保证语义一致，防止出现线程安全问题
    private static volatile SingletonDemo instance = null;

    private SingletonDemo() {
        System.out.println(Thread.currentThread().getName()+"\t 构造函数 SingletonDemo()");
    }

    public static SingletonDemo getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if(instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i =1;i<10;i++) {
            new Thread(()->{
                SingletonDemo.getInstance();
            },String.valueOf(i)).start();
        }
    }
}
