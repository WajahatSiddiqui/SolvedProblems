package com.wajahat.hackerrank.solution;

public class LongestIncreasingSubsequence {
	private static void findLIS(int [] A) {
		int []T = new int[A.length];
		int []solution = new int[A.length];
		
		for (int i = 0; i < A.length; i++) {
			T[i] = 1;
			solution[i] = i;
		}
		
		for (int i = 1; i < A.length; i++) {
			for (int j = 0; j < i; j++) {
				if (A[j] < A[i] && T[j] + 1 > T[i]) {
					T[i] = T[j] + 1;
					solution[i] = j;
				}
			}
		}
		
		int maxIndex = 0;
		for (int i = 1; i < A.length; i++) {
			if (T[i] > T[maxIndex]) {
				maxIndex = i;
			}
		}
		
		System.out.println("LIS Length: " + T[maxIndex]);
		int t = maxIndex;
		int newT = maxIndex;
		do {
			t = newT;
			System.out.printf("%d ", A[t]);
			newT = solution[t];
		} while (t != newT);
		
	}
	public static void main(String[] args) {
		//int [] A = {3, 4, -1, 0, 6, 2, 3};
		int [] A = {3, 4, -1, 2, 6, 3, 3, 4, 5};
		findLIS(A);
	}

}
