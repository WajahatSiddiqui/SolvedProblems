package com.wajahat.interviewbit.hash;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PalidromString {
    boolean isChar(int c) {
        return c >= 'a' && c <= 'z'
                || c >= '0' && c <= '9';
    }

    public int isPalindrome(String A) {
        int l = 0;
        int r = A.length() - 1;
        int leftChar;
        int rightChar;
        A = A.toLowerCase();
        while (l < r) {
            leftChar = A.charAt(l);
            rightChar = A.charAt(r);
            // check for no spl characters
            if (isChar(leftChar) && isChar(rightChar)) {
                if (leftChar != rightChar) {
                    return 0;
                }
                l++;
                r--;
            } else {
                if (!isChar(leftChar)) l++;
                if (!isChar(rightChar)) r--;
            }
        }
        return 1;
    }

    @Test
    public void testIsPalidrome() {
        assertEquals(1, isPalindrome("A man, a plan, a canal: Panama"));
        assertEquals(0, isPalindrome("race a car"));
        assertEquals(1, isPalindrome("ab clkk kklc ba"));
        assertEquals(1, isPalindrome("madamimadam"));
        assertEquals(1, isPalindrome("runner  re n n ur"));
        assertEquals(0, isPalindrome("1a2"));
    }
}
