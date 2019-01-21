package com.wajahat.hackerrank.solution;

import java.util.Arrays;
import java.util.Scanner;

// Find min units which all toys can be bought
public class PriyankaAndtoys {
	
	private static int findMinUnits(int [] weights, int N) {
		Arrays.sort(weights);
		int units = 0;
		for (int i = 0; i < N; i++) {
			if (weights[i] != -1) {
				int start = weights[i];
				int end = weights[i]+4;
				for (int j = i; j < N; j++) {
					if (weights[j] >= start && weights[j] <= end) {
						weights[j] = -1;
					}
				}
				// purchased one unit
				units++;
			}
		}
		return units;
	}
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int N = scanner.nextInt();
			int [] weights = new int[N];
			for (int i = 0; i < N; i++) {
				weights[i] = scanner.nextInt();
			}
			System.out.println(findMinUnits(weights, N));
	
		}
	}

}
