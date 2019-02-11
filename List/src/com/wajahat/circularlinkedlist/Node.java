package com.wajahat.circularlinkedlist;

public class Node<Key> {
	Key key;
	Node<Key> next;
	
	public Node(Key key) {
		this.key = key;
		this.next = null;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Integer && Integer.compare((Integer)obj, (Integer)this.key) == 0; 
	}
}
