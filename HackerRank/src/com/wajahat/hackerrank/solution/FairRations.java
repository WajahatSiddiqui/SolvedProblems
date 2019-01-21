package com.wajahat.hackerrank.solution;

import java.util.Scanner;

public class FairRations {
	
	private static int fairRations(int [] B, int N) {
		int count = 0;
		for (int i = 1; i < N; i++) {
			if (B[i-1] % 2 != 0 || B[i] % 2 != 0) {
				B[i-1]++;
				B[i]++;
				count+=2;
			}
			if (B[i-1] % 2 != 0 || B[i] % 2 != 0 && i == N-1) {
				return 0;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int N = sc.nextInt();
			int [] B = new int[N];
			for (int i = 0; i < N; i++) {
				B[i] = sc.nextInt();
			}
			System.out.println(fairRations(B, N));
		}
	}

}
