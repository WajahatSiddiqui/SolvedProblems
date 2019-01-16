package com.wajahat.list;

import java.util.Random;

/**
 * Create a linked list with Random Pointer
 * Created by Wajahat
 **/
public class RandomList {
    private static class Node {
        int data;
        Node next;
        Node random;
        public Node(int data) {
            this.data = data;
            next = null;
            random = null;
        }
    }

    Node insert(Node head, int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        }

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = node;
        return head;
    }

    Node clone(Node head) {
        if (head == null) return null;

        Node curr = head;
        Node clone = null;
        while (curr != null) {
            clone = insert(clone, curr.data);
            clone.random = curr;
            curr = curr.next;
        }
        curr = head;
        Node curr2 = clone;
        while (curr2 != null && curr != null) {
            curr = curr2;
            curr = curr.next;
            curr2 = curr2.next;
        }
        return clone;
    }

    public static void main(String args[]) {
        RandomList randomList = new RandomList();
        Node head = null;
        head = randomList.insert(head, 1);
        head = randomList.insert(head, 2);
        head = randomList.insert(head, 3);
        head = randomList.insert(head, 4);
        head = randomList.insert(head, 5);

        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head.next.next.next;

        Node clone = clone(head);
    }
}
