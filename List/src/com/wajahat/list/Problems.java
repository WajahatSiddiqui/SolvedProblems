package com.wajahat.list;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

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

    /**
     * Remove dups
     * @param head
     */
	public Node<Key> removeDups(Node<Key> head) {
		if (head == null) return null;

		Set<Key> visited = new HashSet<>();
		Node<Key> curr = head;
		visited.add(curr.key);
		while (curr != null && curr.next != null) {
			if (visited.contains(curr.next.key)) {
			    curr.next = curr.next.next;
			} else {
                visited.add(curr.next.key);
            }
			curr = curr.next;
		}
		return head;
	}

    /**
     * Returns Kth from last
     * @param head
     * @param K
     */
	public Node<Key> getLast(Node<Key> head, int K, int N) {
	    if (head == null || K > N) return null;
        int idx = N-K;
        int count = 0;

        Node<Key> curr = head;
        while (curr.next != null && count < idx) {
            curr = curr.next;
            count++;
        }
        return curr;
    }

    public Node<Key> getLastWithoutCount(Node<Key> head, int K, int N) {
		return null;
	}

	/**
	 * Get Kth from last without using count
	 */
	public Node<Key> getLastWithoutCount(Node<Key> head, int K) {
		if (head == null) return null;
		Node<Key> c1 = head, c2 = head;
		int count = 0;
		while (count < K) {
			c2 = c2.next;
			count++;
		}

		while (c1.next != null && c2 != null) {
			c1 = c1.next;
			c2 = c2.next;
		}
		return c1;
	}

	/**
	 * Delete a given node, except last node
	 * @param node
	 * @return
	 */
	public boolean deleteNode(Node<Key> node) {
		if (node == null || node.next == null) return false;
		Node<Key> next = node.next;
		node.key = next.key;
		node.next = next.next;
		return true;
	}

	public boolean isPalidrome(Node <Key> head) {
		if (head == null) return false;
		Stack<Key> s = new Stack<>();

		Node<Key> slow = head;
		Node<Key> fast = head;

		while (fast != null && fast.next != null) {
			s.push(slow.key);
			slow = slow.next;
			fast = fast.next.next;
		}

		if (fast != null) {
			slow = slow.next;
		}

		while (!s.empty() && slow != null) {
			if (!s.pop().equals(slow.key)) return false;
			slow = slow.next;
		}
		return true;
	}

	private Key getKey(Integer i) {
		return (Key) i;
	}

	/**
	 * finds the sum of equal size list
	 * @param head1
	 * @param head2
	 * @return
	 */
	public Node<Key> sum(Node<Key> head1, Node<Key> head2) {
		if (head1 == null && head2 == null) return null;
		if (head1 == null) return head2;
		if (head2 == null) return head1;


		int sum = 0, carry = 0;
		Node<Key> revHead1 = reverse(head1);
		Node<Key> revHead2 = reverse(head2);
		Node<Key> result = null;
		List<Key> list = new List<>();
		while (revHead1 != null || revHead2 != null) {
			sum = (Integer) revHead1.key + (Integer) revHead2.key + carry;
			carry = sum / 10;
			sum = sum % 10;
			result = list.insertFirst(result, getKey(sum));
			revHead1 = revHead1.next;
			revHead2 = revHead2.next;
		}
		if (carry > 0) {
			result = list.insertFirst(result, getKey(carry));
		}
		return result;
	}

	public Node<Key> merge(Node<Key> head1, Node<Key> head2) {
		if (head1 == null && head2 == null) return null;
		if (head1 == null) return head2;
		if (head2 == null) return head1;

		Node<Key> curr1 = head1;
		while (curr1.next != null) {
			curr1 = curr1.next;
		}
		curr1.next = head2;
		return head1;
	}

	public Node<Key> partition(Node<Key> head, int X) {
		if (head == null) return null;

		Node<Key> head1 = null, head2 = null;
		Node<Key> curr = head;
		List<Key> list = new List<>();
		while (curr  != null) {
			if ((Integer) curr.key < X) {
				head1 = list.insertLast(head1, curr.key);
			} else {
				head2 = list.insertLast(head2, curr.key);
			}
			curr = curr.next;
		}
		return merge(head1, head2);
	}
}
