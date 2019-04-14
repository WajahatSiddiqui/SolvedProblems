package com.wajahat.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Stack : A LIFO list
 * @author wajahat
 *
 * @param <Key> - generic key
 */
public class Stack<Key> {

    private Node<Key> head;
    private int size;

    public Stack() {
        head = null;
        size = 0;
    }

    /**
     * Push a key into stack
     * @param key - the key to be pushed
     */
    public void push(Key key) {
        Node<Key> node = new Node<>(key);
        if (isEmpty()) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    /**
     * Pop the topmost key from the stack
     * @return top most item
     */
    public Key pop() {
        if (isEmpty()) return null;
        Key key = head.key;
        head = head.next;
        size--;
        return key;
    }

    /**
     * Peek top most key
     * @return top most key
     */
    public Key top() { return head.key; }

    /**
     * Check if stack is empty
     * @return true if stack is empty, false otherwise.
     */
    public boolean isEmpty() { return head == null; }

    /**
     * Returns the current size of stack
     * @return current size of stack
     */
    public int size() { return size; }

    /**
     * Checks if the given key is present in the stack
     * @param key the key
     * @return true if the key is present, false otherwise.
     */
    public boolean contains(Key key) {
        if (isEmpty()) return false;
        Node<Key> curr = head;
        while (curr != null) {
            if (curr.key.equals(key)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public List<Integer> toList() {
        if (isEmpty()) return null;
        List<Integer> list = new ArrayList<>();
        Node<Key> curr = head;
        while (curr != null) {
            list.add((Integer) curr.key);
            curr = curr.next;
        }
        return list;
    }

    /**
     * Returns the stack contents
     */
    @Override
    public String toString() {
        if (isEmpty()) return "";
        StringBuffer sb = new StringBuffer();
        Node<Key> curr = head;
        while (curr != null) {
            sb.append(curr.key);
            curr = curr.next;
            if (curr != null) {
                sb.append("->");
            }
        }
        return sb.toString();
    }
}