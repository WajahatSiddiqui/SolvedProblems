package com.wajahat.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ListTest {
	
	private List<Integer> list;
	private Node<Integer> head;
	
	public ListTest() {
		list = new List<Integer>();
		head = list.insertLast(head, 10);
		head = list.insertLast(head, 20);
		head = list.insertLast(head, 30);
	}

	@Test
	public void testInsertFirst() {
		head = list.insertFirst(head, 40);
		assertTrue(list.contains(head, 40));
		assertEquals(4, list.size());
		assertEquals((Integer)40, (Integer)list.first(head));
		System.out.println("testInsertFirst: " + list.toString(head));
	}
	
	@Test
	public void testInsertLast() {
		head = list.insertLast(head, 40);
		assertTrue(list.contains(head, 40));
		assertEquals(4, list.size());
		assertEquals((Integer)40, (Integer)list.last(head));
		System.out.println("testInsertLast: " + list.toString(head));
	}
	
	@Test
	public void testInsertAt() {
		// first
		head = list.insertAt(head, 5, 0);
		assertTrue(list.contains(head, 5));
		assertEquals(4, list.size());
		
		// last
		head = list.insertAt(head, 40, list.size()-1);
		assertTrue(list.contains(head, 40));
		assertEquals(5, list.size());
		
		// middle
		head = list.insertAt(head, 17, 1);
		assertTrue(list.contains(head, 17));
		assertEquals(6, list.size());
		
		System.out.println("testInsertAt: " + list.toString(head));
	}
	
	@Test
	public void testDeleteFirst() {
		head = list.deleteFirst(head);
		assertTrue(!list.contains(head, 10));
		assertEquals(2, list.size());
		System.out.println("testDeleteFirst: " + list.toString(head));
	}
	
	@Test
	public void testDeleteLast() {
		head = list.deleteLast(head);
		assertTrue(!list.contains(head, 30));
		assertEquals(2, list.size());
		System.out.println("testDeleteLast: " + list.toString(head));
	}

	@Test
	public void testDeleteAt() {
		head = list.insertLast(head, 40);
		head = list.insertLast(head, 50);
		
		// first
		head = list.deleteAt(head, 0);
		assertTrue(!list.contains(head, 10));
		assertEquals(4, list.size());
		
		// last
		head = list.deleteAt(head, list.size()-1);
		assertTrue(!list.contains(head, 50));
		assertEquals(3, list.size());
		
		// middle
		head = list.deleteAt(head, 1);
		assertTrue(!list.contains(head, 30));
		assertEquals(2, list.size());
		
		System.out.println("testDeleteAt: " + list.toString(head));
	}

	@Test
	public void testDelete() {
		head = list.delete(head, 20);
		assertFalse(list.contains(head, 20));
		assertEquals(2, list.size());
		System.out.println("testDelete: " + list.toString(head));
	}

	@Test
	public void testSize() {
		assertEquals(3, list.size());
	}
	
	@Test
	public void testContains() {
		assertTrue(list.contains(head, 30));
		assertFalse(list.contains(head, 50));
	}
	
	@Test
	public void testToString() {
		System.out.println("testToString: " + list.toString(head));
	}
}
