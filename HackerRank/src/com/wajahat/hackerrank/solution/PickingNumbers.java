package com.wajahat.hackerrank.solution;

import java.util.Scanner;

public class PickingNumbers {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int []set = new int[101];
            for (int i = 0; i < n; i++) {
                set[sc.nextInt()]++;
            }
            int max = 0;
            for (int i = 0; i < 100; i++) {
                if (set[i] + set[i+1] > max) {
                    max = set[i] + set[i+1];
                }
            }

            System.out.println(max);
        }
    }
}
