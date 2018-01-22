package com.wajahat.solution;

import java.util.Arrays;
import java.util.Scanner;

public class MinAbsDiffPairs {
	private static void minAbsDiffPairs(Integer [] arr, int n) {
		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < n; i++) {
			int diff = Math.abs((arr[i-1]-arr[i]));
			if (diff < min) {
				min = diff;
			}
		}
		for (int i = 1; i < n; i++) {
			int diff = Math.abs((arr[i-1]-arr[i]));
			if (diff == min) {
				System.out.printf("%d %d ", arr[i-1], arr[i]);
			}
		}
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Integer []arr = new Integer[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.valueOf(scanner.nextInt());
			}
			minAbsDiffPairs(arr, n);
		}
	}
}
