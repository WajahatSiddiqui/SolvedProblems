package com.wajahat.list;

import java.util.HashSet;
import java.util.Set;

public class  Problems<Key> {
	
	public Node<Key> reverse(Node<Key> head) {
		if (head == null) {
			return null;
		}
		Node<Key> curr = head, prev = null, next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
		return head;
	}
	
	public boolean isCircular(Node<Key> head) {
		if (head == null) return false;
		
		Node<Key> slow = head, fast = head;
		
		while (slow != null && fast != null && fast.next != null ) {
			slow = slow.next;
			fast = fast.next.next;
			
			if (slow.key.equals(fast.key)) {
				return true;
			}
		}
		return false;		
	}

	public Node<Key> intersect(Node<Key> head1, Node<Key> head2) {
		if (head1 == null || head2 == null) return null;
		Node<Key> curr1 = head1;
		Node<Key> curr2 = head2;
		Set<Node<Key>> visited = new HashSet<>();
		while (curr1 != null) {
			visited.add(curr1);
			curr1 = curr1.next;
		}

		while (curr2 != null) {
			if (visited.contains(curr2)) {
				return curr2;
			}
			curr2 = curr2.next;
		}
		return null;
	}

	public Node<Key> removeDups(Node<Key> head) {
		if (head == null) return null;

		Set<Key> visited = new HashSet<>();
		Node<Key> curr = head;
		Node<Key> prev = null;
		while (curr != null) {
			prev = curr;
			if (visited.contains(curr.key)) {
				prev.next = curr.next;
				curr = curr.next;
				continue;
			}
			visited.add(curr.key);
			curr = curr.next;
		}
		return head;
	}
}
