package com.wajahat.hackerearth;

import java.util.Scanner;

/**
 * Class Remove friends based on popularity
 * Created by wajahat
 */
public class RemoveFriends {
    private static class Node {
        int data;
        Node next, prev;
        Node(int data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    private static Node insert(Node head, int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = node;
            node.prev = curr;
        }
        return head;
    }

    private static Node deleteMin(Node head) {
        if (head == null) return null;
        Node curr = head;
        while (curr.next != null) {
            if (curr.data < curr.next.data) {
                if (curr.prev != null) {
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                }
                if (curr == head) {
                    head = curr.next;
                }
                curr.next = null;
                curr.prev = null;
                break;
            }
            curr = curr.next;
        }
        return head;
    }

    private static void print(Node head) {
        if (head == null) return;
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    private static void delete(Node head) {
        if (head == null) return;
        Node curr = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = null;
            curr = next;
        }
        head = null;
    }

    public static void main(String args[]) {
        int T, N, K;
        Node head = null;
        try (Scanner sc = new Scanner(System.in)) {
            T = sc.nextInt();
            while (T-- > 0) {
                N = sc.nextInt();
                K = sc.nextInt();

                if (head != null) {
                    delete(head);
                    head = null;
                }

                for (int i = 0; i < N; i++) {
                    head = insert(head, sc.nextInt());
                }

                while (K-- > 0) {
                    head = deleteMin(head);
                }
                print(head);
            }
        }
    }
}
