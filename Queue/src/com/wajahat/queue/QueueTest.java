package com.wajahat.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {
    private Queue<Integer> queue = new Queue<>();

    public QueueTest() {
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
    }

    @Test
    public void testEnqueue() {
        queue.enqueue(40);
        assertEquals(queue.size(), 4);
        assertTrue(queue.contains(40));
        assertEquals((Integer) 10, queue.front());
        assertEquals((Integer) 40, queue.rear());
        System.out.println("testEnqueue : " + queue);
    }

    @Test
    public void testDequeue() {
        assertEquals((Integer) 10, queue.dequeue());
        assertFalse(queue.contains(10));
        assertEquals(queue.size(), 2);
        System.out.println("testDequeue : " + queue);
    }

    @Test
    public void testSize() {
        assertEquals(queue.size(), 3);
    }

    @Test
    public void testFront() {
        assertEquals(queue.front(), (Integer) 10);
    }

    @Test
    public void testRear() {
        assertEquals(queue.rear(), (Integer) 30);
    }


    @Test
    public void testIsEmpty() {
        assertEquals(queue.dequeue(), (Integer) 10);
        assertEquals(queue.dequeue(), (Integer) 20);
        assertEquals(queue.dequeue(), (Integer) 30);
        assertTrue(queue.isEmpty());
        System.out.println("testIsEmpty : " + queue);
    }

    @Test
    public void testContains() {
        assertTrue(queue.contains(30));
    }

    @Test
    public void testToString() {
        System.out.println("testToString : " + queue);
    }

}
