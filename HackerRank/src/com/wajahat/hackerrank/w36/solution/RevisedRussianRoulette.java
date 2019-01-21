package com.wajahat.hackerrank.w36.solution;

import java.util.Scanner;

public class RevisedRussianRoulette {
	static void revisedRussianRoulette(String str, int n) {
		
		
		int min = 0, max = 0;
		int len = str.length();

		for (int i = 0; i < len; i+=2) {
			if (str.charAt(i) == '1') { // lock
				min++;
				max++;
				if (str.charAt(i+2) == '1') {
					max++;
				}
			}
		}
		System.out.printf("%d %d\n", min, max);
	}

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			in.nextLine();
			String str = in.nextLine();
			revisedRussianRoulette(str, n);
		}

	}
}
