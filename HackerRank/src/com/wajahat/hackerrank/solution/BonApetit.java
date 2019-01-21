package com.wajahat.hackerrank.solution;

import java.util.Scanner;

public class BonApetit {
	static int bonAppetit(int n, int k, int b, int[] ar) {
		int bactual = 0;
		for (int i = 0; i < n; i++) {
			if (i != k) {
				bactual += ar[i];
			}
		}
		return b - (bactual/2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int b = in.nextInt();
        int result = bonAppetit(n, k, b, ar);
        System.out.println(result == 0 ? "Bon Appetit" : result);
        in.close();
    }
}
