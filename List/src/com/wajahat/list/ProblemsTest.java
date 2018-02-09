package com.wajahat.list;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProblemsTest {
	
	private Problems<Integer> problems;
	private List<Integer> list;
	private Node<Integer> head;
	
	public ProblemsTest() {
		problems = new Problems<>();
		list = new List<>();
		head = list.insertFirst(head, 10);
		head = list.insertFirst(head, 20);
		head = list.insertFirst(head, 30);
	}

	@Test
	public void testReverse() {
		System.out.println(list.toString(head));
		assertEquals((Integer) 30, list.first(head));
		assertEquals((Integer) 10, list.last(head));
		
		head = problems.reverse(head);
		
		System.out.println(list.toString(head));
		
		assertEquals((Integer) 10, list.first(head));
		assertEquals((Integer) 30, list.last(head));
	}
	
	@Test
	public void testIsCircular() {
		assertTrue(!problems.isCircular(head));
		
		Node<Integer> head1 = null;
		head1 = list.insertLast(head1, 1);
		head1.next = head1;
		
		assertTrue(problems.isCircular(head1));
		
		Node<Integer> head3 = null;
		
		head3 = list.insertLast(head3, 1);
		head3 = list.insertLast(head3, 2);
		head3 = list.insertLast(head3, 3);
		
		// 1->2->3
		System.out.println(list.toString(head3));
		assertTrue(!problems.isCircular(head3));

		// 1->2->3-
		//    |___|
		head3.next.next.next = head3.next;
		assertTrue(problems.isCircular(head3));
	}

}
