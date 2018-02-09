package com.wajahat.hashtable;

public class Cell<Key, Value> {
	private Key key;
	private Value value;
	
	public Cell(Key k, Value v) {
		this.key = k;
		this.value = v;
	}
	
	public Key getKey() { return key; }
	public Value getValue() { return value;}
	
	public boolean equivalent(Key k) {
		return k.equals(key);
	}
	
	@Override
	public String toString() {
		return "{"+key+"="+value+"}";
	}
}
