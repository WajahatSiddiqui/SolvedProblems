package com.wajahat.balancedtrees.avltree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AvlTreeTest {

	private AvlTree avlTree;

	public AvlTreeTest() {
		avlTree = new AvlTree();
		avlTree.insert(10);
		avlTree.insert(5);
		avlTree.insert(30);
		avlTree.insert(-4);
		avlTree.insert(13);
		avlTree.insert(60);
		avlTree.insert(88);
	}

	@Test
	public void testInsert() {
		avlTree.insert(24);
		assertTrue(avlTree.contains(24));
	}

	@Test
	public void testSize() {
		assertEquals(avlTree.size(), 7);
	}

	@Test
	public void testDelete() {
		avlTree.delete(5);
		assertFalse(avlTree.contains(5));
		assertEquals(avlTree.size(), 6);
	}

	@Test
	public void testContains() {
		assertTrue(avlTree.contains(-1));
	}
}
