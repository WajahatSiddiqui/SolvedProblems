package com.wajahat.hackerrank.statistics.solution;

import java.util.Scanner;

public class StandardDeviation {
	
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			int N = sc.nextInt();
			sc.nextLine();
			String [] x = sc.nextLine().split(" ");
			double mu = 0.0;
			for (int i = 0; i < N; i++) {
				mu += Integer.parseInt(x[i]);
			}
			mu /= N;
			
			double sum = 0.0;
			for (int i = 0; i < N; i++) {
				sum += Math.pow((Double.parseDouble(x[i]) - mu), 2); 
			}
			
			System.out.printf("%.1f", Math.sqrt(sum/N));
		}
	}

}
