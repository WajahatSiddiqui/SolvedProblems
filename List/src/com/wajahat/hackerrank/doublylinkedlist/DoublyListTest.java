package com.wajahat.hackerrank.doublylinkedlist;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DoublyListTest {
	
	private DoublyList<Integer> list;
	
	public DoublyListTest() {
		list = new DoublyList<>();
		list.insertLast(10);
		list.insertLast(20);
		list.insertLast(30);
		list.insertLast(40);
		list.insertLast(50);
	}

	@Test
	public void testInsertFirst() {
		list.insertFirst(-1);
		assertTrue(list.contains(-1));
		assertEquals((Integer)(-1), (Integer) list.first());
		assertEquals(6, list.size());
		System.out.println("testInsertFirst : " + list);
	}

	@Test
	public void testInsertLast() {
		list.insertLast(100);
		assertTrue(list.contains(100));
		assertEquals((Integer) 100, (Integer) list.last());
		assertEquals(6, list.size());
		System.out.println("testInsertLast : " + list);
	}

	@Test
	public void testInsertAt() {
		boolean isExceptionCaught = false;
		try {
			list.insertAt(45, 5);
		} catch (IllegalArgumentException e) {
			isExceptionCaught = true;
		}
		assertTrue(isExceptionCaught);
		
		// insert first
		list.insertAt(5, 0);
		assertTrue(list.contains(5));
		assertEquals((Integer) 5, list.first());
		assertEquals(6, list.size());
		
		// insert last
		list.insertAt(55, list.size()-1);
		assertTrue(list.contains(55));
		assertEquals((Integer)55, list.last());
		assertEquals(7, list.size());
		
		// insert middle
		list.insertAt(23, 2);
		assertTrue(list.contains(23));
		assertEquals(8, list.size());
		System.out.println("testInsertAt: " + list);
	}

	@Test
	public void testDeleteFirst() {
		list.deleteFirst();
		assertTrue(!list.contains(10));
		assertEquals(4, list.size());
		System.out.println("testDeleteFirst: " + list);
	}

	@Test
	public void testDeleteLast() {
		list.deleteLast();
		assertTrue(!list.contains(50));
		assertEquals(4, list.size());
		System.out.println("testDeleteLast: " + list);
	}

	@Test
	public void testDeleteAt() {
		// delete first
		list.deleteAt(0);
		assertTrue(!list.contains(10));
		assertEquals(4, list.size());
		
		// delete last
		list.deleteAt(list.size()-1);
		assertTrue(!list.contains(50));
		assertEquals(3, list.size());
		
		// delete middle
		list.deleteAt(1);
		assertTrue(!list.contains(30));
		assertEquals(2, list.size());
		System.out.println("testDeleteAt: " + list);
	}
	
	@Test
	public void testDelete() {
		// delete first
		list.delete(40);
		assertTrue(!list.contains(40));
		assertEquals(4, list.size());
		System.out.println("testDelete: " + list);
	}

	@Test
	public void testContains() {
		assertTrue(list.contains(50));
		assertFalse(list.contains(150));
	}

	@Test
	public void testSize() {
		assertEquals(5, list.size());
	}

	@Test
	public void testToString() {
		System.out.println("Forward: " + list.toString());		
	}
	
	@Test
	public void testPrintReverse() {
		System.out.println("Reverse: " + list.printReverse());
	}
}
