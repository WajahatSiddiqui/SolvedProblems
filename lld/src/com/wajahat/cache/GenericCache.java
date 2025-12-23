package com.wajahat.cache;

public abstract class GenericCache<Key, Value> {
    protected final Integer CAPACITY;
    
    public GenericCache(Integer capacity) {
        if (capacity <= 0 || capacity > Integer.MAX_VALUE)
            throw new IllegalArgumentException("Invalid Capacity Limit (capacity > 0 and capacity < Integer.MAX_VALUE)");

        this.CAPACITY = capacity;
    }

    public Value get(Key key) {
        return null;
    }

    public void put(Key key, Value value) {
        return;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void evict(Key key) {

    }
}
