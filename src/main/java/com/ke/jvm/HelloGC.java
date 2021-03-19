package com.ke.jvm;

import java.util.concurrent.TimeUnit;

/**
 * @author zxg_QAQ
 * @date 2021/3/17上午12:03
 */
public class HelloGC {

    public static void main(String[] args) throws Exception {
        System.out.println("****** HelloGC");
        byte[] byteArray = new byte[50*1024*1024];
        //TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
    }
}
