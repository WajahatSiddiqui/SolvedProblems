package com.wajahat.balancedtrees.rbtree;

public class TreeNode {
	public int data;
	public TreeNode left, right;
	public int balanceFactor;
	TreeNode(int data) {
		this.data = data;
	}
	
	public TreeNode() {
	}
}
