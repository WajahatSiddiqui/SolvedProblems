package com.wajahat.cache;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Thread Safe LRU Cache Implementation
 * 
 * This cache maintains a fixed capacity and evicts the least recently used items
 * when the capacity is exceeded. All operations are thread-safe.
 * 
 * @param <Key> the type of keys maintained by this cache
 * @param <Value> the type of mapped values
 */
public class CacheEngine<Key, Value> {

    private final ReentrantLock reentrantLock = new ReentrantLock();
    private final ConcurrentHashMap<Key, Value> map;
    private final ConcurrentLinkedDeque<Key> queue;
    private final int capacity;
    private static final int DEFAULT_CAPACITY = 10;

    public CacheEngine() {
        this(DEFAULT_CAPACITY);
    }

    public CacheEngine(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        this.capacity = capacity;
        this.map = new ConcurrentHashMap<>(capacity);
        this.queue = new ConcurrentLinkedDeque<>();
    }

    /**
     * Retrieves the value associated with the given key.
     * If the key exists, it is moved to the front of the queue (most recently used).
     * 
     * @param key the key whose associated value is to be returned
     * @return the value associated with the key, or null if the key is not present
     */
    public Value get(Key key) {
        if (key == null) return null;
        
        reentrantLock.lock();
        try {
            Value value = map.get(key);
            if (value == null) {
                return null;
            }
            // Move key to front (most recently used) without calling put()
            // to avoid unnecessary capacity checks and potential evictions
            queue.remove(key);
            queue.addFirst(key);
            return value;
        } finally {
            reentrantLock.unlock();
        }
    }

    /**
     * Associates the specified value with the specified key in this cache.
     * If the key already exists, its position is updated to most recently used.
     * If the cache is at capacity, the least recently used item is evicted.
     * 
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     */
    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        
        reentrantLock.lock();
        try {
            boolean keyExists = map.containsKey(key);
            
            // If key already exists, remove it from queue to avoid duplicates
            if (keyExists) {
                queue.remove(key);
            } else {
                // Only evict if we're adding a new key and at capacity
                if (map.size() >= capacity) {
                    Key lruKey = queue.pollLast();
                    if (lruKey != null) {
                        map.remove(lruKey);
                    }
                }
            }
            
            // Add/update the key-value pair
            map.put(key, value);
            queue.addFirst(key);
        } finally {
            reentrantLock.unlock();
        }
    }

    /**
     * Removes the key and its associated value from the cache.
     * 
     * @param key the key to be removed
     * @return the value that was associated with the key, or null if key was not present
     */
    public Value evict(Key key) {
        if (key == null) return null;
        
        reentrantLock.lock();
        try {
            Value value = map.remove(key);
            queue.remove(key);
            return value;
        } finally {
            reentrantLock.unlock();
        }
    }

    /**
     * Checks if the cache contains the specified key.
     * 
     * @param key the key to check
     * @return true if the cache contains the key, false otherwise
     */
    public boolean contains(Key key) {
        if (key == null) return false;
        return map.containsKey(key);
    }

    /**
     * Removes all entries from the cache.
     */
    public void clear() {
        reentrantLock.lock();
        try {
            map.clear();
            queue.clear();
        } finally {
            reentrantLock.unlock();
        }
    }

    /**
     * Returns the number of entries in the cache.
     * 
     * @return the number of entries
     */
    public int size() {
        return map.size();
    }

    /**
     * Returns true if the cache is empty.
     * 
     * @return true if the cache is empty
     */
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public String toString() {
        reentrantLock.lock();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Queue => ").append(queue).append("\n")
              .append("Map Entries => ").append(map)
              .append("\nSize: ").append(size()).append("/").append(capacity);
            return sb.toString();
        } finally {
            reentrantLock.unlock();
        }
    }


    public static void main(String args[]) {
        CacheEngine<String, Integer> cacheEngine = new CacheEngine<>(4);
        cacheEngine.put("a", 10);
        cacheEngine.put("b", 20);
        cacheEngine.put("c", 30);
        cacheEngine.put("d", 40);

        System.out.println("Cache Entries: " + cacheEngine);

        cacheEngine.put("e", 50);

        System.out.println("Cache Entries: " + cacheEngine);

        System.out.print("get the value for b -> " + cacheEngine.get("b"));
        System.out.println("Cache Entries: " + cacheEngine);

        cacheEngine.clear();
        System.out.println("Cache Entries: " + cacheEngine);

    }
    
}
