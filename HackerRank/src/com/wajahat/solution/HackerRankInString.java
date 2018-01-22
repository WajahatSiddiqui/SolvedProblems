package com.wajahat.solution;

import java.util.Scanner;

public class HackerRankInString {
	
	private static boolean isFound(String s) {
		char [] c = s.toLowerCase().toCharArray();
		char [] p = {'h','a','c','k','e','r','r','a','n','k'};
		
		int N = c.length;
		int M = p.length;
		
		int i = 0, j = 0;
		while (i < N && j < M) {
			if (c[i] == p[j]) {
				i++;
				j++;
			} else {
				i++;
			}
			if (j == M) return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		while (T > 0) {
			String s = scanner.next();
			System.out.println(isFound(s) ? "YES" : "NO");
			T--;
		}
		scanner.close();
	}

}
