package com.wajahat.solution;

import java.util.Arrays;
import java.util.Scanner;

public class FindingMedian {
	
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int [] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			int median = 0;
			if (n % 2 == 0) {
				median = (arr[n/2 - 1] + arr[n/2]) /2;
			} else {
				median = arr[n/2];
			}
			System.out.println(median);
		}
	}

}
