package com.wajahat.lrucache;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * LruCache Implementation
 * Uses Deque implementation for maintaining LRU items
 * the front of the queue always has the most recent items where as last end 
 * has the least items, if the queue reaches the capacity, lru item is removed
 * and item is inserted in the front of the queue 
 * @author Wajahat Siddiqui
 */
public class LruCache<Key, Value> {

    private ConcurrentHashMap<Key, Value> map;
    private ConcurrentLinkedDeque<Key> queue;
    private int capacity;

    LruCache(int capacity) {
        this.capacity = capacity;
        map = new ConcurrentHashMap<Key, Value>(capacity);
        queue = new ConcurrentLinkedDeque<Key>();
    }

    /**
     * Put <Key, Value> Pair into cache
     * if the key is already present, move the key to the front of the queue
     * if the size >= capacity remove the least recently used item from the queu
     * @param key - the key
     * @param value - the value
     */
    public void put(Key key, Value value) {
        if (contains(key)) {
            queue.remove(key);
        }

        if (size() >= capacity) {
            map.remove(Objects.requireNonNull(queue.pollLast()));
        }

        map.put(key, value);
        queue.addFirst(key);
    }

    /**
     * Gets the value for the corresponding key
     * @param key - the key
     * @return Value for the given key
     */
    public Value get(Key key) {
        Value value = map.get(key);
        if (value == null) return null;
        put(key, value);
        return value;
    }

    /**
     * Checks if key is present in LruCache
     * @param key - the key
     * @return true, if key is present, false otherwise.
     */
    public boolean contains(Key key) {
        return map.get(key) != null;
    }

    /**
     * Removes the key from the lru cache
     * @param key - the key
     * @return value which is removed from the cache
     */
    public Value remove(Key key) {
        if (!contains(key)) return null;
        Value value = get(key);
        map.remove(key);
        queue.remove(key);
        return value;
    }

    /**
     * The current size of the queue
     * @return size of the lru queue
     */
    public int size() { return queue.size(); }

    /**
     * Checks if the lru cache is empty
     * @return true of lru cache is empty, false otherwise
     */
    public boolean isEmpty() { return size() == 0; }

    public List<Integer> getQueue() {
        List<Integer> list = new ArrayList<>();
        queue.iterator().forEachRemaining(key -> {list.add((Integer) key);});
        return list;
    }

    /**
     * Returns the string representation of lru cache.
     */
    @Override
    public String toString() {
        if (isEmpty()) return "";
        return "map: " + map.toString() + " queue: " + queue.toString();
    }
}
