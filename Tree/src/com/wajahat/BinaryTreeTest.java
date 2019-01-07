package com.wajahat;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Test for Binary Tree
 * Created by Wajahat
 **/
public class BinaryTreeTest {
    private BinaryTree binaryTree;
    private BinaryTree.TreeNode root;

    public BinaryTreeTest() {
        binaryTree = new BinaryTree();
        root = null;
    }

    @Test
    public void testInsert() {
        root = binaryTree.insert(root, 10);
        root = binaryTree.insert(root, 11);
        root = binaryTree.insert(root, 20);
        root = binaryTree.insert(root, 12);
        root = binaryTree.insert(root, 12);
        root = binaryTree.insert(root, 13);

        assertTrue(binaryTree.contains(root, 13));
    }

    @Test
    public void inorder() {
        root = binaryTree.insert(root, 10);
        root = binaryTree.insert(root, 11);
        root = binaryTree.insert(root, 20);
        root = binaryTree.insert(root, 12);
        root = binaryTree.insert(root, 12);
        root = binaryTree.insert(root, 13);
        binaryTree.inorder(root);
    }

    @Test
    public void testTopView() {
        root = binaryTree.insert(root, 10);
        root = binaryTree.insert(root, 11);
        root = binaryTree.insert(root, 20);
        root = binaryTree.insert(root, 12);
        root = binaryTree.insert(root, 12);
        root = binaryTree.insert(root, 13);

        binaryTree.topView(root);
    }
}
