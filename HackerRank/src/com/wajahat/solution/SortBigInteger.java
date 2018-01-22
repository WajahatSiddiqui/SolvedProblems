package com.wajahat.solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SortBigInteger {
	
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			String []str = new String[n];
			for (int i = 0; i < n; i++) {
				str[i] = sc.next();
			}
			Arrays.sort(str, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					int n=o1.length();
				    int m=o2.length();
					if (n == m) {
						return o1.compareTo(o2);
					} else {
						return n - m;
					}
				}
			});
			
			for (int i = 0; i < n; i++) {
				System.out.println(str[i]);
			}
		}
	}

}
