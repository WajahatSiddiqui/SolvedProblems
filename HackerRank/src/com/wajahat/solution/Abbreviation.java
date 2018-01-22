package com.wajahat.solution;

import java.util.Scanner;

public class Abbreviation {
	
	private static boolean abbreviation(String a, String b) {
		return a.toLowerCase().contains(b.toLowerCase());
	}
	
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int q = sc.nextInt();
			while (q > 0) {
				String a = sc.next();
				String b = sc.next();
				System.out.println(abbreviation(a, b) ? "YES" : "NO");
				q--;
			}
		}
		
	}

}
