package com.wajahat.hackerrank.solution;

import java.util.Scanner;

public class theHurdleRace {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int hurdles;
			int magic = 0, max = 0;
			for (int i = 0; i < n; i++) {
				hurdles = sc.nextInt();
				if (k < hurdles) {
					magic = (hurdles - k);
					if (magic > max) max = magic;
 				}
			}
			System.out.println(max);
		}
	}
}
