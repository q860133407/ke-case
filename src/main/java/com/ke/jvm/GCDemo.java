package com.ke.jvm;

import java.util.Random;

/**
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialGC
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParNewGC
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelGC
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelOldGC
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseConcMarkSweepGC
 * @author zxg_QAQ
 * @date 2021/3/24下午10:26
 */
public class GCDemo {

    public static void main(String[] args) {
        System.out.println("******GCDemo");
        try {
            String str = "test";
            while (true) {
                str += str + new Random().nextInt(7777777) + new Random().nextInt(888888888);
                str.intern();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
