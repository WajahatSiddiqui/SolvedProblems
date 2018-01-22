package com.wajahat.solution;

import java.util.Scanner;

public class PowerSum {
	
	private static int powerSum(int X, int N, int num) {
		if (Math.pow(num, N) < X) {
			return powerSum(X, N, num+1) + powerSum(Double.valueOf(X-Math.pow(num, N)).intValue(), N, num+1);
		} else if (Math.pow(num, N) == X) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int X = sc.nextInt();
			int N = sc.nextInt();
			System.out.println(powerSum(X, N, 1));
		}
	}

}
