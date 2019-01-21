package com.wajahat.hackerrank.circularlinkedlist;


/**
 * Circular Linked List
 * We use last pointer instead of head pointer for easing out the
 * insertion and deletion operations
 * 
 * If we need to insert in last then there is no need to traverse,
 * if we need to insert at the first then last.next will be head
 * 
 * @author wajahat
 *
 * @param <Key> - the generic key
 */
public class CircularList<Key> {
	private Node<Key> last;
	private int size;

	public CircularList() {
		last = null;
		size = 0;
	}


	public void insertFirst(Key key) {
		Node<Key> node = new Node<>(key);
		if (last == null) {
			last = node;
			node.next = last;
		} else {
			node.next = last.next;
			last.next = node;
		}
		size++;
	}

	public void insertLast(Key key) {
		Node<Key> node = new Node<>(key);
		if (last == null) {
			last = node;
			node.next = last;
		} else {
			node.next = last.next;
			last.next = node;
			last = node;
		}
		size++;
	}

	public void insertAt(Key key, int position) {
		Node<Key> node = new Node<>(key);
		if (last == null) {
			last = node;
			node.next = last;
			size++;
			return;
		}

		if (position < 0 || position >= size) {
			throw new IllegalArgumentException("Invalid position : " + position);
		}

		if (position == 0) { // insert first
			insertFirst(key);
		} else if (position == size-1) { // insert last
			insertLast(key);
		} else {
			Node<Key> curr = last.next, prev = null;
			int count = 0;
			while (curr.next != last.next && count < position) {
				count++;
				prev = curr;
				curr = curr.next;
			}
			prev.next = node;
			node.next = curr;
			size++;
		}
	}

	public void deleteFirst() {
		if (last == null) {
			return;
		}
		Node<Key> curr = last.next;
		last.next = curr.next;
		curr.next = null;
		curr = null;
		size--;
	}

	public void deleteLast() {
		if (last == null) {
			return;
		}
		Node<Key> curr = last.next, prev = null;
		while (curr != last) {
			prev = curr;
			curr = curr.next;
		}
		prev.next = last.next;
		last = prev;
		curr = null;
		size--;
	}

	public void deleteAt(int position) {
		if (last == null) {
			return;
		}

		if (position < 0 || position >= size) {
			throw new IllegalArgumentException("Invalid position : " + position);
		}

		if (position == 0) {
			deleteFirst();
		} else if (position == size-1) {
			deleteLast();
		} else {
			Node<Key> curr = last.next, prev = null;
			int count = 0;
			while (curr.next != last.next && count < position) {
				count++;
				prev = curr;
				curr = curr.next;
			}
			prev.next = curr.next;
			curr = null;
			size--;
		}
	}

	public void delete(Key key) {
		if (last == null) {
			return;
		}
		Node<Key> curr = last.next, prev = null;
		do {
			prev = curr;
			curr = curr.next;
		} while (curr != last.next && !curr.key.equals(key));
		
		prev.next = curr.next;
		curr = null;
		size--;
	}

	public int size() { return size; }

	public Key first() {
		return last != null && last.next != null ? last.next.key : null;
	}

	public Key last() {
		return last != null ? last.key : null;
	}

	public boolean contains(Key key) {
		if (last == null) return false;

		Node<Key> curr = last.next;

		do {
			if (curr.key.equals(key)) {
				return true;
			}
			curr = curr.next;
		} while (curr != last.next);
		return false;
	}

	@Override
	public String toString() {
		if (last == null) return "";

		StringBuffer sb = new StringBuffer();

		Node<Key> curr = last.next;
		do {
			sb.append(curr.key).append(" ");
			curr = curr.next;
		} while (curr != last.next);
		return sb.toString();
	}
}
