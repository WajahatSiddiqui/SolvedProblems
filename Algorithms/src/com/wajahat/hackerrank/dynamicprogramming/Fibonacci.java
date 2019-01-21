package com.wajahat.hackerrank.dynamicprogramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Class Generate nth fibonacci number
 * Created by wajahat
 */
public class Fibonacci {

    int fibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    int fibonacciBUP(int n) {
        int [] T = new int[n+1];
        T[0] = 0;
        T[1] = 1;
        for (int i = 2; i < n+1; i++) {
            T[i] = T[i-1] + T[i-2];
        }
        return T[n];
    }

    int fibonacciTDNUtil(int n, int [] memory) {
        if (memory[n] != 0) return memory[n];
        memory[n] = fibonacciTDNUtil(n-1, memory) + fibonacciTDNUtil(n-2, memory);
    }

    int fibonacciTDN(int n) {
        int [] memory = new int[n+1];
        memory[0] = 0;
        memory[1] = 1;
        return fibonacciTDNUtil(n, memory);
    }

    @Test
    public void testFibonacci() {
        assertEquals(55, fibonacci(10));
        assertEquals(55, fibonacciBUP(10));
        assertEquals(55, fibonacciTDN(10));
    }
}
