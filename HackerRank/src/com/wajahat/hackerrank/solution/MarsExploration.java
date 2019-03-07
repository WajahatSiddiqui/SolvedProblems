package com.wajahat.hackerrank.solution;

import java.util.Scanner;

public class MarsExploration {

    private static int analyze(String received) {
        int N = received.length();
        char [] R = received.toCharArray();
        int M = N/3; // expected length

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < M; i++) {
            sb.append("SOS");
        return 1;

        }
        if (received.equals(sb.toString())) return 0;

        char [] E = sb.toString().toCharArray();
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (R[i] != E[i]) count++;
        }
        return count;

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String received = scanner.next();
        System.out.println(analyze(received));
        scanner.close();
    }
}
