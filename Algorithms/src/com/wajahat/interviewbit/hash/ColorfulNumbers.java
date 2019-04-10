package com.wajahat.interviewbit.hash;

import org.junit.Test;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

// A number is colorful if the product of subset of its number is unique among the given list
public class ColorfulNumbers
{
    public int colorful(int N) {
        Set<Integer> set = new HashSet<>();
        String sNum = Integer.toString(N);
        int len = sNum.length();
        int count = 0;
        int product = 0;
        while (count < len) {
            for (int j = 0; j < len && count + j + 1 <= len; j++) {
                product = getProduct(sNum, j, count + j + 1);
                if (set.contains(product)) return 0;
                set.add(product);
            }
            count++;
        }
        return 1;
    }

    private int getProduct(String sNum, int i, int j) {
        int product = 1;
        for (int idx = i; idx < j; idx++) {
            product *= Integer.valueOf(sNum.charAt(idx)+"");
        }
        return product;
    }

    @Test
    public void testColorful() {
        assertEquals(1, colorful(3245));
        assertEquals(0, colorful(32455));
        assertEquals(0, colorful(123));
        assertEquals(0, colorful(12));
        assertEquals(1, colorful(23));
        assertEquals(1, colorful(239));
        assertEquals(1, colorful(263));
        assertEquals(1, colorful(99));
    }
}
