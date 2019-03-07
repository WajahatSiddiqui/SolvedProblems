package com.wajahat.hackerrank.solution;

import java.util.Scanner;

public class SumVsXOR {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            long n = scanner.nextLong();
            long c = 0;
            while (n != 0) {
                c += (n % 2 != 0) ? 0 : 1;
                n/=2;
            }
            //System.out.println(Double.valueOf((Math.pow(2, c))).intValue());
            System.out.println(1L << c);
        }
    }

}
