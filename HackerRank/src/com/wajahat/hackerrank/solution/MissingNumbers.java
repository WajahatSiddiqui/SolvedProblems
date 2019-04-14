package com.wajahat.hackerrank.solution;

import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class MissingNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key, value;
        int n = scanner.nextInt();
        SortedMap<Integer, Integer> mapA = new TreeMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            key = scanner.nextInt();
            if (mapA.containsKey(key)) {
                value = mapA.get(key) + 1;
            } else {
                value = 1;
            }
            mapA.put(key, value);
        }

        int m = scanner.nextInt();
        SortedMap<Integer, Integer> mapB = new TreeMap<Integer, Integer>();
        for (int i = 0; i < m; i++) {
            key = scanner.nextInt();
            if (mapB.containsKey(key)) {
                value = mapB.get(key) + 1;
            } else {
                value = 1;
            }
            mapB.put(key, value);
        }

        for (Integer s : mapA.keySet()) {
            if (!mapB.containsKey(s)
                    || !mapA.get(s).equals(mapB.get(s))) {
                System.out.print(s + " ");
            }
        }

        mapA.clear();
        mapB.clear();
        scanner.close();

    }
}
