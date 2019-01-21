package com.wajahat.hackerrank.balancedtree.rbtree;

public class RBTree {
	
	private TreeNode root;
	private int size;
	
	public RBTree() {
		root = new TreeNode();
		size = 0;
	}

	public void insert(int data) {
		size++;
	}
	
	public void delete(int data) {
		size--;
	}
	
	public boolean contains(int data) {
		return false;
	}
	
	public int size() { return size; }
}
