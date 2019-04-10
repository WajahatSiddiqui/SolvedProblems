package com.wajahat;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class MaxSubArrayKadanesAlgorithm {

    public int kadane(final List<Integer> A) {
        int N = A.size();
        int maxSoFar = 0;
        int maxEndingHere = 0;
        for (int i = 0; i < N; i++) {
            maxEndingHere += A.get(i);
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            } else if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
            }
        }
        return maxSoFar;
    }

    // Handling all negatives
    public int maxSubArray(final List<Integer> A) {
        int maxSoFar = A.get(0);
        int currMax = A.get(0);

        int N = A.size();

        for (int i = 1; i < N; i++) {
            currMax = Math.max(A.get(i), currMax + A.get(i));
            maxSoFar = Math.max(currMax, maxSoFar);
        }
        return maxSoFar;
    }

    @Test
    public void testKadane() {
        assertEquals(6, kadane(Stream.of(-2,1,-3,4,-1,2,1,-5,4).collect(Collectors.toList())));
        assertEquals(0, kadane(Stream.of(-2,-1,-3,-4,-1,-2,-1,-5,-4).collect(Collectors.toList())));
        assertEquals(0, kadane(Stream.of(-2).collect(Collectors.toList())));
        assertEquals(1000, kadane(Stream.of(1000).collect(Collectors.toList())));
    }

    @Test
    public void testMaxSubArray() {
        assertEquals(6, maxSubArray(Stream.of(-2,1,-3,4,-1,2,1,-5,4).collect(Collectors.toList())));
        assertEquals(-1, maxSubArray(Stream.of(-2,-1,-3,-4,-1,-2,-1,-5,-4).collect(Collectors.toList())));
        assertEquals(-2, maxSubArray(Stream.of(-2).collect(Collectors.toList())));
    }
}
