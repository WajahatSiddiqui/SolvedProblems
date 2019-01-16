package com.wajahat.string.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Class Check the permutation of palidrome is palidrome
 * Created by wajahat
 */
public class PalidromePermutation {

    private static boolean isPalid(String permute) {
        Set<Character> visited = new HashSet<>(permute.length());
        for (char c : permute.toCharArray()) {
            if (!((c >= 'a' && c <= 'z')
                    || (c >= 'A' && c <= 'Z')
                    || (c >= '0' && c <= '9'))) continue;

            if (visited.contains(c)) {
                visited.remove(c);
            } else {
                visited.add(c);
            }
        }
        return visited.size() < 2;
    }
    public static void main(String args[]) {
        System.out.println(isPalid("taco cat"));
        System.out.println(isPalid("amddm"));
        System.out.println(isPalid("amddm1"));
        System.out.println(isPalid("atco cta"));
    }
}
