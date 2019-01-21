package com.wajahat.hackerrank.queue;

/**
 * Queue: A FIFO List
 * @author wajahat
 *
 * @param <Key> - generic key
 */
public class Queue<Key> {
	
	private Node<Key> front, rear;
	private int size;
	
	public Queue() {
		front = rear = null;
		size = 0;
	}
	
	/**
	 * Enqueue given key
	 * @param key - the key to be enqueued
	 */
	public void enqueue(Key key) {
		Node<Key> node = new Node<>(key);
		if (isEmpty()) {
			front = rear = node;
		} else {
			rear.next = node;
			rear = node;
		}
		size++;
	}
	
	/**
	 * Dequeue the key from the queue
	 * @return key
	 */
	public Key dequeue() {
		if (isEmpty()) return null;
		Key key = front.key;
		front = front.next;
		if (front == null) {
			rear = null;
		}
		size--;
		return key;
	}
	
	/**
	 * @return Current size of queue
	 */
	public int size() { return size; }
	
	/**
	 * @return front of the queue
	 */
	public Key front() { return front.key; }
	
	/**
	 * @return rear of the queue
	 */
	public Key rear() { return rear.key; }
	
	/**
	 * Check if the queue is empty
	 * @return true if queue is empty, false otherwise
	 */
	public boolean isEmpty() { return front == null && rear == null; }
	
	/**
	 * Check if the key is present in the queue
	 * @param key - the key to check
	 * @return true if the key is contained in the queue, false otherwise
	 */
	public boolean contains(Key key) {
		if (isEmpty()) return false;
		Node<Key> curr = front;
		while (curr != null) {
			if (curr.key == key) {
				return true;
			}
			curr = curr.next;
		}
		return false;
	}
	
	/**
	 * String representation of this queue
	 */
	@Override
	public String toString() {
		if (isEmpty()) return "";
		StringBuffer sb = new StringBuffer();
		Node<Key> curr = front;
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
