package com.wajahat.hackerrank.solution;

import java.util.Scanner;

public class MinMax {
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long[] arr = new long[5];
        long sum = 0;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for(int arr_i=0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextLong();
            sum += arr[arr_i];
            if (arr[arr_i] < min)
            	min = arr[arr_i];
            if (arr[arr_i] > max)
            	max = arr[arr_i];
            			
        }
        System.out.println((sum - max) + " " + (sum - min));
        in.close();
    }

}
