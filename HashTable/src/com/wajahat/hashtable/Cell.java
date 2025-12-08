package com.wajahat.hashtable;

public class Cell<Key, Value> {
    private Key key;
    private Value value;

    public Cell(Key k, Value v) {
        this.key = k;
        this.value = v;
    }

    public Key getKey() { return key; }
    public Value getValue() { return value;}

    public boolean equivalent(Object k) {
        if (k == null) return false;
        if (this.key == null) return false;
        return k == this.key || this.key.equals(k);
    }

    @Override
    public String toString() {
        return "{"+key+"="+value+"}";
    }
}
