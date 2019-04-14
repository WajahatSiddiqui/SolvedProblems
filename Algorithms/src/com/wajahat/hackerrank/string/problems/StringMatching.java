package com.wajahat.hackerrank.string.problems;

import java.util.Scanner;


public class StringMatching {
    private static int findMatch(char []T, char []P, int N, int M) {
        int i = 0, j = 0, k = 0;
        while (i < N && j < M) {
            if (T[i] == P[j]) {
                i++;
                j++;
            } else {
                j = 0;
                k++;
                i = k;
            }
            if (j == M) return k;
        }
        return -1;
    }

    private static int findNoOfOccurances(char []T, char []P, int N, int M) {
        int i = 0, j = 0, k = 0, count = 0;
        while (i < N && j < M) {
            if (T[i] == P[j]) {
                i++;
                j++;
            } else {
                j = 0;
                k++;
                i = k;
            }
            if (j == M) {
                count++;
                j = 0;
                k = i-1;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        /*    String T = "sadasda";
        String P = "sda";
        System.out.println("Match: " + findMatch(T.toCharArray(), P.toCharArray(),
                T.length(), P.length()));*/
        Scanner scanner = new Scanner(System.in);
        String P = scanner.nextLine();
        String T = scanner.nextLine();
        System.out.println(findNoOfOccurances(T.toCharArray(), P.toCharArray(), T.length(), P.length()));
        scanner.close();
    }

}
