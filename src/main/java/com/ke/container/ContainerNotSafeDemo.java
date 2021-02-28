package com.ke.container;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author zxg_QAQ···
 * @date 2021/2/26下午11:05
 * 集合类不安全问题
 * ArrayList
 * HashSet
 */
public class ContainerNotSafeDemo {

    public static void main(String[] args) {
        mapNotSafe();
        setNotSafe();
        listNotSafe();
    }

    private static void mapNotSafe() {
        Map<String,String> map = new ConcurrentHashMap<>();
        for(int i=1;i<=30;i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }

    private static void setNotSafe() {
        Set<String> set = new CopyOnWriteArraySet<>();
        for(int i=1;i<=30;i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }

    private static void listNotSafe() {
        List<String> list = new CopyOnWriteArrayList<>();
        for(int i=1;i<=30;i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
