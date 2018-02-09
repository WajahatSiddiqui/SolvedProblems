package com.wajahat.queue;

public class Node<Key> {
	Key key;
	Node<Key> next;
	
	public Node(Key key) {
		this.key = key;
		next = null;
	}
}
