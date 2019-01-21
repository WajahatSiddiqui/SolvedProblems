package com.wajahat.hackerrank.doublylinkedlist;

/**
 * Doubly Linked List
 * @author wajahat
 *
 * @param <Key> - generic key
 */
public class DoublyList<Key> {

	private Node<Key> head, tail;
	private int size;

	public DoublyList() {
		head = null;
		tail = null;
		size = 0;
	}

	/**
	 * Insert the key at the first position of the list
	 * @param key - the key to be inserted
	 */
	public void insertFirst(Key key) {
		Node<Key> node = new Node<>(key);
		if (isEmpty()) {
			head = tail = node;
		} else {
			node.next = head;
			head.prev = node;
			head = node;
		}
		size++;
	}

	/**
	 * Insert the key at the end of the list
	 * @param key - the key to be inserted
	 */
	public void insertLast(Key key) {
		Node<Key> node = new Node<>(key);
		if (isEmpty()) {
			head = tail = node;
		} else {
			tail.next = node;
			node.prev = tail;
			tail = node;
		}
		size++;
	}

	/**
	 * Insert the key at the given position
	 * @param key - the key to be inserted
	 * @param position - position based on 0 ~ size -1
	 * @throws IllegalArgumentException
	 */
	public void insertAt(Key key, int position) throws IllegalArgumentException {
		Node<Key> node = new Node<>(key);
		if (isEmpty()) {
			head = tail = node;
		}

		if (position < 0 || position >= size) {
			throw new IllegalArgumentException("Invalid position " + position);
		}

		if (position == 0) { // first
			insertFirst(key);
		} else if (position == size - 1) { // last
			insertLast(key);
		} else { // at the given position
			Node<Key> curr = head;
			int count = 0;
			while (count != position && curr.next != null) {
				count++;
				curr = curr.next;
			}
			node.next = curr;
			node.prev = curr.prev;
			curr.prev.next = node;
			curr.prev = node;
			size++;
		}
	}

	/**
	 * Deletes the first node
	 */
	public void deleteFirst() {
		if (isEmpty()) return;
		if (size == 1) {
			head = tail = null;
			return;
		}
		Node<Key> curr = head;
		head = curr.next;
		head.prev = null;
		curr.next = null;
		curr = null;		
		size--;
	}

	/**
	 * Deletes the last node
	 */
	public void deleteLast() {
		if (isEmpty()) return;
		if (size == 1) {
			head = tail = null;
			return;
		}
		Node<Key> curr = tail;
		tail = curr.prev;
		curr.prev.next = null;
		curr.prev = null;
		curr = null;
		size--;
	}

	/**
	 * Deletes the node at the given position
	 * @param position
	 */
	public void deleteAt(int position) {
		if (isEmpty()) return;
		if (size == 1) {
			head = tail = null;
			return;
		}
		if (position < 0 || position >= size) {
			throw new IllegalArgumentException("Invalid index " + position);
		}
		Node<Key> curr = head;
		if (position == 0) { // first
			deleteFirst();
		} else if (position == size - 1) { //last 
			deleteLast();
		} else { // given position
			int count = 0;
			while (curr.next != null && count != position) {
				count++;
				curr = curr.next;
			}
			curr.next.prev = curr.prev;
			curr.prev.next = curr.next;
			curr.prev = null;
			curr.next = null;
			curr = null;
			size--;
		}
	}
	
	/**
	 * Deletes a node with the given key
	 * @param key - the key to be deleted
	 */
	public void delete(Key key) {
		if (isEmpty()) {
			return;
		}
		
		Node<Key> curr = head, prev = null;
		while (curr.next != null && !curr.key.equals(key)) {
			prev = curr;
			curr = curr.next;
		}
		prev.next = curr.next;
		curr.next.prev = prev;
		curr = null;
		size--;
	}

	/**
	 * @return first node in the list
	 */
	public Key first() {
		if (head == null) {
			return null;
		}

		return head.key;
	}

	/**
	 * @return last node in the list
	 */
	public Key last() {
		if (tail == null) {
			return null;
		}
		return tail.key;
	}

	/**
	 * Check if the key is contained in the list
	 * @param key - the key to be searched
	 * @return true if the key is contained in the list, false otherwise.
	 */
	public boolean contains(Key key) {
		Node<Key> curr = head;
		while (curr != null) {
			if (key.equals(curr.key)) {
				return true;
			}
			curr = curr.next;
		}
		return false;		
	}

	/**
	 * @return current size of the list
	 */
	public int size() { return size; }

	public boolean isEmpty() {
		return head == null && tail == null;
	}

	/**
	 * String representation of this list
	 */
	@Override
	public String toString() {
		Node<Key> curr = head;
		StringBuffer sb = new StringBuffer();
		while (curr != null) {
			sb.append(curr.key);
			curr = curr.next;
			if (curr != null) {
				sb.append("->");
			}
		}
		return sb.toString();
	}
	
	/**
	 * Print reverse using the tail pointer
	 * @return reverse string of this list
	 */
	public String printReverse() {
		Node<Key> curr = tail;
		StringBuffer sb = new StringBuffer();
		while (curr != null) {
			sb.append(curr.key);
			curr = curr.prev;
			if (curr != null) {
				sb.append("->");
			}
		}
		return sb.toString();
	}
}
