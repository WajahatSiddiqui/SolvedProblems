package com.wajahat.hackerrank.hashtable;

public class Cell<Key, Value> {
	private Key key;
	private Value value;
	
	public Cell(Key k, Value v) {
		this.key = k;
		this.value = v;
	}
	
	public Key getKey() { return key; }
	public Value getValue() { return value;}
	
	public boolean equivalent(Object k) {
		if (k == this) return true;
		if (k == null) return false;
		if (k.getClass() != this.getClass()) return false;
		
		Key that = (Key) k;
		return that.equals(key);
	}
	
	@Override
	public String toString() {
		return "{"+key+"="+value+"}";
	}
}
