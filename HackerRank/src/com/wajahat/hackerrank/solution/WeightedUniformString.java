package com.wajahat.hackerrank.solution;

import java.util.HashSet;
import java.util.Scanner;

public class WeightedUniformString {
	private static int getCharCode(int ch) {
		return (ch - 'a') + 1;
	}
	
	private static HashSet<Integer> generateUniformCode(String str) {
		int N = str.length();
		int charCode = getCharCode(str.charAt(0));
		int []W = new int[N]; // calculate weight
		HashSet<Integer> hashSet = new HashSet<Integer>(N);
		W[0] = charCode;
		hashSet.add(W[0]);
		for (int i = 1; i < N; i++) {
			charCode = getCharCode(str.charAt(i));
			if (str.charAt(i-1) == str.charAt(i)) {
				W[i] = W[i-1] + charCode;
			} else {
				W[i] = charCode;
			}
			hashSet.add(W[i]);
		}
		return hashSet;
	}
	
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			String str = sc.next();
			HashSet<Integer> codes = generateUniformCode(str);
			int q = sc.nextInt();
			int wt;
			for (int i = 0; i < q; i++) {
				wt = sc.nextInt();
				System.out.println(codes.contains(wt) ? "Yes" : "No");
			}
		}
	}
}
