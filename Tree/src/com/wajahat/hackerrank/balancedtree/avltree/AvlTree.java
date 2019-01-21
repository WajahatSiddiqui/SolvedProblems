package com.wajahat.hackerrank.balancedtree.avltree;

public class AvlTree {
	
	private TreeNode root;
	private int size;
	
	public AvlTree() {
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
