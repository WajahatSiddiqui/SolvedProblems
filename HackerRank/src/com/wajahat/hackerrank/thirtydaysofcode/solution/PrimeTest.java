package com.wajahat.hackerrank.thirtydaysofcode.solution;

import java.util.Scanner;

public class PrimeTest {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			long T = sc.nextLong();
			while (T > 0) {
				boolean isPrime = true;
				long n = sc.nextLong();
				if (n == 1) {
					isPrime = false;
				} else if (n == 2) {
					isPrime = true;
				} else {
					long sq = (long) Math.sqrt((double) n);
					for (long i = 2; i <= sq; i++) {
						if (n % i == 0) {
							isPrime = false;
						}
					}
				}
				System.out.println(isPrime ? "Prime" : "Not prime");
				T--;
			}
		}
	}
}
