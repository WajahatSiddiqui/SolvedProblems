package com.wajahat.hackerrank.string.problems;

import java.util.Scanner;

public class SumitString {

	private static boolean isSumit(String s) {
		int N = s.length();
		char [] c = s.toCharArray();
		for (int i = 0; i < N; i++) {
			if (i != N-1 && Math.abs(c[i] - c[i+1]) != 1)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		while (T > 0) {
			String s = scanner.next();
			System.out.println(isSumit(s) ? "YES" : "NO");
			T--;
		}
		scanner.close();
	}

}
