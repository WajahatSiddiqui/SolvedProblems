package com.wajahat.tree.bst;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BSTTest {

	private BST bst;
	
	public BSTTest() {
		bst = new BST();
		bst.insert(10);
		bst.insert(2);
		bst.insert(3);
		bst.insert(4);
		bst.insert(5);
		bst.insert(12);
		bst.insert(14);		
		bst.insert(20);
	}
	
	@Test
	public void testSize() {
		assertEquals(bst.size(), 8);
	}
	
	@Test
	public void testInsert() {
		bst.insert(32);
		assertEquals(bst.size(), 9);
		assertTrue(bst.contains(32));
		System.out.println("testInsert : " + bst);
	}
	
	@Test
	public void testContains() {
		assertTrue(bst.contains(20));
		assertFalse(bst.contains(11));
	}
	
	@Test
	public void testDelete() {
		bst.delete(20);
		assertFalse(bst.contains(20));
		assertEquals(bst.size(), 7);
		System.out.println("testDelete : " + bst);

		bst.delete(12);
		assertFalse(bst.contains(12));
		assertEquals(bst.size(), 6);
		System.out.println("testDelete : " + bst);

		bst.delete(10);
		assertFalse(bst.contains(10));
		assertEquals(bst.size(), 5);
		System.out.println("testDelete : " + bst);

		bst.insert(1);
		bst.delete(3);
		bst.delete(4);
		bst.delete(5);
		bst.delete(2);

		assertFalse(bst.contains(2));
		System.out.println("testDelete : " + bst);
	}
	
	@Test
	public void testInorder() {
		List<Integer> list = bst.inorder();
		int size = list.size();
		for (int i = 1; i < size; i++) {
			assertTrue(list.get(i-1) < list.get(i));
		}
	}

	@Test
	public void testHeight() {
		assertEquals(bst.getHeight(bst.getRoot()), 5);
	}

	@Test
	public void testPrint() {
		System.out.println(bst);
	}

	@Test
	public void testMinNode() {
		TreeNode minNode = bst.minNode();
		assertNotNull(minNode);
		assertEquals(2, minNode.data);
	}

	@Test
	public void testMaxNode() {
		TreeNode maxNode = bst.maxNode();
		assertNotNull(maxNode);
		assertEquals(20, maxNode.data);
	}

	@Test
	public void inorderSuccessor() {
		TreeNode node = bst.getRoot().left;
		TreeNode succ = bst.inorderSuccessor(node);
		assertNotNull(succ);
		assertEquals(3, succ.data);

		node = node.right.right.right;
		succ = bst.inorderSuccessor(node);
		assertNotNull(succ);
		assertEquals(10, succ.data);
	}
}
