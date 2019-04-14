package com.wajahat.hackerrank.datastructure.arrays.solution;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class ArrayManipulation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        HashMap<Long, Long> arr = new LinkedHashMap<Long, Long>();
        for (long i = 0; i < m; i++) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            long k = scanner.nextLong();
            if (arr.containsKey(a)) {
                arr.put(a, arr.get(a) + k);
            } else {
                arr.put(a, k);
            }

            if (b+1 <= n) {
                if (arr.containsKey(b+1)) {
                    arr.put(b+1, arr.get(b+1) - k);
                } else {
                    arr.put(b+1, -k);
                }
            }
        }
        int x = 0, max = 0;
        for (long i = 1; i <= n; i++) {
            if (arr.containsKey(i)) {
                x += arr.get(i);
                if (x > max) max = x;
            }
        }
        System.out.println(max);
        scanner.close();
    }
}
