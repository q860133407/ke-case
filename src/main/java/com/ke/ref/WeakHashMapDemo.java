package com.ke.ref;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * @author zxg_QAQ
 * @date 2021/3/21下午10:59
 */
public class WeakHashMapDemo {

    public static void main(String[] args) {
        myHashMap();
        System.out.println("===========");
        myWeakHashMap();
    }

    private static void myWeakHashMap() {
        WeakHashMap<Integer,String> map = new WeakHashMap<>();
        Integer key = new Integer(1);
        String value = "HashMap";
        map.put(key,value);
        System.out.println(map);// bu wei null
        key = null;
        System.out.println(map);// bu wei null
        System.gc();
        System.out.println(map);// null
    }

    private static void myHashMap() {
        HashMap<Integer,String> map = new HashMap<>();
        Integer key = new Integer(1);
        String value = "HashMap";
        map.put(key,value);
        System.out.println(map);
        key = null;
        System.out.println(map);
        System.gc();
        System.out.println(map);
    }
}
