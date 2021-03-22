package com.ke.jvm.oom;

import java.util.Random;

/**
 * @author zxg_QAQ
 * @date 2021/3/22下午11:01
 */
public class JavaHeapSpaceDemo {

    public static void main(String[] args) {
        String str = "test";
        while (true) {
            str += str + new Random().nextInt(1111111)+ new Random().nextInt(22222222);
            str.intern();
        }
    }
}
