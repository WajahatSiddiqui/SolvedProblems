package com.wajahat.hackerrank.problems;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Find the substring of the form a?b?c
 * @author Wajahat
 */
public class SubstringInsideString {

    public static boolean find(String str) {
        Pattern p = Pattern.compile("a?b?c");
        return p.matcher(str).matches();
        /*int lo = 0;
        int hi = str.length();

        while (lo < hi) {

        }*/
    }

    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner sc = new Scanner(new FileInputStream(new File("C:\\Users\\Wajahat\\workspace\\github\\SolvedProblems\\StringSequence\\src\\sample_input_substr.txt")))) {
            while (sc.hasNext()) {
                String str = sc.next();
                System.out.println(find(str) ? "Yes" : "No");
            }
        }
    }

}
