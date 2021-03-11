package com.ke.prodconsumer;

import java.util.concurrent.Callable;

class MyThread implements Runnable {
    @Override
    public void run() {

    }
}

class MyThread2 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return null;
    }
}

/**
 * @author zxg_QAQ
 * @date 2021/3/11下午10:46
 */
public class CallableDemo {
}
