package com.wajahat.hackerrank.solution;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KthLargest {
	
	private static int findKthLargest(int [] num, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer n1, Integer n2) {
				return n2.compareTo(n1);
			}
		});
		for (int n : num) {
			queue.add(n);
		}
		Object [] arr = queue.toArray();
		return (int) arr[k-1];
	}
	
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int N = scanner.nextInt();
			int [] num = new int[N];
			for (int i = 0; i < N; i++) {
				num[i] = scanner.nextInt();
			}
			int K = scanner.nextInt();
			System.out.println(findKthLargest(num, K));
		}
	}

}
