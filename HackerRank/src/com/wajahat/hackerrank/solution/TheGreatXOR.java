package com.wajahat.hackerrank.solution;

import java.util.Scanner;

public class TheGreatXOR {
	private static long findA(long x) {
		long bitpos = 0, result = 0;
		while (x != 0L) {
			if ((x&1) == 0) {
				result += (1L << bitpos);
			}
			bitpos++;
			x >>= 1;
		}
		return result;
	}
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int q = scanner.nextInt();
			while (q > 0) {
				long x = scanner.nextLong();
				System.out.println(findA(x));
				q--;
			}
		}
	}

}
