package com.wajahat.hackerrank.thirtydaysofcode.solution;

import java.util.Scanner;

public class LibraryFine {
	
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int aD = sc.nextInt();
			int aM = sc.nextInt();
			int aY = sc.nextInt();
			
			int eD = sc.nextInt();
			int eM = sc.nextInt();
			int eY = sc.nextInt();
			
			int fine = 0;
			int daysLate = aD - eD;
			int monthsLate = aM - eM;
			int yearsLate = aY - eY;


			if (yearsLate < 0) {
				fine = 0;
			} else if (yearsLate > 0) {
				fine = 10000;
			} else if (monthsLate > 0) {
				fine = 500 * monthsLate;
			}  else if (daysLate > 0) {
				fine = 15 * daysLate;
			} else {
				fine = 0;
			}
			 
			System.out.println(fine);
		}
	}

}
