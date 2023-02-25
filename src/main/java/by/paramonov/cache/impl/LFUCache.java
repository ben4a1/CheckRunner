package by.paramonov.cache.impl;

import by.paramonov.cache.Cache;
import by.paramonov.factory.CacheFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * The class implements the LFU algorithm
 * (a cache storage algorithm that counts how
 * often each item is used and removes those that are least accessed)
 *
 * @param <K> – the type of keys maintained by this cache
 * @param <V> – the type of cached values
 */
public class LFUCache<K, V> implements Cache<K, V> {
    private final int cacheSize;
    private final Map<K, Node<V>> cacheData;
    private final Node head;
    private final Node tail;
    private final int MAX = Integer.MAX_VALUE;
    private final int MIN = Integer.MIN_VALUE;

    public LFUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        this.cacheData = new HashMap<>();
        this.head = new Node(null, this.MAX);
        this.tail = new Node(null, this.MIN);
        head.next = tail;
        tail.prev = head;
    }

    public class Node<V> {
        public V value;
        public int count;
        public Node prev;
        public Node next;

        public Node(V value, int count) {
            this.value = value;
            this.count = count;
            this.prev = null;
            this.next = null;
        }
    }

    private void move(Node node) {
        Node curr = head;
        while (curr != null) {
            if (curr.count > node.count) {
                curr = curr.next;
            } else {
                node.prev = curr.prev;
                node.next = curr;
                node.next.prev = node;
                node.prev.next = node;
                break;
            }
        }
    }

    @Override
    public void put(K key, V value) {
        if (cacheData.containsKey(key)) {
            return;
        }
        if (cacheData.size() == cacheSize) {
            cacheData.remove(tail.prev.value);
            tail.prev = tail.prev.prev;
            tail.prev.next = tail;
        }
        Node newNode = new Node(key, 0);
        cacheData.put(key, newNode);
        move(newNode);
    }

    @Override
    public V get(K key) {
        if (!cacheData.containsKey(key)) {
            return null;
        }
        Node<V> current = cacheData.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        current.count++;
        move(current);
        return cacheData.get(key).value;
    }

    @Override
    public Map<K, V> getAll() {
        Map<K, V> map = new HashMap<>(cacheData.size());
        cacheData.forEach((k, vNode) -> map.put(k, vNode.value));
        return map;
    }

    public static void main(String[] args) {
        CacheFactory<Integer, Integer> intIntLFUCache = new CacheFactory<>();
        Cache<Integer, Integer> lfuCache = intIntLFUCache.createCache("lfu");
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        lfuCache.get(2);
        lfuCache.put(3, 3);
        lfuCache.get(1);
        lfuCache.get(1);
        lfuCache.put(4, 4);
        lfuCache.put(5, 5);
        lfuCache.get(5);
        lfuCache.get(5);
        lfuCache.get(2);
        lfuCache.put(6, 6);
        lfuCache.get(6);
        lfuCache.get(6);
        lfuCache.put(7, 7);
        lfuCache.put(8, 8);
        lfuCache.put(9, 9);
        lfuCache.put(10, 10);
        System.out.println(lfuCache.getAll());
    }
}
