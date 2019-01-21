package com.wajahat.hackerrank.statistics.solution;

import java.util.Scanner;

public class WeightedMean {
	
	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)) {
			int N = scanner.nextInt();
			scanner.nextLine();
			int prod = 0, weight_sum = 0;
			String []x = scanner.nextLine().split(" ");
			String []w = scanner.nextLine().split(" ");
			for (int i = 0; i < N; i++) {
				prod += (Integer.parseInt(x[i]) * Integer.parseInt(w[i]));
				weight_sum += Integer.parseInt(w[i]);
			}
			System.out.printf("%.1f", (double)(prod)/weight_sum);
		}
	}

}
