package com.wajahat.tree.balanced.avltree;

import java.util.ArrayList;
import java.util.List;

/**
 * AVL Tree - A Balanced Binary Search Tree
 * @author wajahat
 *
 * @param <Key> - generic key
 */
public class AvlTree {
	private TreeNode root;
	private int size;

	public AvlTree() {
		root = null;
		size = 0;
	}

	/**
	 * Insert a new node with the given key
	 * @param data - the key to be inserted
	 */
	public void insert(int data) {
		root = insert(root, data);
		size++;

	}

	private TreeNode insert(TreeNode root, int data) {
		if (root == null) {
			root = new TreeNode(data);
		} else if (root.data < data) {
			return insert(root.left, data);
		} else {
			return insert(root.right, data);
		}


		// balance the tree

		return root;
	}

	/**
	 * Check if the key is present in the AVL tree
	 * @param data - the key to be searched for
	 * @return true if the key is present, false otherwise
	 */
	public boolean contains(int data) {
		return containsUtil(root, data);
	}

	private boolean containsUtil(TreeNode root, int data) {
		if (root == null) return false;
		if (root.data == data) return true;
		if (root.data < data)
			return containsUtil(root.left, data);
		else
			return containsUtil(root.right, data);
	}

	/**
	 * Delete the key from the AVL Tree
	 * @param data - the key to be deleted
	 */
	public void delete(int data) {
		root = delete(root, data);
		size--;
	}
	
	private TreeNode minNode(TreeNode root) {
		if (root == null) {
			return root;
		}
		TreeNode curr = root;
		if (curr.left != null) {
			curr = curr.left;
		}
		return curr;
		
	}

	private TreeNode delete(TreeNode root, int data) {
		if (root == null) {
			return null;
		}

		if (root.data == data) {
			if (root.left == null && root.right == null) {
				root = null;
				return root;
			} else if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}
			TreeNode minNode = minNode(root.right);
			root.data = minNode.data;
			root.right = delete(root.right, minNode.data);
		}
		if (data <= root.data) {
			root.left = delete(root.left, data);
		} else {
			root.right = delete(root.right, data);
		}
		
		// adjust the tree balance
		
		return root;
	}

	/**
	 * @return inorder traversal
	 */
	public List<Integer> inorder() {
		List<Integer> list = new ArrayList<>(size);
		inorder(root, list);
		return list;
	}

	private void inorder(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		inorder(root.left, list);
		//System.out.printf("%d ", root.data);
		list.add(root.data);
		inorder(root.right, list);
	}

	/**
	 * @return current size of AVL Tree
	 */
	public int size() { return size; }

	// calculate the balance factor
	private int balance(TreeNode rootLeft, TreeNode rootRight) {
		return height(root.left) - height(rootRight);
	}

	private int setHeight(TreeNode root){
		if(root == null){
			return 0;
		}
		return 1 + Math.max((root.left != null ? root.left.height : 0), (root.right != null ? root.right.height : 0));
	}

	private int height(TreeNode node) {
		if (node == null) return 0;
		return node.height;
	}

	private void leftRotate(TreeNode node) {

	}

	private void rightRotate(TreeNode node) {

	}

	/**
	 * String representation of AVL Tree
	 */
	@Override
	public String toString() {
		return inorder().toString();
	}
}
