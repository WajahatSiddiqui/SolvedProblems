package com.wajahat.hackerrank.solution;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Cupcakes {

    private static long findMiles(Integer []calories, int n) {
        Arrays.sort(calories, Collections.reverseOrder());
        long miles = 0;
        for (int i = 0; i < n; i++) {
            miles += Math.pow(2, i) * calories[i];
        }
        return miles;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            Integer[] calories = new Integer[n];
            for(int calories_i=0; calories_i < n; calories_i++){
                calories[calories_i] = Integer.valueOf(in.nextInt());
            }
            System.out.println(findMiles(calories, n));
        }
    }

}
