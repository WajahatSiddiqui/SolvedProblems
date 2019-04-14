package com.wajahat.hackerrank.string.problems;

import java.util.HashMap;
import java.util.Map;


public class Sequence {

    private static int lengthOfLongestSubstring(String str) {
        Map<Character, Integer> map = new HashMap<>();
        int len = str.length();
        char key;
        for (int i = 0; i < len; i++) {
            key = str.charAt(i);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        return map.values().stream().mapToInt(Integer::intValue).max().getAsInt();
    }

    public static void main(String[] args) {
        String str = "aaabbcccdddddee";
        System.out.println(lengthOfLongestSubstring(str));
    }

}
