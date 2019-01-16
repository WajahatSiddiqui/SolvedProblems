package com.wajahat.string.problems;

import java.util.Arrays;

public class Pangrams {
	
	private static boolean isPangram(String str) {
		char [] c = str.toLowerCase().toCharArray();
		Arrays.sort(c);
		char [] uniqueChars = new char[256];
		
		for (char ch : c) {
			uniqueChars[ch] = 1;
		}
		
		for (int i = 97; i <= 122; i++) {
			if (uniqueChars[i] == 0) return false;
		}
			
		
		return true;
	}
	
	public static void main(String[] args) {
		String str = "The quick brown fox jumps over the lazy dog";
		System.out.println(isPangram(str) ? "YES" : "NO");
	}

}
