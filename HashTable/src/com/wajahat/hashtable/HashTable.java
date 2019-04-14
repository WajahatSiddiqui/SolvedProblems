package com.wajahat.hashtable;

import java.util.LinkedList;

/**
 * Hash Table
 * @author wajahat
 *
 * @param <Key> - generic key
 * @param <Value> - generic value
 */
public class HashTable<Key, Value> {
    private LinkedList<Cell<Key, Value>> [] linkedList;
    private int size;

    public HashTable(int size) {
        linkedList = new LinkedList[size];
    }

    public HashTable() {
        linkedList = new LinkedList[10];
    }

    /**
     * Gets the Value given the Key
     * @param key - the key
     * @return Value
     */
    public Value get(Key key) {
        int hash = getHash(key);
        if (linkedList[hash] == null) {
            return null;
        }
        for (Cell<Key, Value> cell : linkedList[hash]) {
            if (cell.equivalent(key)) {
                return cell.getValue();
            }
        }
        return null;
    }

    /**
     * Puts the Value based on the key
     * @param key - the key
     * @param value - the value to insert
     */
    public void put(Key key, Value value) {
        int hash = getHash(key);
        if (linkedList[hash] == null) {
            linkedList[hash] = new LinkedList<Cell<Key,Value>>();
        }

        // check if the key is already present then remove the cell
        for (Cell<Key, Value> cell : linkedList[hash]) {
            if (cell.equivalent(key)) {
                size--;
                linkedList[hash].remove(cell);
                break;
            }
        }

        linkedList[hash].add(new Cell<Key, Value>(key, value));
        size++;
    }

    /**
     * Check if key is present
     * @param key
     * @return true if the key is present, false otherwise
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }

    /**
     * @return current size of hash table
     */
    public int size() { return size; }

    /**
     * Removes the given key
     * @param key - the key to be removed
     */
    public void remove(Key key) {
        if (!contains(key)) {
            return;
        }
        int hash = getHash(key);
        for (Cell<Key, Value> cell : linkedList[hash]) {
            if (cell.equivalent(key)) {
                linkedList[hash].remove(cell);
                size--;
                break;
            }
        }
    }

    /*private static int randomInt(int min, int max) {
        return new Random().ints(min, (max + 1)).limit(1).findFirst().getAsInt();
    }*/

    private int getHash(Key key) {
        int N = linkedList.length;
        if (key instanceof Integer) {
            //System.out.println(key + "%" + N +" = " + ((Integer) key) % N);
            return ((Integer) key) % N;
        } else {
            return key.toString().length() % N;
        }
    }

    public boolean isEmpty() { return size == 0; }

    /**
     * String representation of hash table
     */
    @Override
    public String toString() {
        if (isEmpty()) return "";
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < linkedList.length; i++) {
            if (linkedList[i] == null) continue;
            sb.append("Bucket:"+i+"{");
            for (Cell<Key, Value> c : linkedList[i]) {
                sb.append(c);
            }
            sb.append("}");
        }
        return sb.toString();
    }
}
