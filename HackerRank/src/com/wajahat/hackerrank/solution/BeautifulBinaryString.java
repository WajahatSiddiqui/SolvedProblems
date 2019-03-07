package com.wajahat.hackerrank.solution;

import java.util.Scanner;

public class BeautifulBinaryString {

    private static int getBeautifulCount(String binary, int n) {
        int count = 0, index = 0;
        char [] ch = binary.toCharArray();
        while (binary.startsWith("010")) {
            index = binary.indexOf("010");
            if (index != -1) {
                ch[index+2] = '1';
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            String binary = sc.next();
            System.out.println(getBeautifulCount(binary, n));
        }
    }

}
