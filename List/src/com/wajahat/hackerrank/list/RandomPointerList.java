package com.wajahat.hackerrank.list;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Class List With Random Arbitrary pointer
 * Created by wajahat
 */
public class RandomPointerList {

    private static class Node {
        int data;
        Node next;
        Node random;

        public Node(int data, Node random) {
            this.data = data;
            next = null;
            this.random = random;
        }

    }

    Node insert(Node head, int data, Node random) {
        Node node = new Node(data, random);
        if (head == null) {
            head = node;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = node;
        }
        return head;
    }

    Node clone(Node head) {
        if (head == null) return null;
        Node clone = null;
        Node c1 = head;
        while (c1 != null) {
            clone = insert(clone, c1.data, c1);
            c1 = c1.next;
        }
        Node prev;
        c1 = head;
        Node c2 = clone;
        while (c1 != null && c2 != null) {
            prev = c1;
            c1 = c1.next;
            prev.next = c2;
            c2 = c2.next;
        }

        c2 = clone;
        while (c2 != null) {
            c2.random = c2.random.random.next;
            c2 = c2.next;
        }

        return clone;
    }

    @Test
    public void testClone() {
        Node head = null;
        head = insert(head, 1, null);
        head = insert(head, 2, null);
        head = insert(head, 3, null);
        head = insert(head, 4, null);
        head = insert(head, 5, null);

        head.random = head.next.next;
        head.next.random = head.next.next.next;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next;
        head.next.next.next.next.random = head;

        Node clone = clone(head);

        assertEquals(clone.random, clone.next.next);
        assertEquals(clone.next.random, clone.next.next.next);
        assertEquals(clone.next.next.random, clone.next.next.next.next);
        assertEquals(clone.next.next.next.random,  clone.next);
        assertEquals(clone.next.next.next.next.random,  clone);
    }
}
