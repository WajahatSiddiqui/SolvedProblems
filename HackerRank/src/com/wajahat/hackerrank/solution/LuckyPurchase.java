package com.wajahat.hackerrank.solution;

import java.util.Scanner;
import java.util.TreeMap;

public class LuckyPurchase {
	
	private static boolean check(int price) {
		if (price <= 0) return false;
		String number = String.valueOf(price);
		char [] digits = number.toCharArray();
		
		int four = 0;
		int seven = 0;
		for (char c : digits) {
			if (!(c == '4' || c == '7')) return false;
			if (c == '4') four++;
			if (c == '7') seven++;
		}
		return four == seven;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		TreeMap<Integer, String> laptops = new TreeMap<>();
		String name;
		int price;
		for (int i = 0; i < n; i++) {
			name = scanner.next();
			price = scanner.nextInt();
			if (check(price)) {
				laptops.put(price, name);
			}
		}
		
		if (laptops.isEmpty()) {
			System.out.println("-1");
		} else {
			System.out.println(laptops.firstEntry().getValue());
		}
		
		scanner.close();
	}

}
