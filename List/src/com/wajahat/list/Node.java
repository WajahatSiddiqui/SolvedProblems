package com.wajahat.list;


public class Node<Key> {
	Key key;
	Node<Key> next;
	
	public Node(Key key) {
		this.key = key;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Integer && Integer.compare((Integer)obj, (Integer) this.key) == 0;
	}
}