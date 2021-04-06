package com.ke.locks;

/**
 * @author zxg_QAQ
 * @date 2021/4/7上午12:28
 * 可重入锁
 */
public class ReEnterLockDemo01 {

    static Object objectLockA = new Object();

    private static void m1() {
        new Thread(()->{
            synchronized (objectLockA) {
                System.out.println(Thread.currentThread().getName()+"\t ---- 外层调用");
                synchronized (objectLockA) {
                    System.out.println(Thread.currentThread().getName()+"\t ---- 中层调用");
                    synchronized (objectLockA) {
                        System.out.println(Thread.currentThread().getName()+"\t ---- 内层调用");
                    }
                }
            }
        },"t1").start();
    }

    private synchronized static void m2() {
        System.out.println("===== 外层调用");
        m3();
    }

    private synchronized static void m3() {
        System.out.println("===== 中层调用");
        m4();
    }

    private synchronized static void m4() {
        System.out.println("===== 内层调用");
    }

    public static void main(String[] args) {
        m2();
    }
}
