package com.wajahat.hackerrank.heap;

import java.util.Arrays;

/**
 * Binary Heap Implementation
 * @author Wajahat Siddiqui
 */
public class BinaryHeap {
	private int [] mItems;
	private int size = 0; // current size
	private int capacity;

	public BinaryHeap(int capacity) {
		mItems = new int[capacity];
		this.capacity = capacity;
	}
	
	/**
	 * @return current size of heap
	 */
	public int size() { return size; } 

	/**
	 * Returns the root element in the heap
	 * @return root element in the heap without removing
	 */
	public int peek() {
		if (size == 0) throw new IllegalStateException();
		return mItems[0];
	}

	/**
	 * Removes the item and return the first element
	 * @return removes the root element and return that element
	 */
	public int poll() {
		if (size == 0) throw new IllegalStateException();
		int item = mItems[0];
		mItems[0] = mItems[size-1];
		size--;
		heapifyDown();
		return item;
	}

	/**
	 * Adds a new item to heap 
	 * @param item - the item to be added
	 */
	public void add(int item) {
		resizeIfNecessary();
		mItems[size] = item;
		size++;
		heapifyUp(size-1);
	}

	/**
	 * Delete item from the heap
	 * @param item to be deleted
	 */
	public void delete(int item) {
		if (size == 0) throw new IllegalStateException();
		// decrease the key
		if (item != mItems[0]) {
			int index = getIndex(item);
			mItems[index] = Integer.MIN_VALUE;
			heapifyUp(index);
		}
		// extract min
		poll();
	}
	
	private int getParentIndex(int i) { return (i - 1)/2; }
	private int getLeftChildIndex(int i) { return 2*i + 1; }
	private int getRightChildIndex(int i) { return 2*i + 2; }
	private int getIndex(int key) {
		if (size == 0) throw new IllegalStateException();
		for (int i = 0; i < size; i++) {
			if (mItems[i] == key) return i;
		}
		return -1;
	}

	private boolean hasParent(int i) { return getParentIndex(i) >= 0; }
	private boolean hasRightChild(int i) { return getRightChildIndex(i) < size; }
	private boolean hasLeftChild(int i) { return getLeftChildIndex(i) < size; }

	private int parent(int i) {return mItems[getParentIndex(i)]; }
	private int leftChild(int i) { return mItems[getLeftChildIndex(i)];}
	private int rightChild(int i) { return mItems[getRightChildIndex(i)]; }

	private void swap(int i1, int i2) {
		int tmp = mItems[i1];
		mItems[i1] = mItems[i2];
		mItems[i2] = tmp;
	}

	private void resizeIfNecessary() {
		if (size == capacity) {
			Arrays.copyOf(mItems, capacity * 2);
			capacity *= 2;
		}
	}
	
	private void heapifyUp(int index) {
		while (hasParent(index) && parent(index) > mItems[index]) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}
	
	private void heapifyDown() {
		int index = 0;
		while (hasLeftChild(index)) {
			// find the smallest value index
			int smallerChildIndex = getLeftChildIndex(index);
			if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
				smallerChildIndex = getRightChildIndex(index);
			}
			
			// check if its already in order
			if (mItems[index] < mItems[smallerChildIndex]) break;
			else {
				swap(index, smallerChildIndex);
			}
			index = smallerChildIndex;
		}
	}
	
	public boolean isEmpty() { return size == 0; }
	
	@Override
	public String toString() {
		if (isEmpty()) { return ""; }
		StringBuffer sb = new StringBuffer();
		for (int i : mItems) {
			sb.append(i + " ");
		}
		return "size = " + size + " items: {" + sb.toString() +"}";
	}
}
