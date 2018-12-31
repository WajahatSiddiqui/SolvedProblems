package com.wajahat.tree.bst;

// Validate a given binary tree as BST
// Created by Wajahat
public class ValidateBST {

    private static boolean isBST(TreeNode root, Integer prev) {
        if (root == null) return false;

        if (!isBST(root.left, prev)) return false;

        if (prev != null && root.data <= prev) return false;
        prev = root.data;

        return isBST(root.right, prev);
    }

    public static void main(String args[]) {
        BST bst = new BST();
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        bst.insert(5);
        bst.insert(4);

        if (isBST(bst.getRoot(), null)) {
            System.out.println("it is bst");
        }

    }
}
