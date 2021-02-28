package com.ke.container;

import java.util.*;

/**
 * @author zxg_QAQ
 * @date 2021/2/26下午11:05
 * 集合类不安全问题
 */
public class ContainerNotSafeDemo {

    public static void main(String[] args) {
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        for(int i=1;i<=30;i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
