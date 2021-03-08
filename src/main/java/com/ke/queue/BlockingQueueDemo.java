package com.ke.queue;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author zxg_QAQ
 * @date 2021/3/4下午11:35
 * 阻塞队列
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws Exception {
        // ------ 抛出异常
        BlockingQueue<String> blockingQueue01 = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue01.add("a"));// true
        System.out.println(blockingQueue01.add("b"));// true
        System.out.println(blockingQueue01.add("c"));// true
        // System.out.println(blockingQueue.add("d"));// 添加失败，抛出异常
        System.out.println(blockingQueue01.element());// 获取第一个入队列的元素 "a"
        System.out.println(blockingQueue01.remove());// 删除成功，返回 a
        System.out.println(blockingQueue01.remove());// 删除成功，返回 b
        System.out.println(blockingQueue01.remove());// 删除成功，返回 c
        //System.out.println(blockingQueue01.remove());// 删除失败，抛出异常
        // ------ 特殊值，返回 false/true
        BlockingQueue<String> blockingQueue02 = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue02.offer("a"));// true
        System.out.println(blockingQueue02.offer("b"));// true
        System.out.println(blockingQueue02.offer("c"));// true
        System.out.println(blockingQueue02.offer("a"));// 添加失败，返回false
        System.out.println(blockingQueue02.peek());// 获取第一个入队的元素 "a"
        System.out.println(blockingQueue02.poll());// a
        System.out.println(blockingQueue02.poll());// b
        System.out.println(blockingQueue02.poll());// c
        System.out.println(blockingQueue02.poll());// 获取失败，返回 null
        // ------ 阻塞
        BlockingQueue<String> blockingQueue03 = new ArrayBlockingQueue<>(3);
        blockingQueue03.put("put01");
        blockingQueue03.put("put02");
        blockingQueue03.put("put03");
        System.out.println("======================");
        //blockingQueue03.put("put");// 取出元素超出长度，线程阻塞等待
        System.out.println(blockingQueue03.take());// put01
        System.out.println(blockingQueue03.take());// put02
        System.out.println(blockingQueue03.take());// put03
        //System.out.println(blockingQueue03.take());// 放入元素超出长度，线程阻塞等待
        // ------ 超时
        BlockingQueue<String> blockingQueue04 = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue04.offer("a",2L,TimeUnit.SECONDS));// true
        System.out.println(blockingQueue04.offer("a",2L,TimeUnit.SECONDS));// true
        System.out.println(blockingQueue04.offer("a",2L,TimeUnit.SECONDS));// true
        System.out.println(blockingQueue04.offer("a",2L,TimeUnit.SECONDS));// 等待 2 s，退出
    }
}
