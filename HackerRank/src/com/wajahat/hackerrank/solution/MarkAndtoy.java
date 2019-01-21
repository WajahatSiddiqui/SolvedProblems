package com.wajahat.hackerrank.solution;

import java.util.Arrays;
import java.util.Scanner;

public class MarkAndtoy {
	
	private static int findMaxtoys(int [] prices, int N, int K) {
		Arrays.sort(prices);
		int l = 0, sum = 0;
		while (l < N) {
			sum += prices[l];
			if (sum <= K) {
				l++;
			} else
				break;
		}
		return l;
	}
	
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int N = scanner.nextInt();
			int K = scanner.nextInt();
			int [] prices = new int[N];
			for (int i = 0; i < N; i++) {
				prices[i] = scanner.nextInt();
			}
			System.out.println(findMaxtoys(prices, N, K));
		} 
	}

}
