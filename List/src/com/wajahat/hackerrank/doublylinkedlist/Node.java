package com.wajahat.hackerrank.doublylinkedlist;

public class Node<Key> {
	Key key;
	Node<Key> prev;
	Node<Key> next;
	
	public Node(Key key) {
		this.key = key;
		this.prev = null;
		this.next = null;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Integer && Integer.compare((Integer)obj, (Integer) this.key) == 0;
	}
}
