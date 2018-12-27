package com.wajahat.unionfind;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WeightedUnionFindTest {
	
	private WeightedUnionFind wuf;
	
	public WeightedUnionFindTest() {
		wuf = new WeightedUnionFind(10);
		wuf.union(1, 2);
		wuf.union(2, 3);
		wuf.union(2, 4);
		wuf.union(4, 5);
		wuf.union(4, 7);
		wuf.union(3, 4);
		wuf.union(5, 9);
		wuf.union(8, 1);
		wuf.union(0, 2);
	}
	

	@Test
	public void testConnected() {
		assertTrue(wuf.connected(0, 2));
	}
	
	@Test
	public void testFind() {
		assertEquals(1, wuf.root(2));
	}
	
	@Test
	public void testUnion() {
		wuf.union(9, 8);
		assertTrue(wuf.connected(9, 8));
		System.out.println("testUnion : " + wuf);
	}
	
	@Test
	public void testCount() {
		assertEquals(9, wuf.count(9));
	}
	
	@Test
	public void testToString() {
		System.out.println("testToString : " + wuf);
	}
}
