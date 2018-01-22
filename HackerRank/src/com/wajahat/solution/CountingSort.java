package com.wajahat.solution;


public class CountingSort {
	
	private static void sort(int []arr) {
		int []count = new int[10];
		
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}
		
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i-1];
		}
		
		int [] output = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			output[count[arr[i]]-1] = arr[i];
			count[arr[i]]--;
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = output[i];
		}
	}
	
	public static void main(String[] args) {
		int [] arr = {4, 2, 2, 1, 4, 2, 3, 1, 5, 6};
		sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%d ", arr[i]);
		}
	}
}
