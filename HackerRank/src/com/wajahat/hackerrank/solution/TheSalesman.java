package com.wajahat.hackerrank.solution;

import java.util.Arrays;
import java.util.Scanner;

public class TheSalesman {
	private static int findMinTime(int [] locations, int n) {
		Arrays.sort(locations);
		int loc = locations[0];
		int minTime = 0;
		for (int i = 1; i < n; i++) {
			minTime += locations[i] - loc;
			loc = locations[i];
		}
		return minTime;
	}
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			int street = sc.nextInt();
			while (street > 0) {
				int n = sc.nextInt();
				int [] locations = new int[n];
				for (int i = 0; i < n; i++) {
					locations[i] = sc.nextInt();
				}
				System.out.println(findMinTime(locations, n));
				street--;
			}
		}		
	}
}
