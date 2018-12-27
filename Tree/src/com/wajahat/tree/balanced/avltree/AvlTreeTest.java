package com.wajahat.tree.balanced.avltree;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AvlTreeTest {
	
	private AvlTree avlTree;
	
	public AvlTreeTest() {
		avlTree = new AvlTree();
		avlTree.insert(2);
		avlTree.insert(3);
		avlTree.insert(4);
		avlTree.insert(5);
		avlTree.insert(6);
		avlTree.insert(-1);
		avlTree.insert(-10);
		avlTree.insert(-100);
	}

	@Test
	public void testInsert() {
		avlTree.insert(-99);
		assertTrue(avlTree.contains(-99));
		assertEquals(9, avlTree.size());
		System.out.println("testInsert : " + avlTree);
	}

	@Test
	public void testContains() {
		assertTrue(!avlTree.contains(-99));
		assertTrue(avlTree.contains(5));
	}

	@Test
	public void testDelete() {
		avlTree.delete(-10);
		assertTrue(!avlTree.contains(-10));
		System.out.println("testDelete : " + avlTree);
	}

	@Test
	public void testInorder() {
		List<Integer> list = avlTree.inorder();
		int size = list.size();
		for (int i = 1; i < size; i++) {
			assertTrue(list.get(i-1) < list.get(i));
		}
	}

	@Test
	public void testSize() {
		assertEquals(8, avlTree.size());
	}

	@Test
	public void testToString() {
		System.out.println("testToString : " + avlTree);
	}

}
