package com.wajahat.hackerrank.solution;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SockMerchant {
    static int sockMerchant(int n, int[] ar) {
        Set<Integer> set = new HashSet<>(n);
        int socks = 0;
        for (int a : ar) {
            if (set.contains(a)) {
                socks++;
                set.remove(a);
            } else {
                set.add(a);
            }
        }
        return socks;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = sockMerchant(n, ar);
        System.out.println(result);
        in.close();
    }
}
