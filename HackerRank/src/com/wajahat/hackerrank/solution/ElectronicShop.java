package com.wajahat.hackerrank.solution;

import java.util.Scanner;

public class ElectronicShop {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int s = sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int [] keyboard = new int[n];
			int [] usb = new int[m];
			
			for (int i = 0; i < n; i++) {
				keyboard[i] = sc.nextInt();
			}
			
			for (int j = 0; j < m; j++) {
				usb[j] = sc.nextInt();
			}
			
			int max = -1, sum = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					sum = keyboard[i] + usb[j]; 
					if (sum <= s && sum > max) {
						max = sum;
					}
				}
			}
			System.out.println(max);	
		}

	}
}
