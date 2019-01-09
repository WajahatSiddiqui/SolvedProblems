package com.wajahat.list;

import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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

    private boolean isEqual(java.util.List<Integer> list1, java.util.List<Integer> list2) {
        if (list1.size() != list2.size()) return false;

        int len = list1.size();
        for (int i = 0; i < len; i++) {
            if (!list1.get(i).equals(list2.get(i))) return false;
        }
        return true;
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
		head1 = list.insertLast(null, 1);
		head1.next = head1;
		
		assertTrue(problems.isCircular(head1));
		
		Node<Integer> head3 = null;
		
		head3 = list.insertLast(null, 1);
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

	@Test
	public void testIntersect() {
		Node<Integer> head1 = null, head2 = null;
		head1 = list.insertLast(null, 1);
		head1 = list.insertLast(head1, 2);
		head1 = list.insertLast(head1, 3);
		head1 = list.insertLast(head1, 4);

		head2 = list.insertLast(null, 10);
		head2 = list.insertLast(head2, 20);
		head2 = list.insertLast(head2, 30);
		head2.next.next.next = head1.next.next;

		Integer key = problems.intersect(head1, head2).key;
		assertNotNull(key);
		assertEquals(3, key.intValue());
	}

	@Test
	public void testRemoveDups() {
		Node<Integer> head1 = null;
		head1 = list.insertLast(null, 1);
		head1 = list.insertLast(head1, 2);
		head1 = list.insertLast(head1, 3);
		head1 = list.insertLast(head1, 4);
		head1 = list.insertLast(head1, 2);

		head1 = problems.removeDups(head1);
		System.out.println(list.toString(head1));
        assertTrue(isEqual(Stream.of(1, 2, 3, 4).collect(Collectors.toList()), list.getList(head1)));
	}

}
