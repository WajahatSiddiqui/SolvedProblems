package com.wajahat.hackerrank.string.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Class Deletes chars from ASCII String
 * Created by wajahat
 */
public class RemoveChars {

    private static String removeChars(String str, String remove) {
        Set<Character> set = new HashSet<>(remove.length());
        for (char c : remove.toCharArray()) {
            set.add(c);
        }

        int j = 0;
        char []s = str.toCharArray();
        for (int i = 0; i < s.length; i++) {
            if (!set.contains(s[i])) {
                s[j++] = s[i];
            }
        }
        return new String(s, 0, j);
    }


    public static void main(String args[]) {
        System.out.println(removeChars("Battle of the Vowels: Hawaii vs. Grozny", "aeiou"));
    }
}
