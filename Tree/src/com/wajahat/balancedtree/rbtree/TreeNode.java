package com.wajahat.balancedtree.rbtree;

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
