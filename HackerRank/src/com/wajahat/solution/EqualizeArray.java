package com.wajahat.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EqualizeArray {
	
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			Map<Integer, Integer> map = new HashMap<>(n);
			int i, max = 1, count = 0;
			while (count < n) {
				i = sc.nextInt();
				if (!map.containsKey(i)) {
					map.put(i, 1);
				} else {
					map.put(i, map.get(i) + 1);
					if (map.get(i) > max) {
						max = map.get(i);
					}
				}
				count++;
			}
			System.out.println(n - max);
		}
	}

}
