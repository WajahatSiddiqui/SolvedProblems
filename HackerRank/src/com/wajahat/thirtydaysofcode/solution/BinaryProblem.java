package com.wajahat.thirtydaysofcode.solution;

import java.util.Scanner;

public class BinaryProblem {
	
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int count = 0;
			while (n > 0) {
				n &= (n >> 1);
				count++;
			}
			System.out.println(count);
		}
	}

}
