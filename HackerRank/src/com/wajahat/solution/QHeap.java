package com.wajahat.solution;

import java.util.Arrays;
import java.util.Scanner;

public class QHeap {

	private static class Heap {
		private int size;
		private int capacity;
		private int [] items;
		public Heap(int capacity) {
			items = new int[capacity];
			this.capacity = capacity;
		}

		public void add(int item) {
			resizeIfNecessary();
			items[size] = item;
			size++;
			heapifyUp(size-1);
		}

		public void delete(int item) {
			if (size == 0) throw new IllegalStateException();
			if (item != items[0]) {
				int index = getIndex(item);
				items[index] = Integer.MIN_VALUE;
				heapifyUp(index);
			}
			poll();
		}

		public int peek() {
			if (size == 0) throw new IllegalStateException();
			return items[0];
		}

		private int poll() {
			if (size == 0) throw new IllegalStateException();
			int item = items[0];
			items[0] = items[size-1];
			size--;
			heapifyDown();
			return item;
		}

		private void resizeIfNecessary() {
			if (size == capacity) {
				Arrays.copyOf(items, 2*capacity);
				capacity *= 2;
			}
		}

		private void heapifyUp(int index) {
			while (hasParent(index) && parent(index) > items[index]) {
				swap(getParentIndex(index), index);
				index = getParentIndex(index);
			}
		}

		private void heapifyDown() {
			int index = 0;
			while (hasLeftChild(index)) {
				int smallestChildIndex = getLeftChildIndex(index);
				if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
					smallestChildIndex = getRightChildIndex(index);
				}

				if (items[index] < items[smallestChildIndex]) break;
				else {
					swap(index, smallestChildIndex);
				}
				index = smallestChildIndex;
			}
		}

		private int getParentIndex(int i) { return (i-1)/2; }
		private int getLeftChildIndex(int i) { return 2*i + 1; }
		private int getRightChildIndex(int i) { return 2*i + 2; }

		private boolean hasParent(int i) { return getParentIndex(i) >= 0; }
		private boolean hasLeftChild(int i) { return getLeftChildIndex(i) < size; }
		private boolean hasRightChild(int i) { return getRightChildIndex(i) < size; }

		private int parent(int i) { return items[getParentIndex(i)]; }
		private int leftChild(int i) { return items[getLeftChildIndex(i)]; }
		private int rightChild(int i) { return items[getRightChildIndex(i)]; }

		private void swap(int index1, int index2) {
			int tmp = items[index1];
			items[index1] = items[index2];
			items[index2] = tmp;
		}

		private int getIndex(int key) {
			if (size == 0) return - 1;
			for (int i = 0; i < size; i++) {
				if (items[i] == key) return i;
			}
			return -1;
		}
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int q = scanner.nextInt();
			int type, v;
			Heap heap = new Heap(q);
			while (q > 0) {
				type = scanner.nextInt();
				switch (type) {
				// add
				case 1:
					v = scanner.nextInt();
					heap.add(v);
					break;
					// delete
				case 2:
					v = scanner.nextInt();
					heap.delete(v);
					break;
					// print min
				case 3:
					System.out.println(heap.peek());
					break;
				default:
					break;
				}
				q--;
			}
		}
	}
}
