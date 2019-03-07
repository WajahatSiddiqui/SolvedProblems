package com.wajahat.hackerrank.thirtydaysofcode.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DictioneryAndMaps {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            Map<String, String> map = new HashMap<String, String>(n);
            for (int i = 0; i < n; i++) {
                map.put(scanner.next(), scanner.next());
            }
            String key;
            for (int i = 0; i < n; i++) {
                key = scanner.next();
                if (map.containsKey(key)) {
                    System.out.println(key + "=" + map.get(key));
                } else {
                    System.out.println("Not found");
                }
            }

        }
    }

}
