package com.wajahat.solution;

import java.util.Scanner;
import java.util.Stack;

public class StackUsingQueues {
	
	private static class MyQueue<Key> {
		Stack<Key> s1 = new Stack<Key>();
		Stack<Key> s2 = new Stack<Key>();
		
		public void enqueue(Key k) {
			if (s1.isEmpty() && s2.isEmpty()) {
				s1.push(k);
			} else if (s1.isEmpty()){
				s2.push(k);
			} else {
				s1.push(k);
			}
		}
		
		public Key dequeue() {
			Key front;
			if (s2.isEmpty()) {
				while (!s1.isEmpty()) {
					s2.push(s1.pop());
				}
				front = s2.pop();
			} else {
				while (!s2.isEmpty()) {
					s1.push(s2.pop());
				}
				front = s1.pop();
			}
			return front;
		}
		
		public Key peek() {
			return s1.isEmpty() ? s2.lastElement() : s1.lastElement();
		}
	}
	
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int q = sc.nextInt();
			MyQueue<Integer> queue = new MyQueue<Integer>();
			while (q >= 0) {
				int command = sc.nextInt();
				switch (command) {
				case 1:
					int item = sc.nextInt();
					queue.enqueue(item);
					break;
				case 2:
					queue.dequeue();
					break;
				case 3:
					System.out.println(queue.peek());
					break;
				default:
					break;
				}
				q--;
			}
		}
	}

}
