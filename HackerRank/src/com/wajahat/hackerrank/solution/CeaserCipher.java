package com.wajahat.hackerrank.solution;

import java.util.Scanner;

public class CeaserCipher {


    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            String str = sc.next();
            int k = sc.nextInt() % 26;
            StringBuffer sb = new StringBuffer(str);
            int num;
            for (int i = 0; i < n; i++) {
                num = 0;
                int ch = (int) str.charAt(i);
                // upper case
                if (ch >= 65 && ch <= 90) {
                    num = ch + k;
                    // normalize
                    if (num > 90) {
                        num = 64 + (num - 90);
                    }
                    sb.setCharAt(i, (char) (num - '\0'));
                }

                // lower case
                if (ch >= 97 && ch <= 122) {
                    num = ch + k;
                    // normalize
                    if (num > 122) {
                        num = 96 + (num - 122);
                    }
                    sb.setCharAt(i, (char) (num - '\0'));
                }
            }
            System.out.println(sb.toString());
        }
    }
}
