package com.wajahat.circularlinkedlist;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CircularListTest {
	
	private CircularList<Integer> circularList;
	
	public CircularListTest() {
		circularList = new CircularList<Integer>();
		circularList.insertLast(10);
		circularList.insertLast(20);
		circularList.insertLast(30);
	}

	@Test
	public void testInsertFirst() {
		circularList.insertFirst(5);
		assertEquals((Integer)5, circularList.first());
		assertTrue(circularList.contains(5));
		assertEquals(4, circularList.size());
		
		System.out.println("testInsertFirst : " + circularList);
	}

	@Test
	public void testInsertLast() {
		circularList.insertLast(40);
		assertEquals((Integer)40, circularList.last());
		assertTrue(circularList.contains(40));
		assertEquals(4, circularList.size());
		
		System.out.println("testInsertLast : " + circularList);
	}

	@Test
	public void testInsertAt() {		
		// insertFirst
		circularList.insertAt(5, 0);
		assertTrue(circularList.contains(5));
		assertEquals(4, circularList.size());
		assertEquals((Integer)5, circularList.first());
		
		// insertLast
		circularList.insertAt(40, circularList.size()-1);
		assertTrue(circularList.contains(40));
		assertEquals(5, circularList.size());
		assertEquals((Integer)40, circularList.last());
		
		// insert at a position
		circularList.insertAt(8, 1);
		assertTrue(circularList.contains(8));
		assertEquals(6, circularList.size());
		
		System.out.println("testInsertAt : " + circularList);
	}

	@Test
	public void testDeleteFirst() {
		circularList.deleteFirst();
		assertTrue(!circularList.contains(10));
		assertEquals(2, circularList.size());
		
		System.out.println("testDeleteFirst : " + circularList);
	}

	@Test
	public void testDeleteLast() {
		circularList.deleteLast();
		assertTrue(!circularList.contains(30));
		assertEquals(2, circularList.size());
		
		System.out.println("testDeleteLast : " + circularList);
	}

	@Test
	public void testDeleteAt() {
		circularList.insertLast(40);
		circularList.insertLast(50);
		
		// delete first
		circularList.deleteAt(0);
		assertTrue(!circularList.contains(10));
		assertEquals((Integer)20,  circularList.first());
		assertEquals(4, circularList.size());
		
		// delete last
		circularList.deleteAt(circularList.size()-1);
		assertTrue(!circularList.contains(50));
		assertEquals((Integer)40,  circularList.last());
		assertEquals(3, circularList.size());
		
		// delete a position
		circularList.deleteAt(1);
		assertTrue(!circularList.contains(30));
		assertEquals(2, circularList.size());
		
		System.out.println("testDeleteAt : " + circularList);
	}
	
	@Test
	public void testDelete() {
		circularList.delete(20);
		assertEquals(2, circularList.size());
		assertTrue(!circularList.contains(20));
		
		System.out.println("testDelete : " + circularList);
	}

	@Test
	public void testSize() {
		assertEquals(3, circularList.size());
	}

	@Test
	public void testContains() {
		assertTrue(circularList.contains(10));
		assertTrue(!circularList.contains(100));
	}

	@Test
	public void testToString() {
		System.out.println("testToString : " + circularList);
	}

}
