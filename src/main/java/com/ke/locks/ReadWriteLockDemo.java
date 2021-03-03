package com.ke.locks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCache{

    private volatile Map<String,Object> map = new HashMap<>();
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void put(String key,Object value) {
        rwLock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t 正在写入："+key);
            TimeUnit.MILLISECONDS.sleep(300);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t 写入完成");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public void get(String key) {
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 正在读取：");
            TimeUnit.MILLISECONDS.sleep(300);
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读取完成："+result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.readLock().unlock();
        }
    }
}

/**
 * @author zxg_QAQ
 * @date 2021/3/3下午10:09
 * 读写锁
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i=1;i<=5;i++) {
            final int tempInt = i;
            new Thread(()->{
                myCache.put(tempInt+"",tempInt+"");
            },String.valueOf(tempInt)).start();
        }
        for (int i=1;i<=5;i++) {
            final int tempInt = i;
            new Thread(()->{
                myCache.get(tempInt+"");
            },String.valueOf(tempInt)).start();
        }
    }
}
