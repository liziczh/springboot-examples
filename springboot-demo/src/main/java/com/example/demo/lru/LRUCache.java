package com.example.demo.lru;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * common
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2023/6/13 4:04 PM
 */
public class LRUCache<K, V> {

    public Map<K, V> cache = new HashMap<>();

    public Queue<K> queue = new LinkedList<>();

    public int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public V get(K key) {
        V v = cache.get(key);
        // 热点数据，重新放入队尾
        if (v != null) {
            queue.remove(key);
            queue.offer(key);
        }
        return v;
    }

    public void put(K k, V v) {
        // LRU
        if (queue.size() == capacity) {
            K leastUsedKey = queue.poll();
            cache.remove(leastUsedKey);
        }
        if (queue.contains(k)) {
            queue.remove();
        }
        cache.put(k, v);
        queue.offer(k);
    }

    public void remove(K key) {
        cache.remove(key);
        queue.remove(key);
    }

}
