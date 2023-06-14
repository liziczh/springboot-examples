package com.example.demo.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * common
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2023/6/14 11:59 PM
 */
public class MyLRUCache<K, V> {

    public static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> prev;
        private Node<K, V> next;

        public Node() {
        }

        public Node(K k, V v) {
            this.key = k;
            this.value = v;
        }

    }

    private Map<K, Node<K, V>> cache;
    private int capacity;
    private int used;
    private Node<K, V> head = new Node<>();
    private Node<K, V> tail = new Node<>();

    public MyLRUCache(int capacity) {
        cache = new HashMap<>();
        head = new Node<>();
        tail = new Node<>();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        this.used = 0;
    }

    public void removeNode(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToTail(Node<K, V> node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }

    public void removeHead() {
        head.next = head.next.next;
        head.next.prev = head;
    }

    public V get(K k) {
        Node<K, V> node = cache.get(k);
        if (node != null) {
            removeNode(node);
            addToTail(node);
            return node.value;
        }
        return null;
    }

    public void put(K k, V v) {
        synchronized (this) {
            if (cache.containsKey(k)) {
                // 存在，覆盖更新
                Node<K, V> node = cache.get(k);
                node.value = v;
                removeNode(node);
                addToTail(node);
            } else {
                // 不存在
                Node<K, V> node = new Node<>(k, v);
                cache.put(k, node);
                addToTail(node);
                if (used == capacity) {
                    removeHead();
                }
                used++;
            }
        }
    }

}
