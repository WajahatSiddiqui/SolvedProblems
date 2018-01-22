package com.wajahat.statistics.solution;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class MeanMedianMode {
	
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int N = scanner.nextInt();
			double sum = 0.0;
			SortedMap<Integer, Integer> map = new TreeMap<>();
			Integer[] keys = new Integer[N];
			for (int i = 0; i < N; i++) {
				keys[i] = scanner.nextInt();
				if (map.containsKey(keys[i])) {
					map.put(keys[i], map.get(keys[i]) + 1);
				} else {
					map.put(keys[i], 1);
				}
				sum += keys[i];
			}
			System.out.printf("%.1f\n", sum/N);
	
			Arrays.sort(keys);
			double median = 0.0;
			if (N % 2 == 0) {
				median = (keys[N/2 - 1] + keys[N/2])/2.0;
			} else {
				median = keys[N/2];
			}
			System.out.printf("%.1f\n", median);
			
			int mode = 0, max_value = 0;
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				if (entry.getValue() > max_value) {
					mode = entry.getKey();
					max_value = entry.getValue();
				} else if (entry.getValue() == max_value && entry.getKey() < mode) {
					mode = entry.getKey();
				}
			}
			
			if (max_value == 1) {
				mode = map.firstKey();
			}
			
			System.out.println(mode);
		}
	}

}
