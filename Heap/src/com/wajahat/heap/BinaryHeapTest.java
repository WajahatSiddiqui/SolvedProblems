package com.wajahat.heap;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryHeapTest {
	private BinaryHeap binaryHeap;
	
	public BinaryHeapTest() {
		binaryHeap = new BinaryHeap(10);
		binaryHeap.add(5);
		binaryHeap.add(2);
		binaryHeap.add(7);
		binaryHeap.add(10);
		binaryHeap.add(1);
	}

	@Test
	public void testPeek() {
		assertEquals(binaryHeap.peek(), 1);
	}

	@Test
	public void testPoll() {
		int size = binaryHeap.size();
		int item =  binaryHeap.poll();
		
		assertEquals(item, 1);
		assertEquals(binaryHeap.size(), size-1);
		assertEquals(binaryHeap.peek(), 2);
		
		System.out.println("testPoll : " + binaryHeap);
	}

	@Test
	public void testAdd() {
		int size = binaryHeap.size();
		binaryHeap.add(-1);
		assertEquals(-1, binaryHeap.peek());
		assertEquals(size+1, binaryHeap.size());
		
		System.out.println("testAdd : " + binaryHeap);
	}

	@Test
	public void testDelete() {
		int size = binaryHeap.size();
		binaryHeap.delete(10);
		assertEquals(binaryHeap.peek(), 1);
		assertEquals(binaryHeap.size(), size-1);
		
		System.out.println("testDelete : " + binaryHeap);
	}
	
	@Test
	public void testToString() {
		System.out.println("testToString : " + binaryHeap);
	}

}
