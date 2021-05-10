package com.ke.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zxg_QAQ
 * @date 2021/5/11上午12:33
 */
public class LRUCacheDemo02 {

    class Node<K,V> {
        K key;
        V value;
        Node<K,V> prev;
        Node<K,V> next;

        public Node() {
            this.prev = this.next = null;
        }

        public Node(K key,V value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }
    }

    class DoubleLinkedList<K,V> {
        Node<K,V> head;
        Node<K,V> tail;

        public DoubleLinkedList() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }

        public void add(Node<K,V> node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        public void removeNode(Node<K,V> node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.prev = null;
            node.next = null;
        }

        public Node getLast() {
            return tail.prev;
        }
    }

    private int cacheSize;
    Map<Integer,Node<Integer,Integer>> map;
    DoubleLinkedList<Integer,Integer> doubleLinkedList;

    public LRUCacheDemo02(int cacheSize) {
        this.cacheSize = cacheSize;
        map = new HashMap<>();
        doubleLinkedList = new DoubleLinkedList<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node<Integer,Integer> node = map.get(key);
        doubleLinkedList.removeNode(node);
        doubleLinkedList.add(node);
        return node.value;
    }

    public void put(int key,int value) {
        if (map.containsKey(key)) {
            Node<Integer,Integer> node = map.get(key);
            node.value = value;
            map.put(key,node);
            doubleLinkedList.removeNode(node);
            doubleLinkedList.add(node);
        } else {
            if (map.size() == cacheSize) {
                Node<Integer,Integer> lastNode = doubleLinkedList.getLast();
                map.remove(lastNode.key);
                doubleLinkedList.removeNode(lastNode);
            }
            Node<Integer,Integer> newNode = new Node<>(key,value);
            map.put(key,newNode);
            doubleLinkedList.add(newNode);
        }
    }

    public static void main(String[] args) {
        LRUCacheDemo02 lruCacheDemo = new LRUCacheDemo02(3);
        lruCacheDemo.put(1,1);
        lruCacheDemo.put(2,2);
        lruCacheDemo.put(3,3);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(3,1);
        lruCacheDemo.put(10,3);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(9,8);
        System.out.println(lruCacheDemo.map.keySet());
    }
}
