package com.wajahat.hackerrank.solution;

import java.util.Scanner;

public class CatalanNumbers {
	
	private static int catalan(int N) {
		if (N == 0 || N == 1) {
			return 1;
		}
		int [] T = new int[N+1];
		T[0] = T[1] = 1;
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < i; j++) {
				T[i] += T[j] * T[i-j-1];
			}
		}
		return T[N];
	}
	
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			int N = sc.nextInt();
			System.out.println(catalan(N));
		}
	}

}
