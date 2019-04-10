package com.wajahat;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class MaxSubArrayKadanesAlgorithm {

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
    public void testMaxSubArray() {
        assertEquals(6, maxSubArray(Stream.of(-2,1,-3,4,-1,2,1,-5,4).collect(Collectors.toList())));
        assertEquals(-1, maxSubArray(Stream.of(-2,-1,-3,-4,-1,-2,-1,-5,-4).collect(Collectors.toList())));
        assertEquals(-2, maxSubArray(Stream.of(-2).collect(Collectors.toList())));
    }
}
