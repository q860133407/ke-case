package com.ke.jvm.oom;

/**
 * @author zxg_QAQ
 * @date 2021/3/22下午10:55
 */
public class StackOverflowErrorDemo {

    public static void main(String[] args) {
        stackOverflowError();
    }

    private static void stackOverflowError() {
        stackOverflowError();
    }
}
