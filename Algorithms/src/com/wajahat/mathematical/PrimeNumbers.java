package com.wajahat.mathematical;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Handling Prime Numbers
 * Created by wajahat
 */
public class PrimeNumbers {

    private static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    /**
     * T(n) = O(n^2)
     * @param n - generate till the n
     * @return List of prime numbers
     */
    private static List<Integer> generatePrime(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                list.add(i);
            }
        }
        return list;
    }

    private static boolean isPrimeImprove(int n) {
        for (int i = 2; i*i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }


    /**
     * T(n) = O(sqrt(n))
     * @param n - generate till the n
     * @return List of prime numbers
     */
    private static List<Integer> generatePrimeImprove(int n) {
        List<Integer> list = new ArrayList<>();
        if (n >= 2) {
            list.add(2);
        }
        for (int i = 3; i <= n; i+=2) {
            if (isPrime(i)) {
                list.add(i);
            }
        }
        return list;
    }

}
