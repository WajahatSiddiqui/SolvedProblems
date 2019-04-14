package com.wajahat.hackerrank.solution;

import java.util.Scanner;

public class HappyLadyBugs {

    private static void swap(char [] c, int i1, int i2) {
        char tmp = c[i1];
        c[i1] = c[i2];
        c[i2] = tmp;
    }

    private static boolean isHappy(String b, int n) {
        char []ch = b.toCharArray();
        for (int i = 1; i < n; i++) {
            if (ch[i] == '_') {
                int lastIndex = b.indexOf(ch[i-1]);
                if (lastIndex == -1 || lastIndex == i-1) {
                    return false;
                } else {
                    swap(ch, i, lastIndex);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int g = sc.nextInt();
            while (g > 0) {
                int n = sc.nextInt();
                String b = sc.next();
                System.out.println(isHappy(b, n) ? "YES" : "NO");
                g--;
            }
        }
    }

}
