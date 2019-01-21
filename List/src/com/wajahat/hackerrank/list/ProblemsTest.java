package com.wajahat.hackerrank.list;

import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
	    head = problems.reverse(head);
	    System.out.println(list.toString(head));
		assertTrue(isEqual(Stream.of(10, 20, 30).collect(Collectors.toList()),
                list.getList(head)));
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
		Node<Integer> head1 = null, head2 = null;
		head1 = list.insertLast(null, 1);
		head1 = list.insertLast(head1, 2);
		head1 = list.insertLast(head1, 3);
		head1 = list.insertLast(head1, 4);
		head1 = list.insertLast(head1, 2);

        assertTrue(isEqual(Stream.of(1, 2, 3, 4).collect(Collectors.toList()),
                list.getList(problems.removeDups(head1))));

        head2 = list.insertLast(null,1);
        head2 = list.insertLast(head2,1);
        head2 = list.insertLast(head2,2);
        head2 = list.insertLast(head2,3);

        assertTrue(isEqual(Stream.of(1, 2, 3).collect(Collectors.toList()),
                list.getList(problems.removeDups(head2))));
	}

	@Test
    public void testGetLast() {
	    // 30->20->10->40->50->60->70->10->11
	    head = list.insertLast(head, 40);
        head = list.insertLast(head, 50);
        head = list.insertLast(head, 60);
        head = list.insertLast(head, 70);
        head = list.insertLast(head, 10);
        head = list.insertLast(head, 11);

        assertEquals(70, (int) problems.getLast(head, 3, list.size()).key);
        assertEquals(11, (int) problems.getLast(head, 0, list.size()).key);
        assertEquals(30, (int) problems.getLast(head, list.size(), list.size()).key);
    }

    @Test
	public void testPalidrome() {
		Node<Integer> head1 = null;
		head1 = list.insertLast(null, 0);
		head1 = list.insertLast(head1, 1);
		head1 = list.insertLast(head1, 3);
		head1 = list.insertLast(head1, 1);
		head1 = list.insertLast(head1, 0);

		assertTrue(problems.isPalidrome(head1));

		Node<Integer> head2 = null;
		head2 = list.insertLast(null, 0);
		head2 = list.insertLast(head2, 1);
		head2 = list.insertLast(head2, 5);
		head2 = list.insertLast(head2, 5);
		head2 = list.insertLast(head2, 1);
		head2 = list.insertLast(head2, 0);

		assertTrue(problems.isPalidrome(head2));
	}

	@Test
	public void testSum() {
		Node<Integer> head1 = null;
		head1 = list.insertLast(null, 1);
		head1 = list.insertLast(head1, 2);
		head1 = list.insertLast(head1, 3);

		assertNull(list.getList(problems.sum(null, null)));

		assertTrue(isEqual(Stream.of(1, 2, 3).collect(Collectors.toList()),
				list.getList(problems.sum(head1, null))));

		assertTrue(isEqual(Stream.of(1, 2, 3).collect(Collectors.toList()),
				list.getList(problems.sum(null, head1))));

		Node<Integer> head2 = null;
		head2 = list.insertLast(null, 4);
		head2 = list.insertLast(head2, 5);
		head2 = list.insertLast(head2, 6);

		assertTrue(isEqual(Stream.of(5, 7, 9).collect(Collectors.toList()),
				list.getList(problems.sum(head1, head2))));

		Node<Integer> head4 = null;
		head4 = list.insertLast(null, 1);
		head4 = list.insertLast(head4, 2);
		head4 = list.insertLast(head4, 3);


		Node<Integer> head3 = null;
		head3 = list.insertLast(null, 9);
		head3 = list.insertLast(head3, 9);
		head3 = list.insertLast(head3, 9);

		assertTrue(isEqual(Stream.of(1, 1, 2, 2).collect(Collectors.toList()),
				list.getList(problems.sum(head4, head3))));
	}

	@Test
	public void testDeleteNode() {
		assertFalse(problems.deleteNode(null));
		Node<Integer> node = head.next;
		assertTrue(problems.deleteNode(node));
		assertTrue(isEqual(Stream.of(30, 10).collect(Collectors.toList()),
				list.getList(head)));
	}

	@Test
	public void testPartition() {
		Node<Integer> head = null;
		head = list.insertLast(head, 3);
		head = list.insertLast(head, 5);
		head = list.insertLast(head, 8);
		head = list.insertLast(head, 5);
		head = list.insertLast(head, 10);
		head = list.insertLast(head, 2);
		head = list.insertLast(head, 1);

		System.out.println(list.toString(problems.partition(head, 5)));
		assertTrue(isEqual(Stream.of(3, 2, 1, 5, 8, 5, 10).collect(Collectors.toList()),
				list.getList(problems.partition(head, 5))));
	}

	@Test
	public void testGetLastWithoutCount() {
		// 30->20->10->40->50->60->70->10->11
		head = list.insertLast(head, 40);
		head = list.insertLast(head, 50);
		head = list.insertLast(head, 60);
		head = list.insertLast(head, 70);
		head = list.insertLast(head, 10);
		head = list.insertLast(head, 11);

		assertEquals(70, (int) problems.getLastWithoutCount(head, 3).key);
		assertEquals(11, (int) problems.getLastWithoutCount(head, 0).key);
		assertEquals(30, (int) problems.getLastWithoutCount(head, list.size()).key);
	}
}
