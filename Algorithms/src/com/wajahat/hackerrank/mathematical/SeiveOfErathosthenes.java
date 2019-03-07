package com.wajahat.hackerrank.mathematical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeiveOfErathosthenes {

    /**
     * T(n) = O(nlogn)
     * @param n - generate till the n
     * @return List of prime numbers
     */
    private static List<Integer> generatePrimes(int n) {
        boolean prime[] = new boolean[n + 1];
        Arrays.fill(prime, true);

        for (int p = 2; p*p <= n; p++) {
            if (prime[p]) {
                for (int i = p*2; i <= n; i+=p) {
                    prime[i] = false;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                list.add(i);
            }
        }
        return list;
    }
}
