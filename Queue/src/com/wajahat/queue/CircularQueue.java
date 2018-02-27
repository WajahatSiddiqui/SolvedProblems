package com.wajahat.queue;

public class CircularQueue<T> {
	T [] data;
	int capacity;
	int front, rear;
	int size;
	
	public CircularQueue(int N) {
		capacity = N;
		front = rear = 0;
		data = (T[]) new Object[N];
		size = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull() {
		return size == capacity;
	}
	
	public void enqueue(T key) {
		// Overflow
		if (isFull()) {
			return;
		}
		data[rear] = key;
		size++;
		rear = (rear + 1) % capacity;
	}
	
	public T dequeue() {
		// underflow
		if (isEmpty()) {
			return null;
		}
		T key = data[front];
		size--;
		front = (front + 1) % capacity;
		return key;
	}
	
	
	public boolean contains(T key) {
		if (isEmpty()) {
			return false;
		}
		
		for (int i = front; i < size; i++) {
			if (key.equals(data[i])) {
				return true;
			}
		}
		return false;
	}
	
	public int size() {
		return size;
	}
	
	public T front() {
		return !isEmpty() ? data[front] : null;
	}
	
	private int rearIndex() {
		return isFull() ? size-1 : rear-1;
	}
	
	public T rear() {
		return !isEmpty() ? data[rearIndex()] : null;
	}
	
	@Override
	public String toString() {
		if (isEmpty()) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for (int i = front; i <= rearIndex(); i++) {
			sb.append(data[i]);
			if (!data[i].equals(rear())) {
				sb.append("->");
			}
		}
		return sb.toString();
	}
}
