package com.wajahat.string.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Check permutation of another string
 * Created by Wajahat
 **/
public class CheckPermute {

    private static boolean isPermute(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        Set<Character> visited = new HashSet<>(str1.length());
        for (char c : str1.toCharArray()) {
            visited.add(c);
        }
        for (char c : str2.toCharArray()) {
            if (!visited.contains(c)) return false;
        }
        return true;
    }
    public static void main(String args[]) {
        System.out.println(isPermute("dog", "god"));
        System.out.println(isPermute("abdfds", "fbdasd"));
        System.out.println(isPermute("abdfds", "fbdasd1"));
    }
}
