package com.wajahat.hackerearth;

import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Class Micro Array
 * Created by wajahat
 */
public class MicroAndArrayUpdate {

    private static int minTime(Integer[] arr, int N, int K) {
        int min = Stream.of(arr).min(Comparator.comparing(Integer::intValue)).get();
        return K-min < 0 ? 0 : K-min;
    }

    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        int N, K;
        while (T-- > 0) {
            N = s.nextInt();
            K = s.nextInt();
            Integer []arr = new Integer[N];

            for (int i = 0; i < N; i++) {
                arr[i] = s.nextInt();
            }
            System.out.println(minTime(arr, N, K));
        }
    }
}
