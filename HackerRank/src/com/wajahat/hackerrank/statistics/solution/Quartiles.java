package com.wajahat.hackerrank.statistics.solution;

import java.util.Arrays;
import java.util.Scanner;

public class Quartiles {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            sc.nextLine();
            int [] x = Arrays.asList(sc.nextLine().split(" "))
                    .stream().mapToInt(Integer::parseInt).toArray();
            Arrays.sort(x);
            int q1 = 0, q2 = 0, q3 = 0;
            if (N % 2  == 0) {
                q2 = (x[N/2 - 1] + x[N/2])/2;
            } else {
                q2 = x[N/2];
            }

            if (N/2 % 2 == 0) {
                q1 = (x[N/4 - 1] + x[N/4])/2;
                q3 = (x[3*(N/4)] + x[3*(N/4) + 1])/2;
            } else {
                q1 = x[N/4];
                q3 = x[3*(N/4)];
            }

            System.out.printf("%d\n%d\n%d", q1, q2, q3);

        }
    }

}
