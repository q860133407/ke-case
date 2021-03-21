package com.ke.ref;

/**
 * @author zxg_QAQ
 * @date 2021/3/21下午10:14
 */
public class StrongReferenceDemo {

    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = obj1;
        obj1 = null;
        System.gc();
        System.out.println(obj2);
    }
}
