package com.wajahat.thirtydaysofcode.solution;

import java.util.Scanner;

public class MaxHourGlassSum {
	
	private static int getHourGlassSum(int [][]A, int n1, int n2) {
		int []d1 = {-1, -1, -1, 0, 1, 1, 1};
		int []d2 = {-1, 0, 1, 0, -1, 0, 1};
		int sum = 0;
		for (int i = 0; i < d1.length; i++) {
			sum += A[n1+d1[i]][n2+d2[i]];
		}
		return sum;
	}
	
	private static int getMaxHourGlassSum(int [][]A) {
		int max = Integer.MIN_VALUE, sum = 0;
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				sum = getHourGlassSum(A, i, j);
				if (sum > max) max = sum;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			int [][] A = new int[6][6];
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 6; j++) {
					A[i][j] = sc.nextInt();
				}
			}
			
			System.out.println(getMaxHourGlassSum(A));
		}
	}

}
