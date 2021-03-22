package com.ke.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zxg_QAQ
 * @date 2021/3/22下午11:22
 */
public class GCOverheadDemo {

    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();
        try{
            while (true) {
                list.add(String.valueOf(++i).intern());
            }
        } catch (Exception e) {
            System.out.println("***********i:"+i);
            e.printStackTrace();
        }
    }
}
