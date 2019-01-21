package com.wajahat.hackerrank.thirtydaysofcode.solution;

import java.util.Scanner;

public class ClassCancel {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int t = sc.nextInt();
			
			while (t > 0) {
				int n = sc.nextInt();
				int k = sc.nextInt();
				int goodStudents = 0;
				for (int i = 0; i < n; i++) {
					if (sc.nextInt() <= 0)
						goodStudents++;
				}
				System.out.println(goodStudents >= k ? "No" : "Yes");
				t--; 
			}
		} 
	}

}
