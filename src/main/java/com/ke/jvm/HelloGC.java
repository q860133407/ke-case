package com.ke.jvm;

import java.util.concurrent.TimeUnit;

/**
 * @author zxg_QAQ
 * @date 2021/3/17上午12:03
 */
public class HelloGC {

    public static void main(String[] args) throws Exception {
        System.out.println("****** HelloGC");
        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
    }
}
