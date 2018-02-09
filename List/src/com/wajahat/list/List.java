package com.wajahat.list;

/**
 * Singly Linked List
 * @author wajahat
 *
 * @param <Key> generic type
 */
public class List<Key> {

	private int size;
	
	public List() {
		size = 0;
	}
	
	/**
	 * Insert the key to the first position of the list
	 * @param key - the key to be inserted
	 */
	public Node<Key> insertFirst(Node<Key> head, Key key) {
		Node<Key> node = new Node<>(key);
		if (head == null) {
			head = node;
		} else {
			node.next = head;
			head = node;
		}
		size++;
		return head;
	}
	
	/**
	 * Insert the key at the end of the list
	 * @param key - the key to be inserted
	 */
	public Node<Key> insertLast(Node<Key> head, Key key) {
		Node<Key> node = new Node<>(key);
		if (head == null) {
			head = node;
		} else {
			Node<Key> curr = head;
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = node;
		}
		size++;
		return head;
	}
	
	/**
	 * Insert the key at the given position
	 * @param key - the key to be inserted
	 * @param position - position from 0 ~ size -1
	 */
	public Node<Key> insertAt(Node<Key> head, Key key, int position) {
		Node<Key> node = new Node<>(key);
		if (head == null) {
			head = node;
		}
		
		if (position < 0 || position > size-1) {
			throw new IllegalArgumentException("Invalid position: " + position);
		}
		
		if (position == 0) { // insertFirst
			return insertFirst(head, key);
		} else if (position == size-1) { // insertLast
			return insertLast(head, key);
		} else { // insert at the given position
			Node<Key> curr = head, prev = null;
			int count = 0;
			while (curr.next != null && count < position ) {
				count++;
				prev = curr;
				curr = curr.next;				
			}
			prev.next = node;
			node.next = curr;
			size++;
			return head;
		}
	}
	
	/**
	 * Deletes the first node
	 */
	public Node<Key> deleteFirst(Node<Key> head) {
		if (head == null) return null;
		Node<Key> curr = head;
		head = curr.next;
		curr = null;
		size--;
		return head;
	}
	
	/**
	 * Deletes the last node
	 */
	public Node<Key> deleteLast(Node<Key> head) {
		if (head == null) return null;
		Node<Key> curr = head, prev = null;
		while (curr.next != null) {
			prev = curr;
			curr = curr.next;
		}
		prev.next = null;
		curr = null;
		size--;
		return head;
	}
	
	/**
	 * Deletes the node at the given position
	 * @param position - position within 0 ~ size -1
	 */
	public Node<Key> deleteAt(Node<Key> head, int position) {
		if (head == null) return null;
		if (position < 0 || position > size - 1) {
			throw new IllegalArgumentException("Invalid position " + position);
		}
		if (position == 0) {
			return deleteFirst(head);
		} else if (position == size-1) {
			return deleteLast(head);
		} else {
			Node<Key> curr = head, prev = null;
			int count = 0;
			while (curr.next != null && count < position) {
				count++;
				prev = curr;
				curr = curr.next;
			}
			prev.next = curr.next;
			curr = null;
			size--;
			return head;
		}
	}

	/**
	 * Deletes the given key
	 * @param key - the key to be deleted
	 */
	public Node<Key> delete(Node<Key> head, Key key) {
		if (head == null) return null;
		Node<Key> curr = head, prev = null;
		while (curr.next != null && !curr.equals(key)) {
			prev = curr;
			curr = curr.next;
		}
		prev.next = curr.next;
		curr = null;
		size--;
		return head;
	}
	
	/**
	 * @return the first key in the linked list
	 */
	public Key first(Node<Key> head) {
		return head == null ? null : head.key;
	}
	
	/**
	 * @return the last key in the linked list
	 */
	public Key last(Node<Key> head) {
		if (head == null) {
			return null;
		}
		
		Node<Key> curr = head;
		while (curr.next != null) {
			curr = curr.next;
		}
		return curr.key;
	}
	

	/**
	 * @return current size of the list
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Checks if the given key is present in the linked list
	 * @param key - the key to be checked
	 * @return true if the key is contained in the linked list, false otherwise
	 */
	public boolean contains(Node<Key> head, Key key) {
		if (head == null) return false;
		
		Node<Key> curr = head;
		while (curr != null) {
			if (curr.equals(key)) {
				return true;
			}
			curr = curr.next;
		}
		return false;
	}
	
	/**
	 * @return string representation of list object
	 */
	public String toString(Node<Key> head) {
		if (head == null) return "";
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
}
