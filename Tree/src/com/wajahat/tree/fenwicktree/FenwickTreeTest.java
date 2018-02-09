package com.wajahat.tree.fenwicktree;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FenwickTreeTest {
	
	private FenwickTree fenwickTree = new FenwickTree();
	private int[] input = {1,2,3,4,5,6,7};
	
	public FenwickTreeTest() {
		fenwickTree.createTree(input);	
	}
	
	@Test
	public void testCreateTree() {
		assertEquals(0, fenwickTree.getIndexValue(0));
		assertEquals(1, fenwickTree.getIndexValue(1));
		assertEquals(3, fenwickTree.getIndexValue(2));
		assertEquals(3, fenwickTree.getIndexValue(3));
		assertEquals(10, fenwickTree.getIndexValue(4));
		assertEquals(5, fenwickTree.getIndexValue(5));
		assertEquals(11, fenwickTree.getIndexValue(6));
		assertEquals(7, fenwickTree.getIndexValue(7));
		
		System.out.println("testCreateTree : " + fenwickTree);
	}

	@Test
	public void testGetSum() {
		assertEquals(1, fenwickTree.getSum(0));
		assertEquals(3, fenwickTree.getSum(1));
		assertEquals(6, fenwickTree.getSum(2));
		assertEquals(10, fenwickTree.getSum(3));
		assertEquals(15, fenwickTree.getSum(4));
		assertEquals(21, fenwickTree.getSum(5));
		assertEquals(28, fenwickTree.getSum(6));
		assertEquals(-1, fenwickTree.getSum(7));
	}
}
