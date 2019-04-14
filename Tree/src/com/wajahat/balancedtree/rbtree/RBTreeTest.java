package com.wajahat.balancedtree.rbtree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RBTreeTest {

    private RBTree rbTree;

    public RBTreeTest() {
        rbTree = new RBTree();
        rbTree.insert(10);
        rbTree.insert(5);
        rbTree.insert(30);
        rbTree.insert(-4);
        rbTree.insert(13);
        rbTree.insert(60);
        rbTree.insert(88);
    }

    @Test
    public void testInsert() {
        rbTree.insert(24);
        assertTrue(rbTree.contains(24));
    }

    @Test
    public void testSize() {
        assertEquals(rbTree.size(), 7);
    }

    @Test
    public void testDelete() {
        rbTree.delete(5);
        assertFalse(rbTree.contains(5));
        assertEquals(rbTree.size(), 6);
    }

    @Test
    public void testContains() {
        assertTrue(rbTree.contains(-1));
    }
}
