package com.wajahat.hackerrank.solution;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MinAbsDiff {

    private static int minAbsDiff(Integer [] arr, int n) {
        Arrays.sort(arr, Collections.reverseOrder());
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int diff = Math.abs((arr[i-1]-arr[i]));
            if (diff < min) {
                min = diff;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            Integer []arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.valueOf(scanner.nextInt());
            }
            System.out.println(minAbsDiff(arr, n));
        }
    }

}
