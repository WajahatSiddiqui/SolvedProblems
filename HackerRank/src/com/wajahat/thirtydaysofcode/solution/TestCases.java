package com.wajahat.thirtydaysofcode.solution;

import java.util.Random;

public class TestCases {
	
    /*private static int randomInt(int min, int max) {
        return new Random().ints(min, (max + 1)).limit(1).findFirst().getAsInt();
    }*/
	
	private static void print(int []A) {
		for (int i = 0; i < A.length; i++) {
			System.out.printf("%d ", A[i]);
		}
	}
	
	public static void main(String[] args) {
		int T = 5;
		System.out.println(T);
		int n, k;
		n = 3; k = 3;
		System.out.printf("%d %d \n", n, k);
		int [] a = {-1, 0, 1};
		print(a);
		n = 4; k = 2;
		System.out.printf("\n%d %d \n", n, k);
		int [] b = {0, -1, 2, 1};
		print(b);
		n = 5; k = 4;
		System.out.printf("\n%d %d \n", n, k);
		int [] c = {-2, -1, 0, 1, 2};
		print(c);
		n = 6; k = 4;
		System.out.printf("\n%d %d \n", n, k);
		int [] d = {-3, -2, -1, 0, 1, 2};
		print(d);	
		n = 7; k = 6;
		System.out.printf("\n%d %d \n", n, k);
		int [] e = {-3, -2, -1, 0, 1, 2, 3, 4};
		print(e);			
	}

}
