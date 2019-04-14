package com.wajahat;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
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
        root = binaryTree.insert(root, 10);
        root = binaryTree.insert(root, 11);
        root = binaryTree.insert(root, 20);
        root = binaryTree.insert(root, 12);
        root = binaryTree.insert(root, 12);
        root = binaryTree.insert(root, 13);
    }

    private boolean isEqual(List<Integer> list1, List<Integer> list2) {
        if (list1.size() != list2.size()) return false;

        int len = list1.size();
        for (int i = 0; i < len; i++) {
            if (!list1.get(i).equals(list2.get(i))) return false;
        }
        return true;
    }

    @Test
    public void testInsert() {
        assertTrue(binaryTree.contains(root, 13));
    }

    @Test
    public void testInorder() {
        assertTrue(isEqual(Stream.of(12, 11, 12, 10, 13, 20).collect(Collectors.toList())
                ,binaryTree.inorder(root)));
    }

    @Test
    public void testPreorder() {
        assertTrue(isEqual(Stream.of(10, 11, 12, 12, 20, 13).collect(Collectors.toList())
                ,binaryTree.preorder(root)));
    }

    @Test
    public void testPostorder() {
        assertTrue(isEqual(Stream.of(12, 12, 11, 13, 20, 10).collect(Collectors.toList())
                ,binaryTree.postorder(root)));
    }

    @Test
    public void testLevelOrder() {
        assertTrue(isEqual(Stream.of(10, 11, 20, 12, 12, 13).collect(Collectors.toList())
                ,binaryTree.levelOrder(root)));
    }

    @Test
    public void testTopView() {
        assertTrue(isEqual(Stream.of(10, 11, 20, 12).collect(Collectors.toList())
                ,binaryTree.topView(root)));
    }

    @Test
    public void testBottomView() {
        assertTrue(isEqual(Stream.of(12, 11, 13, 20).collect(Collectors.toList()), binaryTree.bottomView(root)));
    }

    @Test
    public void testSpiralView() {
        assertTrue(isEqual(Stream.of(10, 11, 20, 12, 12, 13).collect(Collectors.toList()), binaryTree.spiralView(root)));
    }

    @Test
    public void testLCA() {
        assertEquals(10, binaryTree.lca(root, 12, 13).data);
    }

    @Test
    public void testMirror() {
        BinaryTree tree = new BinaryTree();
        BinaryTree.TreeNode root = null;
        root = tree.insert(root, 4);
        root = tree.insert(root, 3);
        root = tree.insert(root, 2);
        root.left.right = new BinaryTree.TreeNode(1);
        assertTrue(isEqual(Stream.of(2, 4, 1, 3).collect(Collectors.toList()), binaryTree.inorder(binaryTree.mirror(root))));

    }

    @Test
    public void testIsMirror() {
        BinaryTree tree = new BinaryTree();
        BinaryTree.TreeNode root = null;
        root = tree.insert(root, 4);
        root = tree.insert(root, 3);
        root = tree.insert(root, 2);
        root.left.right = new BinaryTree.TreeNode(1);

        BinaryTree.TreeNode mirror = null;
        mirror = tree.insert(mirror, 4);
        mirror = tree.insert(mirror, 2);
        mirror = tree.insert(mirror, 3);
        mirror.right.left = new BinaryTree.TreeNode(1);
        assertTrue(tree.isMirror(root, mirror));
    }
}
