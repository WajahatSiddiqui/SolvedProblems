package com.wajahat.hackerrank.solution;

import java.util.Arrays;
import java.util.Scanner;

public class PDFViewer {

    private static int getCharCode(char c) {
        return c - 'a';
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int [] h = Arrays.asList(sc.nextLine().split(" " )).stream().mapToInt(Integer::parseInt).toArray();
            String word = sc.next();

            int max_height = 0, height;
            for (int i = 0; i < word.length(); i++) {
                height = h[getCharCode(word.charAt(i))];
                if (height > max_height) {
                    max_height = height;
                }
            }
            System.out.println(max_height * word.length());
        }
    }
}
