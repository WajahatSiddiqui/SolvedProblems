package com.wajahat.hackerrank.solution;

import java.util.Scanner;

public class TaumAndBday {

    private static long minAmtToSpend(long B, long W, long X, long Y, long Z) {
        long amount = 0;
        long newV = 0;
        if (X == Y && Y == Z && X == Z || (Z > X && Z > Y)) {
            amount = B*X + W*Y;
        } else {
            if (X < Y) {
                newV = (X + Z) < Y ? (X + Z) : Y;
                amount = B*X + W*newV;
            } else {
                newV = (Y + Z) < X ? (Y + Z) : X;
                amount = B*newV + W*Y;
            }
        }
        return amount;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            long T = sc.nextLong();
            long B, W, X, Y, Z;
            while (T > 0) {
                B = sc.nextLong();
                W = sc.nextLong();
                X = sc.nextLong();
                Y = sc.nextLong();
                Z = sc.nextLong();
                System.out.println(minAmtToSpend(B, W, X, Y, Z));
                T--;
            }
        }
    }

}
