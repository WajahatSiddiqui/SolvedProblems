package com.wajahat.solution;

import java.util.Scanner;

public class SherlockandArray {
	
	private static String solve(int[] A, int n, int sum) {
		String ans = "NO";
		if (n < 3) {
			return ans;
		}
		int left_window_sum = A[0];
		int right_window_sum = sum - left_window_sum;
		int ele;
		for (int i = 1; i < n-1; i++) {
			ele = A[i];
			right_window_sum -= ele;
			if (left_window_sum == right_window_sum) {
				ans = "YES";
				break;
			}
			left_window_sum += ele;
		}
		
		return ans;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		int n;
		while (T > 0) {
			n = scanner.nextInt();
			int [] A = new int[n];
			int sum = 0;
			for (int i = 0; i < n; i++) {
				A[i] = scanner.nextInt();
				sum += A[i];
			}
			System.out.println(solve(A, n, sum));
			T--;
		}
		scanner.close();

	}
}
