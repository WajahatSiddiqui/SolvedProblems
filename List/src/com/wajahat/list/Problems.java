package com.wajahat.list;

public class Problems<Key> {
	
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
	
}
