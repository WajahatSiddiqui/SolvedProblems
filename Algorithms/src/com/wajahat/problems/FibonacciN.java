package com.wajahat.problems;
public class FibonacciN {
    
    public static void printFibonacci(int n) {
        int a = 0;
        System.out.print(a);

        if (n == 0) return;
        int b = 1;
        System.out.print(" " + b);
        int c = a + b;
        while (true) {
            if (c > n) break;
            System.out.print(" " + c);
            a = b;
            b = c;
            c = a + b;
        }
    }

    public static void main(String args[]) {
        for (int i = 0; i < 100; i++) {
            System.out.print(i + "-> ");
            FibonacciN.printFibonacci(i);
            System.out.println();
        }
    }
}
