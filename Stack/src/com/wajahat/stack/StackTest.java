package com.wajahat.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StackTest {
	
	private Stack<Integer> stack;
	
	public StackTest() {
		stack = new Stack<>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
	}

	@Test
	public void testPush() {
		stack.push(40);
		assertTrue(stack.contains(40));
		assertEquals(stack.size(), 4);
		assertEquals(stack.top(), (Integer)40);
		System.out.println("testPush : " + stack);
	}

	@Test
	public void testPop() {
		assertEquals(stack.pop(), (Integer) 30);
		assertFalse(stack.contains(30));
		assertEquals(stack.size(), 2);
		System.out.println("testPop : " + stack);
	}

	@Test
	public void testTop() {
		assertEquals(stack.top(), (Integer) 30);
	}

	@Test
	public void testIsEmpty() {
		assertFalse(stack.isEmpty());
		assertEquals(stack.pop(), (Integer) 30); 
		assertEquals(stack.pop(), (Integer) 20);
		assertEquals(stack.pop(), (Integer) 10);
		assertEquals(stack.size(), 0);
		assertTrue(stack.isEmpty());
		System.out.println("testIsEmpty : " + stack);
	}

	@Test
	public void testSize() {
		assertEquals(stack.size(), 3);
	}

	@Test
	public void testContains() {
		assertTrue(stack.contains(30));
		assertFalse(stack.contains(100));
	}

	@Test
	public void testToString() {
		System.out.println("testToString : " + stack);
	}

}
