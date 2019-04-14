package com.wajahat.hackerrank.solution;

import java.util.*;

public class JimAndOrders {

    private static void findAndPrintOrders(int [] T, int [] D, int n) {
        // key = order number
        // value = fullfillment time
        SortedMap<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
        int completionTime;
        for (int i = 0; i < n; i++) {
            completionTime = T[i]+D[i];
            map.putIfAbsent(completionTime, new ArrayList<>());
            map.get(completionTime).add(i + 1);
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> values = entry.getValue();
            Collections.sort(values);
            for (Integer i : values) {
                System.out.printf("%d ", i);
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int [] T = new int [n];
            int [] D = new int [n];

            for (int i = 0; i < n; i++) {
                T[i] = scanner.nextInt();
                D[i] = scanner.nextInt();
            }

            findAndPrintOrders(T, D, n);
        }
    }
}
