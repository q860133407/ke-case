package com.ke.jvm.oom;

/**
 * @author zxg_QAQ
 * @date 2021/3/23下午11:41
 */
public class MetaspaceOOMTest {

    static class OOMTest {

    }

    public static void main(String[] args) throws Exception {
        int i = 0;
        try {
            while (true) {
                i++;
                //Enhancer
            }
        } catch (Exception e) {
            System.out.println("***** i:"+i);
            e.printStackTrace();
        }
    }
}
