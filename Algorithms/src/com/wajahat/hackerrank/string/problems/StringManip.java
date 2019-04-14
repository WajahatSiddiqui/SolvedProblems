package com.wajahat.hackerrank.string.problems;

import java.util.Scanner;

public class StringManip {

    public static int partition(char [] c, int lo, int hi) {
        char pivot = c[hi];
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (c[j] > pivot) {
                i++;
                char tmp = c[j];
                c[j] = c[i];
                c[i] = tmp;
            }
        }
        char tmp = c[i+1];
        c[i+1] = c[hi];
        c[hi] = tmp;
        return i + 1;

    }

    public static void quickSort(char [] c, int lo, int hi) {
        if (lo < hi) {
            int pivot = partition(c, lo, hi);
            quickSort(c, lo, pivot - 1);
            quickSort(c, pivot + 1, hi);
        }
    }
    public static void arrange(String str, int N, int M) {
        char[] c = str.toCharArray();
        quickSort(c, N, M);

        //char tmp;
        //int maxIndex;
        /*for (int i = N; i <= M; i++) {
            maxIndex = i;
            for (int j = i+1; j <= M; j++) {
                if (c[maxIndex] < c[j]) {
                    maxIndex = j;
                }
            }
            if (c[i] != c[maxIndex]) {
                tmp = c[i];
                c[i] = c[maxIndex];
                c[maxIndex] = tmp;
            }
        }*/
        System.out.println(c);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T > 0) {
            String str = scanner.next();
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            arrange(str, N, M);
            T--;
        }

        scanner.close();
    }
}
