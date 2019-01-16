package com.wajahat.string.problems;

/**
 * Class Determine if s2 is rotation of s1
 * Created by wajahat
 */
public class StringRotation {

    /**
     * Checks if s2 is rotation of s1
     * Takes O(NM) time N - length of s1, M - length of s2
     * Best way to use Rabin-Karp or KMP to reduce the time
     * @param s1 - string s1
     * @param s2 - string s2
     * @return true if s2 is rotation of s1
     */
    private static boolean isRotate(String s1, String s2) {
        return (s2+s2).contains(s1);
    }

    public static void main(String args[]) {
        System.out.println(isRotate("waterbottle", "erbottlewat"));
    }
}
