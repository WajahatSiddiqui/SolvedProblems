package com.wajahat.queue;

import static org.junit.Assert.*;

import org.junit.Test;

public class CircularQueueTest {
	private CircularQueue<Integer> circularQueue;
	public CircularQueueTest() {
		circularQueue = new CircularQueue<>(5);
		circularQueue.enqueue(1);
		circularQueue.enqueue(2);
		circularQueue.enqueue(3);
		circularQueue.enqueue(4);
	}
	
	@Test
	public void testEnqueue() {
		circularQueue.enqueue(5);
		assertEquals((Integer) 1, (Integer) circularQueue.front());
		assertEquals((Integer) 5, (Integer)circularQueue.rear());
		assertTrue(circularQueue.contains(5));
		assertEquals(5, circularQueue.size());
		System.out.println("enqueue: " + circularQueue);
	}
	
	@Test
	public void testDequeue() {
		assertEquals((Integer) 1, (Integer)circularQueue.dequeue());
		assertTrue(!circularQueue.contains(1));
		assertEquals(3, circularQueue.size());
		System.out.println("dequeue: " + circularQueue);
	}
	
	@Test
	public void testSize() {
		assertEquals(4, circularQueue.size());
	}
	
	@Test
	public void testContains() {
		assertTrue(circularQueue.contains(1));
	}
	
	@Test
	public void testFront() {
		assertEquals((Integer) 1, (Integer)circularQueue.front());
	}

	@Test
	public void testRear() {
		assertEquals((Integer) 4, (Integer)circularQueue.rear());
	}

	@Test
	public void testToString() {
		System.out.println("toString: " + circularQueue);
	}

}
